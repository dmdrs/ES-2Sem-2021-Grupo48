/**
 * 
 */
package metrics;

import static org.junit.Assert.assertNull;
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
import org.junit.jupiter.api.TestInfo;

/**
 * @author 1santo
 *
 */


class FooTest {
	
	static String enterKey = System.getProperty("line.separator");
    static Foo foo1;
	private File fi;
    private MethodNames mn; 
    private MethodNr nrr;
    private Methodc cnrr;
    private int in;
    private int loc;
    private int cyclocyclo;
    private String pn;
	private ArrayList<String> foos;
	private ArrayList<Integer> foosWMC;
	private ArrayList<Integer> foosLOCmeth;
	
	/**
	 * Coloca variáveis da linha nº2 do excel jasml_metrics.xls como argumentos
	 * ID.	Package	class	method	NOM_class	LOC_class	WMC_class	LOC_method	CYCLO_method	is Long Method	is God Class
	 * 1	com.jasml.classes	Attribute	Attribute(byte,int)	2	38	2	4	1	FALSO	FALSO

	 */
	void setExemplo() {

		String p="com.jasml.classes"; 
		pn=p;
		File f=new File("com.jasml.classes");
		fi=f;
		MethodNames s= new MethodNames(foos);
		System.out.println("TESTANDO "+s);
		mn=s;
		int i=2;/**valor da NOMclass*/
		in=i;
		int lc=38;/**vlr LOC_class*/
		loc=lc;
		MethodNr nr= new MethodNr(foosWMC); /**WMC_class*/
		nrr=nr;
		Methodc cnr= new Methodc(foosLOCmeth); /**LOC_method*/
		cnrr=cnr;
		int wmc=1; /** CYCLO_method*/
		cyclocyclo=wmc;
		
	}
	
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
		ArrayList<Foo> MethodNames = new ArrayList<Foo>();
		ArrayList<Foo> MethodNr = new ArrayList<Foo>();
		ArrayList<Foo> Methodc = new ArrayList<Foo>();
		foos=new ArrayList<String>();
		foosWMC = new ArrayList<Integer>();
		foosLOCmeth = new ArrayList<Integer>();
		foo1=new Foo(pn, fi, mn, in, loc, nrr, cnrr, cyclocyclo);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println("Fim do teste: <<" + testInfo.getDisplayName() + ">>" + enterKey);
	}
		
	@Test
	@DisplayName("Testar se variáveis começam a nulo/zero")
	void testStartNull() {
		assertNull(pn=foo1.getPackageName());
		assertNull(fi=foo1.getFile()); 
		assertEquals(0,loc=foo1.getLoc());
		assertEquals(0,cyclocyclo=foo1.getCycloCyclo());
	}

	
	@Test
	@DisplayName("Testar se construtor recebeu algum argumento inválido")
	void testFoo() {
		setExemplo();
	 assertAll("argumento Package",
			 () -> {
            	pn=foo1.getPackageName();
                assertNull(pn);

                // Executed only if the previous assertion is valid.
                assertAll("argumentos LOC_Class e CYCLO_method",
                    () -> assertNull(loc),
                    () -> assertNull(cyclocyclo)
                );
            },
            () -> {
                // Grouped assertion, so processed independently
                // of results of first name assertions.
            	fi=foo1.getFile();
               

                // Executed only if the previous assertion is valid.
                assertAll("argumento Class",
                    () ->  assertNotNull(fi)
                );
            }
        );
		foo1=new Foo(pn, fi, mn, in, loc, nrr, cnrr, cyclocyclo);
		pn=foo1.getPackageName();
		
		
		System.out.println(pn+" ISTO E OUTRO");
		
	}
	
	
	@Test
	@DisplayName("Testar se tem os mesmos argumentos da linha 2 do jasml.")
	void testExemplo() {
		setExemplo();
		foo1=new Foo(pn, fi, mn, in, loc, nrr, cnrr, cyclocyclo);
		pn=foo1.getPackageName();
		fi=foo1.getFile();
		loc=foo1.getLoc();
		cyclocyclo=foo1.getCycloCyclo();
		assertEquals("com.jasml.classes",pn=foo1.getPackageName());
		assertNotNull(fi=foo1.getFile()); 
		assertEquals(38,loc=foo1.getLoc());
		assertEquals(1,cyclocyclo=foo1.getCycloCyclo());
	}
	
	@Nested
	@DisplayName("Testar senão existem anulidades")
	class VariablesTest{
	
		@Test
		@DisplayName("Testar se lista Foos não está vazia")
		void testGetFoo() {
			assertNotNull(foos); 
		}
		
		@Test
		@DisplayName("Testar se lista FoosWC não está vazia")
		void testGetFooWMC() {
			assertNotNull(foosWMC); 
		}
		
		@Test
		@DisplayName("Testar se lista FoosLOCmeth não está vazia")
		void testGetFooLOCmeth() {
			assertNotNull(foosLOCmeth); 
		}
		
	}
}
