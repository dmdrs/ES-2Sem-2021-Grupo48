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
	public BufferedReader reader2;
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
	@DisplayName("Testar método escreverhistorico.")
	class testEscreverhistorico{
		

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
			@DisplayName("Testar no método mostrarhistorico().")
			void testExistsEscrever() throws IOException, FileNotFoundException {
				setExemplo();
				

				Historico.setReader(reader);
				reader= h1.getReader();

				System.out.println("1");
				
				Historico.setReader2(reader2);
				reader2=h1.getReader2();

				
				Historico.setWriter(writer);
				writer= h1.getWriter();

				System.out.println("2");
				
				Historico.setWriter2(writer2);
				writer2=h1.getWriter2();
				
				assertDoesNotThrow(() -> Historico.escreverhistorico(metrica1, valor1, operador1, metrica2, valor2, 
						metrica3, valor3, operador2, metrica4, valor4),"Ficheiro Historico.txt inexistente(!)");
				
				Historico.escreverhistorico(metrica1, valor1, operador1, metrica2, valor2, 
						metrica3, valor3, operador2, metrica4, valor4);
				System.out.println("testevalor CORRURURURUEUEU");
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
					reader= h1.getReader();
					assertNotNull(reader,"Não criou file Historico.txt(!)");
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
		
		void teste() throws IOException {
			int i=0;    
			  String testp = "";
			  System.out.println("33");
	          while((i=reader2.read())!=-1){  
				  System.out.println("3.5");

	        	  testp=testp+(char)i;
	        	  System.out.println("44");
	        	  System.out.println("PFFFFFFFFFF "+testp);
	          System.out.print((char)i);  
	          }  
	          reader2.close();    
	          reader.close(); 
	          System.out.println("55");
		}
		
		public String inToString(InputStream inputStream) {

	        String result = "";
	        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
	        String line;
	        try {
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
		
		@Test
		@DisplayName("Long Method: LOC_method > 30 E CYCLO_method > 20 & God Class: WMC_class > 10 E NOM_class > 0")
		void testEscreverNovaRegra() throws IOException {
			
			//BufferedWriter test= new Buffere
			
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
			
			System.out.println("11");
			
			
			String testString= metrica1+enterKey+" > " + valor1 + " " + operador1 + " " + metrica2 + " > " + valor2+enterKey+
					"God Class:"+enterKey+metrica3+ " > " + valor3 + " " + operador2 + " " + metrica4 + " > " + valor4;
			
			System.out.println("22");

			Historico.setReader(reader);
			reader= h1.getReader();

			System.out.println("11.3");
			
			Historico.setReader2(reader2);
			reader2=h1.getReader2();

			
			Historico.setWriter(writer);
			writer= h1.getWriter();

			System.out.println("11.3");
			
			Historico.setWriter2(writer2);
			writer2=h1.getWriter2();
			
			
			Historico.escreverhistorico (metrica1, valor1,  operador1, metrica2, 
				valor2, metrica3, valor3, operador2, metrica4, valor4);
			System.out.println("3.4");
			
			
			int a=-1;
			a=IOUtils.copy(reader2, writer2); //copies from reader to writer, o writer vai ter o que o reader tem
			
			System.out.println(a+" - 6666");

			//assertEquals()
			
			assertNotNull(writer2);
			//teste();
			
			System.out.println("55555");
			//String lineFromFile = null;
			/*  int i=0;    
			  String testp = "";
			  System.out.println("33");
	          while((i=reader2.read())!=-1){  
				  System.out.println("3.5");

	        	  testp=testp+(char)i;
	        	  System.out.println("44");
	        	  System.out.println("PFFFFFFFFFF "+testp);
	          System.out.print((char)i);  
	          }  
	          reader2.close();    
	          reader.close(); 
	          System.out.println("55"); */
			//System.out.println("heyo3"+lineFromFile);
			//assertEquals(testString,linefromFile);

			
			
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
