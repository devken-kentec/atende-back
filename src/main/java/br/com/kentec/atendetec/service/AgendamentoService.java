package br.com.kentec.atendetec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.atendetec.domain.Agendamento;
import br.com.kentec.atendetec.domain.Contribuinte;
import br.com.kentec.atendetec.domain.DetalhamentoServico;
import br.com.kentec.atendetec.domain.Grade;
import br.com.kentec.atendetec.dto.AgendamentoDto;
import br.com.kentec.atendetec.dto.EmissorDeSenhaDto;
import br.com.kentec.atendetec.repository.AgendamentoNativeReposiroty;
import br.com.kentec.atendetec.repository.AgendamentoRepository;
import br.com.kentec.atendetec.repository.ContribuinteRepository;
import br.com.kentec.atendetec.repository.DetalhamentoServicoRepository;
import br.com.kentec.atendetec.repository.GradeRepository;

@Service
public class AgendamentoService {
	
	private Agendamento agendamento = new Agendamento();
	
	@Autowired
	private GradeRepository gr;
	
	@Autowired
	private AgendamentoRepository ar;
	
	@Autowired
	private AgendamentoNativeReposiroty anr;
	
	@Autowired
	private ContribuinteRepository cr;
	
	@Autowired
	private DetalhamentoServicoRepository dsr;
	
	public Optional<Agendamento> AgendamentoById(Long id){
		return ar.findById(id);
	}
	
	public Optional<EmissorDeSenhaDto> AgendaById(Long id){
		return ar.findById(id).map(EmissorDeSenhaDto::new);
	}
	
	public void gerarAgenda(Long id) {
		
		Grade grade = gr.findById(id).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Grade não Encontrada"));
		
		agendamento.setStatusAgendamento("Em espera");
		
		String horaI = grade.getHoraInicial();
		String horaIH = horaI.substring(0, 2);
		String horaIM = horaI.substring(3, 5);
		Integer horaIHM = Integer.parseInt(horaIH) * 60;
		Integer horaIMP = Integer.parseInt(horaIM);
		Integer horaITM = horaIHM + horaIMP;
		Integer interVagas = grade.getCorrecaoHora();
		
		/*System.out.println("Identificador: " + grade.getId());
		System.out.println("Hora Inicial: " + grade.getHoraInicial());
		System.out.println("Intervalo : " + grade.getIntervalo());
		System.out.println("Quantidade: " + grade.getQuantidade());		
		System.out.println("Hora:" + horaIH + " Minuto:" + horaIM);
		System.out.println("Horas em minutos: " + horaITM);
		System.out.println("Intervalo: " +  interVagas);*/
		
		for(Integer i = 1; i <= grade.getQuantidade(); i++) {
			//System.out.println("id:"+ i + " Hora: " +  ajustaHora(horaITM));
			String seq = i.toString();
			grade.setGerado("g");
			agendamento.setGrade(grade);
			agendamento.setSequencial(seq);
			agendamento.setSenha(grade.getServico().getSigla() + "-" + ajustaHora(horaITM));
			agendamento.setHorario(ajustaHora(horaITM));
			horaITM = horaITM + interVagas;
			
			anr.saveQueryNative(agendamento);
		}
	}
	
	public Iterable<Agendamento> listarAgendamento(){
		return ar.findAll();
	}
	
	public List<Agendamento> buscaAvancada(String unidade, String dataInicial, String dataFinal, String servico, String statusAgendamento) {
		return ar.buscaAvancada(unidade, dataInicial, dataFinal, servico, statusAgendamento);
	}
	
	public List<Agendamento> agendaContribuinte(String calendario, String unidade){
		return ar.agendaContribuinte(calendario, unidade);
	}
	
	public List<Agendamento> findByAgendamentoCpfCnpj(String cpfCnpj){
		return ar.findByAgendamentoCpfCnpj(cpfCnpj);
	}
	
	public List<Agendamento> findByAgendamentoCpfCnpjAtivado(String cpfCnpj){
		return ar.findByAgendamentoCpfCnpjAtivado(cpfCnpj);
	}
	
	public Page<Agendamento> listarAgendamento(Integer page, Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, "id");
		return ar.findAll(pageRequest) ;
	}
	
	public void enviar(AgendamentoDto agendamentoDto) {

		Contribuinte contribuinte = cr.findById(agendamentoDto.getContribuinte()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contribuinte não encontrado"));
		
		DetalhamentoServico detalhamentoServico = dsr.findById(1L).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Detalhamento de servico não encontrado")); 
		
		Agendamento agendamento = ar.findById(agendamentoDto.getId()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento não encontrado"));
		
		agendamento.setPrioridade("Em espera");
		agendamento.setStatusAgendamento("Agendado");
		agendamento.setContribuinte(contribuinte);
		agendamento.setDetalhamentoServico(detalhamentoServico);
		agendamento.setAceite(agendamentoDto.getAceite());
		
		
		ar.save(agendamento);
	}
	
	public void gerarFila(Long id) {
		Agendamento agendamento = ar.findById(id).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento não encontrado"));
		
		agendamento.setStatusAgendamento("Ativado");
		
		ar.save(agendamento);
	}
	
	public void atualizarAgendamento(Long id, String prioridade, Long detalhamentoServicoId) {
		
		Agendamento agendamento = ar.findById(id).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento não encontrado"));
		
		DetalhamentoServico detalhamentoServico = dsr.findById(detalhamentoServicoId).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Detalhamento de servico não encontrado")); 
		
		agendamento.setPrioridade(prioridade);
		agendamento.setDetalhamentoServico(detalhamentoServico);
		
		ar.save(agendamento);
	}
	
	public void encaixeTecnico(Long id, String cpfCnpj) {

		Contribuinte contribuinte = cr.findByCpfCnpj(cpfCnpj);
		
		DetalhamentoServico detalhamentoServico = dsr.findById(1L).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Detalhamento de servico não encontrado")); 
		
		Agendamento agendamento = ar.findById(id).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento não encontrado"));
		
		agendamento.setPrioridade("Em espera");
		agendamento.setStatusAgendamento("Agendado");
		agendamento.setContribuinte(contribuinte);
		agendamento.setDetalhamentoServico(detalhamentoServico);
		agendamento.setAceite(true);
		
		ar.save(agendamento);
	}
	
	 
	public String ajustaHora(Integer horaM) {
		
		String hora =" ";
		Integer difHoraI = horaM/60;
		Integer difHoraM = horaM%60;
		String h = difHoraI.toString();
		String m = difHoraM.toString(); 
		
		if(h.length() == 1) {
			h = "0"+h;
		}
		
		if(m.length() == 1) {
			m = "0"+m;
		}
		hora = h + ":" + m;
		return hora;
	}
	
	public void excluirAgendamento(Long gradeId) {
		Optional<Grade> grade = gr.findById(gradeId);
		if(grade.isPresent()) {
			ar.excluirAgendamento(gradeId);
		}
	}
	
	public void liberarAgendamento(Long idAgendamento) {
		Optional<Agendamento> agendamento = ar.findById(idAgendamento);
		if(agendamento.isPresent()) {
			agendamento.get().setAceite(null);
			agendamento.get().setPrioridade(null);
			agendamento.get().setStatusAgendamento("Em espera");
			agendamento.get().setContribuinte(null);
			agendamento.get().setDetalhamentoServico(null);
			
			ar.save(agendamento.get());
		}
	}
}
