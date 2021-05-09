package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodeSmellsCompararTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testVaraibleVN1() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getVN1());
	}

	@Test
	void testVaraibleVN2() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getVN2());
	}
	
	@Test
	void testVaraibleVP1() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getVP1());
	}
	
	@Test
	void testVaraibleVP2() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getVP2());
	}
	
	@Test
	void testVaraibleFN1() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getFN1());
	}
	
	@Test
	void testVaraibleFN2() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getFN2());
	}
	
	@Test
	void testVaraibleFP1() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getFP1());
	}
	
	@Test
	void testVaraibleFP2() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    assertEquals(0, instance.getFP2());
	}
	
	@Test
	void testResetVariavel1() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    instance.resetvariavel1();
	    assertEquals(0, instance.getFN1());	
	    assertEquals(0, instance.getFP1());
	    assertEquals(0, instance.getVN1());
	    assertEquals(0, instance.getVP1());
		}
	
	@Test
	void testResetVariavel2() throws IOException {
		CodeSmellsComparar instance = new CodeSmellsComparar();
	    instance.resetvariavel2();
	    assertEquals(0, instance.getFN2());	
	    assertEquals(0, instance.getFP2());
	    assertEquals(0, instance.getVN2());
	    assertEquals(0, instance.getVP2());
		}
	
}
