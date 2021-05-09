package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author 1santo
 *
 */
class CodeSmellsTest {

	static String enterKey = System.getProperty("line.separator");
	static CodeSmells cs1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println(">>>>>>>>> Before all class tests." + enterKey);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After all class tests. <<<<<<<<<<");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp(TestInfo testInfo) throws Exception {
		System.out.println("Before each: <<"+ testInfo.getDisplayName() + ">> in " + this);
		cs1=new CodeSmells();	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println("Fim do teste: <<" + testInfo.getDisplayName() + ">>" + enterKey);
	}

	
	@Test
	@DisplayName("Returns the number of columns in the model. "
			+ "A JTable uses this method to determine how many columns it should create and display by default.")
	void testX() {
		

	}
	
	void test() {
		//para mais testes necessario fix GuiLocation().
	}
	
	/*
		public void detecaoLongMethod (String file, String metrica1 , int valor1,  String andor1, String metrica2, int valor2) throws IOException {
		codeSmellsDetecao.detecaoLongMethod(file, metrica1, valor1, andor1, metrica2, valor2);	
	}
	
	
	public void detecaoGodClass (String file, String metrica3 , int valor3,  String andor2, String metrica4, int valor4) throws IOException {
		codeSmellsDetecao.detecaoGodClass(file, metrica3, valor3, andor2, metrica4, valor4);
	}
	
	public void compararLongMethod() throws IOException {
		codeSmellsComparar.compararLongMethod();
          
	}
	
	public void compararGodClass() throws IOException {
		codeSmellsComparar.compararGodClass();
        
	}
	
	 */
}
