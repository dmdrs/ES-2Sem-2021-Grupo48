
	package metrics;

	

	import java.io.BufferedReader;
import java.io.File;
	import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

import org.w3c.dom.ranges.Range;

import com.github.javaparser.StaticJavaParser;
	import com.github.javaparser.ast.CompilationUnit;
	import com.github.javaparser.ast.body.MethodDeclaration;
	
	import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import metrics.LOC_class;


	/**
	 * @author fmmba
	 *
	 */

	
		
		
	class MethodNames {
	    
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

		}
		
		
	class MethodNr {
		 private ArrayList<Integer> mcount;
		 public MethodNr( ArrayList<Integer> i) {
				this.mcount=i;
			}
		 public ArrayList<Integer> getList() {
				
				return mcount;	
				}
	}
	

	

	public class NOM_class  {
	    public static int counter;
	   static LinkedList<MethodDeclaration> Methods = new LinkedList<MethodDeclaration>();
	   static ArrayList<String> namesofmethods;
	  static ArrayList<Integer> nrlinemethods;
	   static String nameofpackage;
       
		

	  
	    public static void main(File file) throws Exception {
	        // creates an input stream for the file to be parsed
	     counter = 0;
	   
	     FileInputStream in = new FileInputStream( file);
	     BufferedReader br  = new BufferedReader(new FileReader(file));
	     LOC_class.LOC_Class(br);
	try {
		
	      namesofmethods = new ArrayList<String>();
	      nrlinemethods = new ArrayList<Integer>();
	      CompilationUnit cu = StaticJavaParser.parse(in);
	      nameofpackage = cu.getPackageDeclaration().get().getNameAsString();
	      new MethodVisitor().visit(cu, null);
	      MethodNames namez = new MethodNames(namesofmethods);
	      MethodNr numz = new MethodNr(nrlinemethods);
	      
	    
	      Foo fooo= new Foo(nameofpackage,file,namez,counter,LOC_class.linesOfCode,numz);
	      Foo.foos.add(fooo);
	      for(Foo singlefoo : Foo.foos) {
	    	  System.out.println("Package Name: "+nameofpackage +" File: "+singlefoo.getFile().getName()+" Methods: "+singlefoo.getList()+" Count: "+singlefoo.getCount());
				
	      }
	      
			
	}finally {
    
	}

	       
	        System.out.println("Number of methods in "+file.getName()+" is "+counter);
	    }

	    private static class MethodVisitor extends VoidVisitorAdapter<Object> {

	        @Override
	        public void visit(MethodDeclaration n, Object arg) {
	            // here you can access the attributes of the method.
	            // this method will be called for all methods in this 
	            // CompilationUnit, including inner class methods
	       //     System.out.println(n.getName()+""+n.getParameters());
	            Methods.add(n);
	            namesofmethods.add(n.getName()+""+n.getParameters());
	            int methodBodyLength = n.getRange().map(range -> range.end.line - range.begin.line).orElse(0);
	            int x = Math.abs(methodBodyLength);
	             nrlinemethods.add(x);
	            counter++;
	        }
	       
	        }
	        
	    

	public static int getNrMethods() {
		
		
	return counter;	
	}

	
	}
	
	
	

	
