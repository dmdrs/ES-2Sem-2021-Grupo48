/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.Assert;
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
		Assert.assertNotNull(csc1.getVP1()); 
		fail("Not yet implemented");
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
