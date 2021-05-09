/**
 * 
 */
package metrics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Gui;
import junit.framework.Assert;



/**
 * @author 1
 *
 */
class MetricasTest {

	static Metricas m1;
	static ArrayList<String> a = new ArrayList<String>();
	static ArrayList<Integer> z = new ArrayList<Integer>();

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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMethodNames() {
		MethodNames instance = new MethodNames(a);
		ArrayList<String> b = new ArrayList<String>();
		b.add("test");
	    instance.setList(b);
	    assertEquals(b, instance.getList());	
	    }
	
	@Test
	public void testMethodNr() {
		MethodNr instance = new MethodNr(z);
		ArrayList<Integer> i = new ArrayList<Integer>();
		i.add(5);
	    instance.setList(i);
	    assertEquals(i, instance.getList());	
	    }
	
	@Test
	public void testMethodc() {
		Methodc instance = new Methodc(z);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(5);
	    instance.setList(b);
	    assertEquals(b, instance.getListc());	
	    }
	
}
