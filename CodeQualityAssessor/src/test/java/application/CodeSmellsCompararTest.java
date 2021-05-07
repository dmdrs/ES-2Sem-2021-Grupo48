/**
 * 
 */
package application;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.CodeSmellsComparar;
/**
 * @author 1santo
 *
 */
class CodeSmellsCompararTest {

	private static CodeSmellsComparar csc1;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		csc1=new CodeSmellsComparar();
	}

	/**
	 * @throws java.lang.Exception
	 */
/*	@BeforeEach
	void setUp() throws Exception {
	}
	*/
	@Test
	void groupedAssertions() {
		assertNotNull(csc1.getVP1()); 
	}
	
	@Test
	void testCompararLongMethod() {
		assertThrows(IOException.class, () -> csc1.compararLongMethod(),"O método deve lançar IOException");
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

*/}
