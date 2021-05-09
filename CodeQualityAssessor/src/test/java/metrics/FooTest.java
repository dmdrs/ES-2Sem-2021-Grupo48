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
import org.junit.jupiter.api.TestInfo;

/**
 * @author 1santo
 *
 */


class FooTest {
	
	static String enterKey = System.getProperty("line.separator");
    private File fi;
    private MethodNames mn; 
    private MethodNr nrr;
    private Methodc cnrr;
    private int in;
    private int loc;
    private int cyclocyclo;
    private String pn;
	private ArrayList<Foo> foos;
	
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
	void setUp() throws Exception {
		foos = new ArrayList<Foo>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown(TestInfo testInfo) throws Exception {
		System.out.println("Fim do teste: <<" + testInfo.getDisplayName() + ">>" + enterKey);
	}
	/**
	 * Coloca a linha nº2 do excel jasml_metrics.xls como argumento
	 * ID.	Package	class	method	NOM_class	LOC_class	WMC_class	LOC_method	CYCLO_method	is Long Method	is God Class
	 * 1	com.jasml.classes	Attribute	Attribute(byte,int)	2	38	2	4	1	FALSO	FALSO

	 */
	void setExemplo() {
	
		String p="com.jasml.classes"; 
		pn=p;
		File f=new File("com.jasml.classes");
		fi=f;
		MethodNames s= null;//new MethodNames(foos);
		mn=s;
		int i=2;// valor da NOMclass
		in=i;
		int lc=38;//vlr LOC_class, MethodNr nr, Methodc cnr, int wmc)
		loc=lc;
		MethodNr nr=null; //WMC_class
		nrr=nr;
		Methodc cnr=null; //LOC_method
		cnrr=cnr;
		int wmc=1; // CYCLO_method
		cyclocyclo=wmc;
	}
	/*	class MethodNames {	    
		
	    private ArrayList<String> names; 
	    ArrayList<Foo> MethodNames = new ArrayList<Foo>();
	    
	    public MethodNames( ArrayList<String> s) {
			this.names=s;
		}

		public ArrayList<String> getList() {
			return names;	
		}
		
		public void setList(ArrayList<String> list) {
			this.names=list;
		}
	}*/
		
		
	
	@Test
	@DisplayName("Testar se construtor recebeu argumentos invalidos")
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
		//	assertThrows(FileNotFoundException.class, () -> ,"O método deve lançar FileNotFoundException");
		}
		
		@Test
		@DisplayName("Testar se file existe")
		void testCompararLongMethod() throws IOException {
			System.out.println("hey1");
				}
	
	}
}
