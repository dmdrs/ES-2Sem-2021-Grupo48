package application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JTextArea;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


class HistoricoTest {

	static String enterKey = System.getProperty("line.separator");
	static Historico h1;
	private BufferedWriter writer2;
	private BufferedReader reader2;
	private FileWriter writer;
	private FileReader reader;
	private String metrica1;
	private int valor1;
	private String operador1;
	private String metrica2;
	private int valor2;
	private String metrica3;
	private int valor3;
	private String operador2;
	private String metrica4;
	private int valor4;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println(">>>>>>>>> Before all class tests." + enterKey);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After all class tests. <<<<<<<<<<");
	}

	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		System.out.println("Before each: <<"+ testInfo.getDisplayName() + ">> in " + this);
		h1=new Historico();
	}

	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println("Fim do teste: <<" + testInfo.getDisplayName() + ">>" + enterKey);
	}

	void setExemplo() {
		metrica1= "LOC_method";
		valor1= 30;
		 operador1= "E";
		 metrica2= "CYCLO_method";
		 valor2= 20;
		 metrica3= "WMC_class";
		 valor3=10;
		 operador2="E";
		 metrica4="NOM_class";
		 valor4=0;
		 System.out.println("valor metrica1"+metrica1);
	}
	

	@Nested
	@DisplayName("Testar se file Historico.txt ainda não existia no projeto Eclipse.")
	class testFileExistsEclipse{

		@Test
		@DisplayName("Testar no método mostrarhistorico().")
		void testExistsMostrar() throws IOException, FileNotFoundException {
			JTextArea textAreahistorico = new JTextArea();
			assertDoesNotThrow(() -> Historico.mostrarhistorico(textAreahistorico),"Ficheiro Historico.txt inexistente(!)");
		}

		@Test
		@DisplayName("Testar no método escreverhistorico().")
		void testExistsEscrever() throws IOException, FileNotFoundException {
			setExemplo();

			assertDoesNotThrow(() -> Historico.escreverhistorico(metrica1, valor1, operador1, metrica2, valor2, 
					metrica3, valor3, operador2, metrica4, valor4),"Ficheiro Historico.txt inexistente(!)");
				
			Historico.escreverhistorico(metrica1, valor1, operador1, metrica2, valor2, 
					metrica3, valor3, operador2, metrica4, valor4);
			System.out.println("testevalor CORRURURURUEUEU");
		}
			
	}
	
	@Nested
	@DisplayName("Testar se é criado Historico.txt para Buffereds.")
	class testFileNew{
				
		@Test
		@DisplayName("Testar se cria file Historico.txt para writer.")
		void testSetWriter() throws IOException {
			Historico.setWriter(writer);
			writer= h1.getWriter();
			assertNotNull(writer,"Não criou file Historico.txt(!)");
		}
				
		@Test
		@DisplayName("Testar se cria file Historico.txt para reader.")
		void testSetReader() throws IOException {
			Historico.setReader(reader);
			reader= h1.getReader();
			assertNotNull(reader,"Não criou file Historico.txt(!)");
		}	
				
		@Test
		@DisplayName("Testar se reader e writer partilham o mesmo file.")
		void testInputEqualsOutput() throws IOException {
			Historico.setWriter(writer);
			writer= h1.getWriter();
			assertNotNull(writer,"Não criou file Historico.txt(!)");
		}		
	}
	
	@Nested
	@DisplayName("Testar método mostrarhistorico().")
	class testMostrarhistorico{
		
		private FileReader reader;

		@Test
		@DisplayName("Testar se existe file de leitura: Historico.txt")
		void testSetReader() throws IOException {
			Historico.setReader(reader);
			reader= h1.getReader();
			assertNotNull(reader,"Não se criou file Historico.txt(!)");
		}
		
		@Test
		@DisplayName("JTextArea TextArea=")
		void testJTextArea() {
			JTextArea TextArea = null;
			
			reader2=h1.getReader2();
			
		}
	}
	
	@Test
	@DisplayName("Parametros=")
	void testParametros() {
		setExemplo();
		
		writer2=h1.getWriter2();
		
	}
	
}
