package br.com.kentec.atendetec.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DataService {
	
	public LocalDate dataHoje() {
		LocalDate dataHoje = LocalDate.now();
		return dataHoje;
	}
	
	public LocalDateTime now() {
		LocalDateTime now = LocalDateTime.now();
		return now;
	}
	
	public LocalDateTime dataPainel() {
		String dataSemFormato = this.dataHoje().toString();
		String dataCerta = dataSemFormato+"T00:00:00.000000000";
		LocalDateTime data = LocalDateTime.parse(dataCerta);
		return data;
	}
	
	public String dataAtual() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
	}
	
	public String dataAtualBanco() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
	}
}
