package br.com.kentec.atendetec.service;

import java.io.File;
//import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;

//import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.atendetec.domain.Fila;
import br.com.kentec.atendetec.domain.Painel01;
import br.com.kentec.atendetec.domain.Painel02;
import br.com.kentec.atendetec.domain.Painel03;
import br.com.kentec.atendetec.domain.Painel04;
import br.com.kentec.atendetec.domain.Painel05;
import br.com.kentec.atendetec.domain.Painel06;
import br.com.kentec.atendetec.repository.Painel01Repository;
import br.com.kentec.atendetec.repository.Painel02Repository;
import br.com.kentec.atendetec.repository.Painel03Repository;
import br.com.kentec.atendetec.repository.Painel04Repository;
import br.com.kentec.atendetec.repository.Painel05Repository;
import br.com.kentec.atendetec.repository.Painel06Repository;

@Service
public class PainelService {
	
	@Autowired
	private Painel01Repository pr01;
	
	@Autowired
	private Painel02Repository pr02;
	
	@Autowired
	private Painel03Repository pr03;
	
	@Autowired
	private Painel04Repository pr04;
	
	@Autowired
	private Painel05Repository pr05;
	
	@Autowired
	private Painel06Repository pr06; 
	
	@Autowired
	private DataService ds;
		
	//Funções Painel 01
	public Iterable<Painel01> listarPainel01(){
		return pr01.findByfive(ds.dataPainel());
	}
	
	public Optional<Painel01> listarChamada(){
		
		Optional<Painel01> getChamada = null;
		Optional<Painel01> getPainel = pr01.findByChamada();
		
		if(getPainel.get().getChamar().equals(true)) {
			getChamada = getPainel;
			this.som();
			this.atualizarPainel01(getPainel.get().getFilaId());
		} else {
			getChamada = getPainel;
		}
		
		return getChamada;
	}
	
	public void atualizarPainel01(Long filaId) {
		Optional<Painel01> p01 = pr01.findByFilaId(filaId);
		if(p01.isPresent()) {
			p01.get().setChamar(false);
			pr01.save(p01.get());
 		}
	}
	
	//Funções Painel 02
	public Iterable<Painel02> listarPainel02(){
		return pr02.findByfive(ds.dataPainel());
	}
	
	public Optional<Painel02> listarChamada2(){
		
		Optional<Painel02> getChamada = null;
		Optional<Painel02> getPainel = pr02.findByChamada();
		
		if(getPainel.get().getChamar().equals(true)) {
			getChamada = getPainel;
			this.som();
			this.atualizarPainel02(getPainel.get().getFilaId());
		} else {
			getChamada = getPainel;
		}
		
		return getChamada;
	}
	
	public void atualizarPainel02(Long filaId) {
		Optional<Painel02> p02 = pr02.findByFilaId(filaId);
		if(p02.isPresent()) {
			p02.get().setChamar(false);
			pr02.save(p02.get());
 		}
	}
	
	//Painel 03
	public Iterable<Painel03> listarPainel03(){
		return pr03.findByfive(ds.dataPainel());
	}
	
	public Optional<Painel03> listarChamada03(){
		
		Optional<Painel03> getChamada = null;
		Optional<Painel03> getPainel = pr03.findByChamada();
		
		if(getPainel.get().getChamar().equals(true)) {
			getChamada = getPainel;
			this.som();
			this.atualizarPainel03(getPainel.get().getFilaId());
		} else {
			getChamada = getPainel;
		}
		
		return getChamada;
	}
	
	public void atualizarPainel03(Long filaId) {
		Optional<Painel03> p03 = pr03.findByFilaId(filaId);
		if(p03.isPresent()) {
			p03.get().setChamar(false);
			pr03.save(p03.get());
 		}
	}
	
	//Funções Painel 04
	public Iterable<Painel04> listarPainel04(){
		return pr04.findByfive(ds.dataPainel());
	}
	
