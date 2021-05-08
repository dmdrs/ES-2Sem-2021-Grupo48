/**
 * 
 */
package metrics;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author 1
 *
 */


class FooTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	private ArrayList<Foo> foos;

	/**
	 * @throws java.lang.Exception
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		foos = new ArrayList<Foo>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	@DisplayName("Testar construtor")
	void testFoo(String p, File f, MethodNames s, int i, int lc, MethodNr nr, Methodc cnr, int wmc) {
		//
	}
	
	@Nested
	@DisplayName("Testar se existe o essencial")
	class VariablesTest{
	
		

		@Test
		@DisplayName("Testar se lista Foo não está vazia")
		void testGetFoo() {
			assertNotNull(foos); 
		}
		
		@Test
		@DisplayName("Testar se file existe")
		void testGetFile() {
			assertThrows(FileNotFoundException.class, () -> ,"O método deve lançar FileNotFoundException");
		}
		
		@Test
		@DisplayName("Testar se file existe")
		void testCompararLongMethod() throws IOException {
			System.out.println("hey1");
				}
	
	}
}
