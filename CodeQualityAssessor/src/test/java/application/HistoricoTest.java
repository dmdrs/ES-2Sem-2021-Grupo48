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
	public BufferedReader reader2;
	
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

	@Nested
	@DisplayName("Testar método escreverhistorico.")
	class testEscreverhistorico{
		
		private FileWriter writer;
		private FileReader reader;

		@Nested
		@DisplayName("Testar file Historico.txt.")
		class testFileExists{

			@Test
			@DisplayName("Testar se ficheiro ainda nao existia no projeto Eclipse.")
			void testFileExistsEclipse() throws IOException, FileNotFoundException {
				JTextArea textAreahistorico = new JTextArea();
				assertDoesNotThrow(() -> Historico.mostrarhistorico(textAreahistorico),"Ficheiro Historico.txt inexistente(!)");
			}
			
			@Nested
			@DisplayName("Testar criar Historico.txt, quando nao existe.")
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
					writer= h1.getWriter();
					assertNotNull(writer,"Não criou file Historico.txt(!)");
				}	
				
				@Test
				@DisplayName("Testar se reader e writer partilham file.")
				void testInputEqualsOutput() throws IOException {
					Historico.setWriter(writer);
					writer= h1.getWriter();
					assertNotNull(writer,"Não criou file Historico.txt(!)");
				}		
			}
		}
		
		@Test
		@DisplayName("Long Method: LOC_method > 30 E CYCLO_method > 20 & God Class: WMC_class > 10 E NOM_class > 0")
		void testEscreverNovaRegra() {
			String metrica1= "LOC_method";
			int valor1= 30;
			String operador1= "E";
			String metrica2= "CYCLO_method";
			int valor2= 20;
			String metrica3= "WMC_class";
			int valor3=10;
			String operador2="E";
			String metrica4="NOM_class";
			int valor4=0;
			
	//		Historico.escreverhistorico(metrica1, valor1, operador1, 
	//				metrica2, valor2, metrica3, valor3, operador2, metrica4, valor4);
	//		writer2=h1.getWriter2();
	/*		
			//reader=input, writer=output
			IOUtils.copy(writer2, reader2);
			IOUtils.
			
			String message = writer2.lines().collect(Collectors.joining());
			//String message = org.apache.commons.io.IOUtils.toString(writer2);
	
			
			assertEquals("xxxx",writer2,"here");
			assertEquals(0,valor2,"oi");
			*/
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
	
}
