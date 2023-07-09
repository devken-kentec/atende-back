package br.com.kentec.atendetec.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.atendetec.domain.Calendario;
import br.com.kentec.atendetec.domain.Orgao;
import br.com.kentec.atendetec.domain.Servidor;
import br.com.kentec.atendetec.domain.Unidade;
import br.com.kentec.atendetec.repository.UploadNativeRepository;

@Service
public class UploadService {
	
	@Autowired
	private UploadNativeRepository unr;
	
	public void lerCalendario(String caminho) throws IOException {
		
		String c1 = "";
		String c2 = "";
		String c3 = "";
		
		Calendario calendario = new Calendario();
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					c1 = cell.getStringCellValue();
					break;
				case 1:
					c2 = cell.getStringCellValue();
					break;
				case 2:
					c3 = cell.getStringCellValue();
					break;	
				}
			}
			
			calendario.setDia(c1);
			calendario.setObservacao(c2);
			calendario.setStatusCalendario(c3);
			
			if(calendario.getDia() != "" && calendario.getObservacao() != "" && calendario.getStatusCalendario() != "") {
				unr.saveQueryNativeCalendario(calendario);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
	}
	
	public void lerGrade(String caminho) throws IOException {
		
		String g1 = "";
		Integer g2 = 0;
		String g3 = "";
		String g4 = "";
		String g5 = "";
		Integer g6 = 0;
		Integer g7 = 0;
		Integer g8 = 0;
		Integer g9 = 0;
		Integer g10 = 0;
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					g1 = cell.getStringCellValue();
					break;
				case 1:
					g2 = (int) cell.getNumericCellValue();
					break;
				case 2:
					g3 = cell.getStringCellValue();
					break;	
				case 3:
					g4 = cell.getStringCellValue();
					break;
				case 4:
					g5 = cell.getStringCellValue();
					break;	
				case 5:
					g6 = (int) cell.getNumericCellValue();
					break;	
				case 6:
					g7 = (int) cell.getNumericCellValue();
					break;	
				case 7:
					g8 = (int) cell.getNumericCellValue();
					break;	
				case 8:
					g9 = (int) cell.getNumericCellValue();
					break;		
				case 9:
					g10 = (int) cell.getNumericCellValue();
					break;		
				}
			}
			
			String[] celulas = { g1, g2.toString(), g3, g4, g5, g6.toString(), g7.toString(), g8.toString(), g9.toString(), g10.toString() }; 
			
			if(celulas[0] != "" && celulas[1] != "" && celulas[2] != "" && celulas[3] != "" && celulas[4] != ""
					 && celulas[5] != "" &&  celulas[6] != "" ) {
				unr.saveQueryNativeGrade(celulas);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
	}
	
	public void lerServico(String caminho) throws IOException {
		
		String s1 = "";
		String s2 = "";
		Integer s3 = 0;
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					s1 = cell.getStringCellValue();
					break;
				case 1:
					s2 = cell.getStringCellValue();
					break;
				case 2:
					s3 = (int) cell.getNumericCellValue();
					break;	
				}
			}
				
			String[] celulas = { s1, s2, s3.toString() };
			
			if(celulas[0] != "" && celulas[1] != "" && celulas[2] != "") {
				unr.saveQueryNativeServico(celulas);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
	}

	public void lerDetalheServico(String caminho) throws IOException {
		
		String ds1 = "";
		String ds2 = "";
		Integer ds3 = 0;
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					ds1 = cell.getStringCellValue();
					break;
				case 1:
					ds2 = cell.getStringCellValue();
					break;
				case 2:
					ds3 = (int) cell.getNumericCellValue();
					break;	
				}
			}
				
			String[] celulas = { ds1, ds2, ds3.toString() };
			
			if(celulas[0] != "" && celulas[1] != "" && celulas[2] != "") {
				unr.saveQueryNativeDetalheServico(celulas);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
	}

	public void lerUnidade(String caminho) throws IOException {
		
		String u1 = "";
		String u2 = "";
		String u3 = "";
		String u4 = "";
		String u5 = null;
		
		Unidade unidade = new Unidade();
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					u1 = cell.getStringCellValue();
					break;
				case 1:
					u2 = cell.getStringCellValue();
					break;
				case 2:
					u3 = cell.getStringCellValue();
					break;	
				case 3:
					u4 = cell.getStringCellValue();
					break;
				case 4:
					u5 = cell.getStringCellValue();
					break;
				}
			}
				
			unidade.setCodigo(u1.toString());
			unidade.setDescricao(u2);
			unidade.setEndereco(u3);
			unidade.setSigla(u4);
			unidade.setTelefone(Long.parseLong(u5));
			
			if(unidade.getCodigo() != "" && unidade.getDescricao() != "" && unidade.getEndereco() != "" && unidade.getSigla() != "" && unidade.getTelefone() != null) {
				unr.saveQueryNativeUnidade(unidade);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
	}

	public void lerOrgao(String caminho) throws IOException {
		
		String o1 = "";
		String o2 = "";
		String o3 = "";
		
		Orgao orgao = new Orgao();
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					o1 = cell.getStringCellValue();
					break;
				case 1:
					o2 = cell.getStringCellValue();
					break;
				case 2:
					o3 = cell.getStringCellValue();
					break;	
				}
			}
			
			orgao.setCodigo(o1);
			orgao.setDescricao(o2);
			orgao.setSigla(o3);
			
			if(orgao.getCodigo() != "" && orgao.getDescricao() != "" && orgao.getSigla() != "") {
				unr.saveQueryNativeOrgao(orgao);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
	}

	public void lerServidor(String caminho) throws IOException {
		
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String s6 = "";
		String s7 = "";
		
		Servidor servidor = new Servidor();
		
		String fileName = caminho;
		
		FileInputStream stream = new FileInputStream(fileName);
		
		HSSFWorkbook workbook = new HSSFWorkbook(stream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
			
			Row row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getColumnIndex()) {
				case 0:
					s1 = cell.getStringCellValue();
					break;
				case 1:
					s2 = cell.getStringCellValue();
					break;
				case 2:
					s3 = cell.getStringCellValue();
					break;	
				case 3:
					s4 = cell.getStringCellValue();
					break;		
				case 4:
					s5 = cell.getStringCellValue();
					break;
				case 5:
					s6 = cell.getStringCellValue();
					break;
				case 6:
					s7 = cell.getStringCellValue();
					break;	
				}
			}
			
			servidor.setMatricula(s1);
			servidor.setCpf(s2);
			servidor.setEmail(s3);
			servidor.setLotacao(s4);
			servidor.setNome(s5);
			servidor.setStatusServidor(s6);
			servidor.setTelefone(s7);
			
			if(servidor.getMatricula() != "" && servidor.getNome() != "" && servidor.getCpf() != "") {
				unr.saveQueryNativeServidor(servidor);
			} else {
				break;
			}
			workbook.close();
			stream.close();	
		}
		
	}
}
