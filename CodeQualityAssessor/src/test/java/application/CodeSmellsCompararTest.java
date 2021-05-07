package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


class CodeSmellsCompararTest {

	InputStream excelFile;
	static Gui gui;
	static CodeSmellsComparar csc1;
	HSSFWorkbook workbookread;
	HSSFWorkbook workbookread3;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	//	System.out.println("Before all.");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		csc1=new CodeSmellsComparar();
		excelfile=("C:\\Users\\1\\Documents\\teste")
		
		//System.out.println("Before each "+ testInfo.getDisplayName() + " in " + this);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testar variaveis VP1,FP1,VN1,FN1,VP2,FP2,VN2,FN2")
	void groupedAssertions() {
		assertNotNull(csc1.getVP1()); 
		assertNotNull(csc1.getFP1()); 
		assertNotNull(csc1.getVN1()); 
		assertNotNull(csc1.getFN1()); 
		assertNotNull(csc1.getVP2()); 
		assertNotNull(csc1.getFP2()); 
		assertNotNull(csc1.getVN2()); 
		assertNotNull(csc1.getFN2()); 

}
	
	@Test
	void testGetFP1() {
		assertEquals(0,csc1.getFP1(),"O valor é 0.");
	}
	
	

/*	private HSSFWorkbook workbookread;
	private HSSFWorkbook workbookread3;
	
	InputStream excelFile = new FileInputStream(Gui.getLocation());
		workbookread = new HSSFWorkbook(excelFile);
		org.apache.poi.ss.usermodel.Sheet sheet = workbookread.getSheetAt(0);
		InputStream excelFile3 = new FileInputStream("Code_Smells.xls");
		workbookread3 = new HSSFWorkbook(excelFile3);
		org.apache.poi.ss.usermodel.Sheet sheet3 = workbookread3.getSheetAt(0);
	
	gui
	public void gerarexcel() throws IOException {
		String excelname = filepath + "/" + name + "_metrics.xls" ;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Code Smells");  
        setLocation();
        
        public void setLocation() {
		excelLocation = filepath + "/" + name + "_metrics.xls";
	}
	filepath + "/" + name + "_metrics.xls"
	*/
	
	@Test
	@DisplayName("Testar CompararLongMethod")
	void testCompararLongMethod() throws IOException {
		System.out.println("hey1");
		assertThrows(IOException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
			InputStream excelFile = new FileInputStream(Gui.getLocation());
			System.out.println(Gui.getLocation());
			System.out.println("hey2");
			assertNotNull(excelFile);
			//workbookread = new HSSFWorkbook(excelFile);
			//assertTrue(excelFile.getClass().getClassLoader());
			

			
			
		
		
	}

	@Test
	void compararGodClass() {
		
	}
}





/*	
@Test
@DisplayName("VP1")
void testGetVP1() {
//	Assert.assertNotNull(csc1.getVP1()); 
//	fail("Not yet implemented");
}

@Test
void abortedTest() {
//       assumeTrue("abc".contains("Z"));
//      fail("Teste deveria ter sido abortado pois não tem Gui.Location");
}

*/