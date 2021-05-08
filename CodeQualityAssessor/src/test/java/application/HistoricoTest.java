package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class HistoricoTest {

	static String enterKey = System.getProperty("line.separator");
	static Historico h1;
	
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
	@DisplayName("Testar CompararLongMethod()")
	void testEscreverhistorico() {
		String metrica1= "";
		int valor1= 0;
		String operador1= "";
		String metrica2= "";
		int valor2= 0;
		String metrica3= "";
		int valor3=0;
		String operador2="";
		String metrica4="";
		int valor4=0;
		h1.escreverhistorico(metrica1, valor1, operador1, metrica2, valor2, metrica3, valor3, operador2, metrica4, valor4);
		assertEquals()
	}
	
	@Test
	@DisplayName("Testar CompararLongMethod()")
	void Mostrarhistorico() {
		fail("Not yet implemented");
	}
}