	public Optional<Painel04> listarChamada04(){
		
		Optional<Painel04> getChamada = null;
		Optional<Painel04> getPainel = pr04.findByChamada();
		
		if(getPainel.get().getChamar().equals(true)) {
			getChamada = getPainel;
			this.som();
			this.atualizarPainel04(getPainel.get().getFilaId());
		} else {
			getChamada = getPainel;
		}
		
		return getChamada;
	}
	
	public void atualizarPainel04(Long filaId) {
		Optional<Painel04> p04 = pr04.findByFilaId(filaId);
		if(p04.isPresent()) {
			p04.get().setChamar(false);
			pr04.save(p04.get());
 		}
	}
	
	//Funções Painel 05
	public Iterable<Painel05> listarPainel05(){
		return pr05.findByfive(ds.dataPainel());
	}
	
	public Optional<Painel05> listarChamada05(){
		
		Optional<Painel05> getChamada = null;
		Optional<Painel05> getPainel = pr05.findByChamada();
		
		if(getPainel.get().getChamar().equals(true)) {
			getChamada = getPainel;
			this.som();
			this.atualizarPainel05(getPainel.get().getFilaId());
		} else {
			getChamada = getPainel;
		}
		
		return getChamada;
	}
	
	public void atualizarPainel05(Long filaId) {
		Optional<Painel05> p05 = pr05.findByFilaId(filaId);
		if(p05.isPresent()) {
			p05.get().setChamar(false);
			pr05.save(p05.get());
 		}
	}
	
	//Funções Painel 06
	public Iterable<Painel06> listarPainel06(){
		return pr06.findByfive(ds.dataPainel());
	}
	
	public Optional<Painel06> listarChamada06(){
		
		Optional<Painel06> getChamada = null;
		Optional<Painel06> getPainel = pr06.findByChamada();
		
		if(getPainel.get().getChamar().equals(true)) {
			getChamada = getPainel;
			this.som();
			this.atualizarPainel06(getPainel.get().getFilaId());
		} else {
			getChamada = getPainel;
		}
		
		return getChamada;
	}
	
	public void atualizarPainel06(Long filaId) {
		Optional<Painel06> p06 = pr06.findByFilaId(filaId);
		if(p06.isPresent()) {
			p06.get().setChamar(false);
			pr06.save(p06.get());
 		}
	}
	
