package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


class CodeSmellsCompararTest {

	static String enterKey = System.getProperty("line.separator");
	static CodeSmellsComparar csc1;
	private InputStream excelFile;
	private InputStream excelFile3;
	HSSFWorkbook workbookread;
	HSSFWorkbook workbookread3;
	
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
		csc1=new CodeSmellsComparar();	
	}

	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println("Fim do teste: <<" + testInfo.getDisplayName() + ">>" + enterKey);
	}

	@Test
	@DisplayName("ESSENCIAL: Testar se ficheiro jasml existe.")
	void setExcelFile() {
		//assertDoesNotThrow(() -> csc1.setExcelFile(excelFile),"O file jasml não existe(!)");
	}
	
	@Test
	@DisplayName("Testar se file guia Code_Smells.xls existe no Eclipse.")
	void testSetExcelFile3() throws FileNotFoundException,IOException {
		
		csc1.setExcelFile3();
		excelFile3 = csc1.getExcelFile3();
		assertNotNull(excelFile3, "Ficheiro Code_Smells.xls inexistente(!)");

		InputStream test= new FileInputStream("Code_Smells.xls");//tenho de converter para string
		String testmessage = org.apache.commons.io.IOUtils.toString(test);
		String message = org.apache.commons.io.IOUtils.toString(excelFile3);

		assertEquals(testmessage,message, "Não é o mesmo ficheiro(!)"); //testar se conteudo do ficheiro é o pretendido
		
	}
	
	@Test
	@DisplayName("Testar se nome do file no Eclipse para consulta da app é o Code_Smells.xls.")
	void testFileCodeSmellXLSName() throws FileNotFoundException,IOException {
		
		csc1.setExcelFile3();
		excelFile3 = csc1.getExcelFile3();

		InputStream test= new FileInputStream("Code_Smells.xls");//tenho de converter para string
		String testmessage = org.apache.commons.io.IOUtils.toString(test);
		String message = org.apache.commons.io.IOUtils.toString(excelFile3);

		assertEquals(testmessage,message, "Não é o mesmo ficheiro(!)"); //testar se conteudo do ficheiro é o pretendido
		
	}
	
	
	@Test
	@DisplayName("Testar se projeto já existe na localizaçao dada.")
	void testSetExcelFile() throws FileNotFoundException,IOException {
		excelFile= new FileInputStream("C:\\Users\\1\\Documents\\PPPPPP\\PPPPPP_metrics.xls");
		assertNotNull(excelFile, "Projeto não existe na localização(!)"); 
	}
	
	@Test
	@DisplayName("Testar se projeto já existe na localizaçao -- tentar dps Gui.location()")
	void testSetWorkbookread() throws FileNotFoundException,IOException {
		excelFile= new FileInputStream("C:\\Users\\1\\Documents\\PPPPPP\\PPPPPP_metrics.xls");
		csc1.setExcelFile(excelFile);
		assertNotNull(excelFile, "getLocation(!)"); 
	}
	
	@Nested
	@DisplayName("Testar CompararLongMethod()")
	class testCompararLongMethod{
		
		@Test
		@DisplayName("Testar Valores VP1, FP1, VN1, FN1 no início do método setWorkbookread3().")
		void groupedAssertions() {
			assertEquals(0,csc1.getVP1(),"O valor esperado seria 0(!)");
			assertEquals(0,csc1.getFP1(),"O valor esperado seria 0(!)");
			assertEquals(0,csc1.getVN1(),"O valor esperado seria 0(!)");
			assertEquals(0,csc1.getFN1(),"O valor esperado seria 0(!)");
		}
		
		
		
		@Test
		@DisplayName("Testar comportamento de goThroughSheet() se excel for em branco.")
		void goThroughBlankSheet() throws IOException {
			excelFile3= new FileInputStream("Code_Smells.xls");
			System.out.println(excelFile3);
			//csc1.setWorkbookread();
			csc1.goThroughSheet();
			System.out.println("oi1");
			int test = csc1.getLastRowNum(); 
			System.out.println(csc1.getLastRowNum());
			assertEquals(0,csc1.getLastRowNum(), "O valor esperado seria 0(!)");
			
			//int a >0;
			//assertEquals(a,)
		}
		
		
		@Test
		@DisplayName("Testar Valor FP1 depois do método correr 1x, sabendo que LongMethod é true nos dois.")
		void testGetFP1After() throws IOException {
			csc1.compararLongMethod();
			System.out.println("teste1");
			assertEquals(1,csc1.getFP1(),"O valor é 1.");
			System.out.println("teste2");
		}
		
		@Test
		@DisplayName("Testar se lança excepção")
		void testGetFile() {
		//	assertThrows(IOException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
		}

	}
	
	
	@Nested
	@DisplayName("Testar CompararGodClass()")
	class testCompararGodClass{
	
		@Test
		@DisplayName("Testar Valores VP2, FP2, VN2, FN2 no início do método.")
		void groupedAssertions() {
			assertEquals(0,csc1.getVP2(),"O valor é 0.");
			assertEquals(0,csc1.getFP2(),"O valor é 0.");
			assertEquals(0,csc1.getVN2(),"O valor é 0.");
			assertEquals(0,csc1.getFN2(),"O valor é 0.");
		}
		
		@Test
		@DisplayName("Testar comportamento de goThroughSheet() se excel for em branco.")
		void goThroughBlankSheet() throws IOException {
			excelFile3= new FileInputStream("Code_Smells.xls");
			System.out.println(excelFile3);
			//csc1.setWorkbookread();
			csc1.goThroughSheet();
			System.out.println("oi1");
			int test = csc1.getLastRowNum(); 
			System.out.println(csc1.getLastRowNum());
			assertEquals(0,csc1.getLastRowNum(), "O valor esperado seria 0(!)");
			
			//int a >0;
			//assertEquals(a,)
		}

		@Test
		@DisplayName("Testar Valor VN2 depois do método correr 1x, sabendo que LongMethod é false nos dois.")
		void testGetFP1After() throws IOException {
			csc1.compararLongMethod();
			System.out.println("teste1");
			assertEquals(1,csc1.getVN2(),"O valor é 1.");
			System.out.println("teste2");
		}
		
		@Test
		@DisplayName("Testar se lança excepção")
		void testGetFile() {
		//	assertThrows(IOException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
		}
		
	}
	
}


