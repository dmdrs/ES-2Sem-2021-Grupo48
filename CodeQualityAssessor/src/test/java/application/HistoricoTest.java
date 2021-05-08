package application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import org.apache.commons.io.org.IOUtils;

class HistoricoTest {

	static String enterKey = System.getProperty("line.separator");
	static Historico h1;
	private BufferedWriter writer2;
	
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

	@Test
	@DisplayName("Long Method: LOC_method > 30 E CYCLO_method > 20 & God Class: WMC_class > 10 E NOM_class > 0")
	void testEscreverhistorico() {
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
		
		Historico.escreverhistorico(metrica1, valor1, operador1, 
				metrica2, valor2, metrica3, valor3, operador2, metrica4, valor4);
		writer2=h1.getWriter2();
		String message = org.apache.commons.io.IOUtils.toString(writer2);

		
		assertEquals("xxxx",writer2,"here");
		assertEquals(0,valor2,"oi");
	}
	
	@Test
	@DisplayName("Testar mostrarHistorico()")
	void testMostrarhistorico() {
		//fail("Not yet implemented");
	}
}
