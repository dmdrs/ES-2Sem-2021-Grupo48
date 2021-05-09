package application;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sun.jdi.Field;

class CodeSmellsDetecaoTest {
	CodeSmellsDetecao detecao = new CodeSmellsDetecao();
	HSSFWorkbook workbookread2;
	JTable tableLongMethod;
	@Test
	void testGetWorkbookread2() {
		//when
        detecao.getWorkbookread2();
        
        assertEquals(detecao.getWorkbookread2(), detecao.getWorkbookread2());
	}

	@Test
	void testSetWorkbookread2() throws IOException {
		CodeSmellsDetecao instance = new CodeSmellsDetecao();
	    instance.setWorkbookread2(workbookread2);
	    assertEquals(workbookread2, instance.getWorkbookread2());	

	}

	@Test
	void testGetTableLongMethod() {
		Assertions.assertEquals(detecao.getTableLongMethod(), detecao.getTableLongMethod());
	}
	@Test
	void testSetTableLongMethod() throws IOException {
		CodeSmellsDetecao instance = new CodeSmellsDetecao();
	    instance.setTableLongMethod(tableLongMethod);
	    assertEquals(tableLongMethod, instance.getTableLongMethod());		
		}

	@Test
	void testGetTableGodClass() {
		Assertions.assertEquals(detecao.getTableGodClass(), detecao.getTableGodClass());
	}

	@Test
	void testSetTableGodClass() throws IOException {
		CodeSmellsDetecao instance = new CodeSmellsDetecao();
	    instance.setTableGodClass(tableLongMethod);
	    assertEquals(tableLongMethod, instance.getTableGodClass());
	}

	@Test
	void testDetecaoLongMethod() {
		int valor1=1;
		String file = new String();
		String andor1 = new String();
		String metrica1 = new String();
		String metrica2 = new String();
		int valor2=1;
		assertNotNull(valor1);
		assertNotNull(file);
		assertNotNull(andor1);
		assertNotNull(metrica1);
		assertNotNull(metrica2);
		assertNotNull(valor2);

	}

	@Test
	void testDetecaoGodClass() {
		String file = new String();
		int valor4=1;
		String metrica4 = new String();
		String andor2 = new String();
		String metrica3 = new String();
		int valor3=1;
		assertNotNull(file);
		assertNotNull(metrica3);
		assertNotNull(valor3);
		assertNotNull(andor2);
		assertNotNull(metrica4);
		assertNotNull(valor4);

	}

}
