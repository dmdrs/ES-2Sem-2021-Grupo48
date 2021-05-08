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

	static CodeSmellsComparar csc1;
	InputStream excelFile;
	InputStream excelFile3;
	HSSFWorkbook workbookread;
	HSSFWorkbook workbookread3;
	org.apache.poi.ss.usermodel.Sheet sheet;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	//	System.out.println("Before all.");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		System.out.println("hey1");
		csc1=new CodeSmellsComparar();
		System.out.println("hey2");
		
		
		
		
		System.out.println("Before each "+ testInfo.getDisplayName() + " in " + this);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}



	@Nested
	@DisplayName("Testar CompararLongMethod()")
	class testCompararLongMethod{

		
		String getFileContent(FileInputStream filename, String sfilename ) throws IOException {
			try( BufferedReader br = new BufferedReader ( new InputStreamReader(filename, sfilename ) )
				){
				StringBuilder sb = new StringBuilder();
				String line;
				 	while(( line = br.readLine()) != null ) {
				 		sb.append( line );
				 		sb.append( '\n' );
				    }
				    return sb.toString();
			}
		}
		
		
		@Test
		@DisplayName("Testar Valores VP1, FP1, VN1, FN1 no início do método.")
		void testGetValues() {
			assertEquals(0,csc1.getVP1(),"O valor é 0.");
			assertEquals(0,csc1.getFP1(),"O valor é 0.");
			assertEquals(0,csc1.getVN1(),"O valor é 0.");
			assertEquals(0,csc1.getFN1(),"O valor é 0.");
		}
		
		@Test
		@DisplayName("Testar se file de orientação existe")
		void testSetExcelFile3() throws FileNotFoundException,IOException {
			FileInputStream testExcelFile3 = new FileInputStream("Code_Smells.xls");
			/*FileInputStream ola = new FileInputStream("Code_Smells.xls");
			
			File file = new File("Code_Smells.xls");
			InputStream inputStream = new FileInputStream(file);
			System.out.println(file.getPath());
			File test = new File(ola);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(testExcelFile3));
			System.out.println(testExcelFile3);*/

			
			System.out.println("testingggggggggg");
			csc1.setExcelFile3(testExcelFile3);
			excelFile3 = csc1.getExcelFile3();
			assertNotNull(excelFile3, "Está a nulo(!)");


			System.out.println("ATENÇAOOOOOOOOOOOOOOOOO" + testExcelFile3 + " - " + excelFile3);
		//	assertEquals(testExcelFile3,excelFile3);
		//	assertThrows(FileNotFoundException.class, () -> csc1.setExcelFile3(excelFile3),"O método deve lançar FileNotFoundException");
			
			//csc1.setExcelFile3(excelFile3);
			//workbookread3 = new HSSFWorkbook(excelFile3);
			//csc1.setWorkbookread3(workbookread3);
			
		}
		
		@Test
		@DisplayName("Testar Gui.location()")
		void testSetExcelFile() throws FileNotFoundException,IOException {
			//InputStream testExcelFile = new FileInputStream(Gui.getLocation());
/*
			try {
				excelFile= new FileInputStream("C:\\Users\\1\\Documents\\PPPPPP\\PPPPPP_metrics.xls");
				csc1.setExcelFile(excelFile);
				excelFile = csc1.getExcelFile();
				assertNotNull(excelFile3, "Está a nulo(!)");
				System.out.println("ATENÇAOOOOOOOOOOOOOOOOO______GUIIIIRDO"  + testExcelFile + " - " + excelFile);
				assertEquals(testExcelFile,excelFile);
			} catch (FileNotFoundException e) {
				System.out.println("Ficheiro não existe no caminho indicado");
				e.printStackTrace();
			}	
			*/
			try {
				excelFile= new FileInputStream("C:\\Users\\1\\Documents\\PPPPPP\\PPPPPP_metrics.xls");
				csc1.setExcelFile(excelFile);
				csc1.compararLongMethod();
					System.out.println("try");
			} catch (FileNotFoundException e) {
				System.out.println("Ficheiro não existe no caminho indicado");
				e.printStackTrace();
			}	
			assertNotNull(excelFile, "getLocation(!)"); 

		}
		
		
		@Test
		@DisplayName("Testar se projeto já existe na localizaçao")
		void testGetFoo() {
			
			
			try {
				excelFile= new FileInputStream("C:\\Users\\1\\Documents\\PPPPPP\\PPPPPP_metrics.xls");
			} catch (FileNotFoundException e) {
				System.out.println("Ficheiro não existe no caminho indicado");
				e.printStackTrace();
			}	
			assertNotNull(excelFile); 
		//	assertThrows(FileNotFoundException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
		}
		
		@Test
		@DisplayName("Testar Valor FP1 depois do método correr 1x.")
		void testGetFP1After() throws IOException {
			csc1.compararLongMethod();
			assertEquals(1,csc1.getFP1(),"O valor é 1.");
		}
		
		@Test
		@DisplayName("Testar se lança excepção")
		void testGetFile() {
		//	assertThrows(IOException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
		}
		
		@Test
		@DisplayName("Testar ")
		void testVariaveis() throws IOException {
			//workbookread = new HSSFWorkbook(excelFile);
			//assertTrue(excelFile.getClass().getClassLoader());
		}

		@Test
		void xx() {
			
		}
	}
	
	
	@Nested
	@DisplayName("Testar CompararGodClass()")
	class testCompararGodClass{
	
		@Test
		@DisplayName("Testar Valores VP2, FP2, VN2, FN2 no início do método.")
		void testGetValues() {
			assertEquals(0,csc1.getVP2(),"O valor é 0.");
			assertEquals(0,csc1.getFP2(),"O valor é 0.");
			assertEquals(0,csc1.getVN2(),"O valor é 0.");
			assertEquals(0,csc1.getFN2(),"O valor é 0.");
		}
		
		@Test
		@DisplayName("Testar se file existe")
		void testGetFoo() {
			/*	
			InputStream excelFile = new FileInputStream(Gui.getLocation());
			*/
			try {
				excelFile= new FileInputStream("C:\\Users\\1\\Documents\\PPPPPP\\PPPPPP_metrics.xls");
			} catch (FileNotFoundException e) {
				System.out.println("Ficheiro não existe no caminho indicado");
				e.printStackTrace();
			}	
			assertNotNull(excelFile); 
			assertThrows(FileNotFoundException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
		}
		
		@Test
		@DisplayName("Testar se localização do file existe")
		void testGetFile() {
			assertThrows(IOException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
		}
		
		@Test
		@DisplayName("Testar ")
		void testVariaveis() throws IOException {
			//workbookread = new HSSFWorkbook(excelFile);
			//assertTrue(excelFile.getClass().getClassLoader());
		}

		@Test
		void yy() {
			
		}
	}
}


