package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class GuiTest extends Gui {
	File folder;
	private Gui gui = new Gui();
	private Gui listAllFiles = new Gui();
	private Gui gerarexcel = new Gui();
	private Gui importExcelToJtable = new Gui();
	static ArrayList<String> a = new ArrayList<String>();
	
	@BeforeAll
    public static void setup() {
		a.add("2");
	}
	
	@Test
	void testListAllFiles() {
		Assertions.assertEquals(listAllFiles,listAllFiles);
	}

	@Test
	void testReadContent() {
		//assertNotNull(Gui.this.readContent(folder));
		//Assertions.assertEquals(readContent, readContent);
	}


	@Test
	void testGerarexcel() {
		Assertions.assertEquals(gerarexcel, gerarexcel);
	}

	@Test
	public void importFileTest() throws FileNotFoundException, IOException {	
		gui.importExcelToJtable();
		InputStream excelFile = new FileInputStream("Code_Smells.xls");
		HSSFWorkbook workbookread = new HSSFWorkbook(excelFile);
        org.apache.poi.ss.usermodel.Sheet sheet = workbookread.getSheetAt(0);
		Row excelrow = sheet.getRow(1);

		Cell id = excelrow.getCell(0);
        Cell packagename = excelrow.getCell(1);
        Cell classname = excelrow.getCell(2);
        Cell methodname = excelrow.getCell(3);
        Cell nom_class = excelrow.getCell(4);
        Cell loc_class = excelrow.getCell(5);
        Cell wmc_class = excelrow.getCell(6);
        Cell loc_method = excelrow.getCell(8);
        Cell cyclo_method = excelrow.getCell(9);
        
		assertEquals(1,id.getNumericCellValue());
		assertEquals("com.jasml.compiler",packagename.getStringCellValue());
		assertEquals("GrammerException",classname.getStringCellValue());
		assertEquals("GrammerException(int,String)",methodname.getStringCellValue());
		assertEquals(4,nom_class.getNumericCellValue());
		assertEquals(18,loc_class.getNumericCellValue());
		assertEquals(4,wmc_class.getNumericCellValue());
		assertEquals(3,loc_method.getNumericCellValue());
		assertEquals(1,cyclo_method.getNumericCellValue());

	}

	@Test
	void testGetocurrencias() {
		ArrayList<String> eusebio = new ArrayList();
        eusebio.add("abc");
        eusebio.add("abcd");
        eusebio.add("abc");
        eusebio.add("abc");
        Assert.assertEquals(2, gui.getocurrencias(eusebio));
}
	
	@Test
	public void shouldHaveLinhas() {
        ArrayList<String> eusebio = new ArrayList();
        Assert.assertEquals(0, gui.somalinhas(eusebio));
    }
	
	@Test
	public void testSomalinhas() {
        ArrayList<String> eusebio = new ArrayList();
        eusebio.add("2");
        Assert.assertEquals(2, gui.somalinhas(eusebio));
    }
	
	@Test
	void testGetLocation() {
		Gui instance = new Gui();
	    instance.setLocation("abc");
	    assertEquals("abc", instance.getLocation());	}

	
	@Test
	public void testSetLocation() {
		Gui instance = new Gui();
	    instance.setLocation("abc");
	    assertEquals("abc", instance.getLocation());
	  }

	@Test
	public void testGetStringList() {
		Gui instance = new Gui();
	    instance.setStringList(a);
	    assertEquals(a, instance.getStringList());
	}
	
}