	//Função que grava a tabela
	public void gerarPainel(Optional<Fila> fila) {
		
		if(fila.get().getUnidade().equals("Unidade Paço Municipal")) {
			Optional<Painel01> p01 = pr01.findByFilaId(fila.get().getId());
			
			if(p01.isPresent()) {
				p01.get().setChamada(LocalDateTime.now());
				p01.get().setChamar(true);
				pr01.save(p01.get());
	 		} else {
				Painel01 p = new Painel01();
				p.setFilaId(fila.get().getId());
				p.setSenha(fila.get().getSenha());
				p.setGuiche(fila.get().getAtendente().getGuiche().getDescricao());
				p.setServico(fila.get().getDetalhamentoServico());
				p.setUnidade(fila.get().getUnidade());
				p.setChamada(LocalDateTime.now());
				p.setPrioridade(fila.get().getPrioridade());
				p.setChamar(true);
					
				pr01.save(p);
			}
		} else if(fila.get().getUnidade().equals("Unidade Cidade Jardim")) {
			Optional<Painel02> p02 = pr02.findByFilaId(fila.get().getId());
			
			if(p02.isPresent()) {
				p02.get().setChamada(LocalDateTime.now());
				p02.get().setChamar(true);
				pr02.save(p02.get());
	 		} else {
				Painel02 p = new Painel02();
				p.setFilaId(fila.get().getId());
				p.setSenha(fila.get().getSenha());
				p.setGuiche(fila.get().getAtendente().getGuiche().getDescricao());
				p.setServico(fila.get().getDetalhamentoServico());
				p.setUnidade(fila.get().getUnidade());
				p.setChamada(LocalDateTime.now());
				p.setPrioridade(fila.get().getPrioridade());
				p.setChamar(true);
					
				pr02.save(p);
			}
		} else if(fila.get().getUnidade().equals("Unidade Estação Ferroviária")) {
			Optional<Painel03> p03 = pr03.findByFilaId(fila.get().getId());
			
			if(p03.isPresent()) {
				p03.get().setChamada(LocalDateTime.now());
				p03.get().setChamar(true);
				pr03.save(p03.get());
	 		} else {
				Painel03 p = new Painel03();
				p.setFilaId(fila.get().getId());
				p.setSenha(fila.get().getSenha());
				p.setGuiche(fila.get().getAtendente().getGuiche().getDescricao());
				p.setServico(fila.get().getDetalhamentoServico());
				p.setUnidade(fila.get().getUnidade());
				p.setChamada(LocalDateTime.now());
				p.setPrioridade(fila.get().getPrioridade());
				p.setChamar(true);
					
				pr03.save(p);
			}
		} else if(fila.get().getUnidade().equals("Unidade Mangalô")) {
			Optional<Painel04> p04 = pr04.findByFilaId(fila.get().getId());
			
			if(p04.isPresent()) {
				p04.get().setChamada(LocalDateTime.now());
				p04.get().setChamar(true);
				pr04.save(p04.get());
	 		} else {
				Painel04 p = new Painel04();
				p.setFilaId(fila.get().getId());
				p.setSenha(fila.get().getSenha());
				p.setGuiche(fila.get().getAtendente().getGuiche().getDescricao());
				p.setServico(fila.get().getDetalhamentoServico());
				p.setUnidade(fila.get().getUnidade());
				p.setChamada(LocalDateTime.now());
				p.setPrioridade(fila.get().getPrioridade());
				p.setChamar(true);
					
				pr04.save(p);
			}
		} else if(fila.get().getUnidade().equals("Unidade Praça da Bíblia")) {
			Optional<Painel05> p05 = pr05.findByFilaId(fila.get().getId());
			
			if(p05.isPresent()) {
				p05.get().setChamada(LocalDateTime.now());
				p05.get().setChamar(true);
				pr05.save(p05.get());
	 		} else {
				Painel05 p = new Painel05();
				p.setFilaId(fila.get().getId());
				p.setSenha(fila.get().getSenha());
				p.setGuiche(fila.get().getAtendente().getGuiche().getDescricao());
				p.setServico(fila.get().getDetalhamentoServico());
				p.setUnidade(fila.get().getUnidade());
				p.setChamada(LocalDateTime.now());
				p.setPrioridade(fila.get().getPrioridade());
				p.setChamar(true);
					
				pr05.save(p);
			}
		} else if(fila.get().getUnidade().equals("Unidade CRC")) {
			Optional<Painel06> p06 = pr06.findByFilaId(fila.get().getId());
			
			if(p06.isPresent()) {
				p06.get().setChamada(LocalDateTime.now());
				p06.get().setChamar(true);
				pr06.save(p06.get());
	 		} else {
				Painel06 p = new Painel06();
				p.setFilaId(fila.get().getId());
				p.setSenha(fila.get().getSenha());
				p.setGuiche(fila.get().getAtendente().getGuiche().getDescricao());
				p.setServico(fila.get().getDetalhamentoServico());
				p.setUnidade(fila.get().getUnidade());
				p.setChamada(LocalDateTime.now());
				p.setPrioridade(fila.get().getPrioridade());
				p.setChamar(true);
					
				pr06.save(p);
			}
		}
	}
	
	public void som() {
		/*try {
			
		    File yourFile = new File("src\\main\\resources\\static\\teste02.wav");
		    
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    stream = AudioSystem.getAudioInputStream(yourFile);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		}
		catch (Exception e) {
			 e.printStackTrace();
	         System.exit(1);
		}*/
		
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("teste02.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
}
