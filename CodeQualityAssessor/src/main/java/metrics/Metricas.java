
	package metrics;

	

	import java.io.BufferedReader;
import java.io.File;
	import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.w3c.dom.ranges.Range;

import com.github.javaparser.StaticJavaParser;
	import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.SwitchEntry;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import static com.github.javaparser.ast.expr.BinaryExpr.Operator.AND;
import static com.github.javaparser.ast.expr.BinaryExpr.Operator.OR;

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
	class Methodc {
		 private ArrayList<Integer> mcount;
		 public Methodc( ArrayList<Integer> i) {
				this.mcount=i;
			}
		 public ArrayList<Integer> getListc() {
				
				return mcount;	
				}
	}

	

	public class Metricas  {
	    public static int counter;
	    public static int cyclocounter;
	    public static int cyclocountercounter;
	    public static int linesOfCode;
	
	   static ArrayList<String> namesofmethods;
	  static ArrayList<Integer> nrlinemethods;
	  static ArrayList<Integer> nrcyclomethods;
	   static String nameofpackage;
       
		

	  
	    public static void main(File file) throws Exception {
	        // creates an input stream for the file to be parsed
	     counter = 0;
	     cyclocounter= 0;
	     cyclocountercounter=0;
	   
	     
	     FileInputStream in = new FileInputStream( file);
	     try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			linesOfCode = (int) br.lines().count();
		}
	     try {
		
	      namesofmethods = new ArrayList<String>();
	      nrlinemethods = new ArrayList<Integer>();
	      nrcyclomethods = new ArrayList<Integer>();
	     
	      CompilationUnit cu = StaticJavaParser.parse(in);
	      nameofpackage = cu.getPackageDeclaration().get().getNameAsString();
	      
	      new ConsVisitor().visit(cu,  null);
	      new MethodVisitor().visit(cu, null);
	    //  new CYCLO_method1().visit(cu,null);
	      
	      MethodNames namez = new MethodNames(namesofmethods);
	      MethodNr numz = new MethodNr(nrlinemethods);
	      Methodc cyclonrr = new Methodc(nrcyclomethods);
	    
	      
	    
	      Foo fooo= new Foo(nameofpackage,file,namez,counter,linesOfCode,numz, cyclonrr, getCycloCyclo(nrcyclomethods));
	      Foo.foos.add(fooo);
	      
	      
			
	}finally {
    
	}

	
	    }

	    private static class MethodVisitor extends VoidVisitorAdapter<Object> {

	        @Override
	        public void visit(MethodDeclaration n, Object arg) {
	            // here you can access the attributes of the method.
	            // this method will be called for all methods in this 
	            // CompilationUnit, including inner class methods
	     
	        	
	        	
	        	cyclocounter = 1;
	    		Pattern pattern = Pattern.compile(
	    				"(\\&\\&|\\|\\|)|((^| +|\\}|\\;|\t)((if|for|while|catch)( +|\\()))|(\\?.*\\:)|((\t|^|\\;|\\{\\})(case +|continue;))",
	    				Pattern.MULTILINE);
	    		String ok = n.toString();
	    		String cleanText = ok.replaceAll("\\/\\/(.*)|\\/\\*([\\s\\S]*?)\\*\\/", "");
	    		Matcher matcher = pattern.matcher(cleanText);
	    		
	    		while (matcher.find()) {
	    			cyclocounter++;
	    		}
	           
    	        
    	      
    	        
    	        nrcyclomethods.add(cyclocounter) ;
	        	  
	        
	          
	        	
	        	
	        	
    	        String s = n.getDeclarationAsString(false, false, false).substring(n.getDeclarationAsString(false, false, false).indexOf(n.getNameAsString()));
        		namesofmethods.add(s.replaceAll(" ",""));           
	            int methodBodyLength = n.getRange().map(range -> range.end.line - range.begin.line).orElse(0);
	            int x = Math.abs(methodBodyLength);
	            nrlinemethods.add(x);
	            counter++;
	        }
	       
	        }
	        
	    private static class ConsVisitor extends VoidVisitorAdapter<Object>{
	    	
	    	@Override
	    	public void visit(ConstructorDeclaration n, Object arg) {
	    		cyclocounter = 1;
	    		Pattern pattern = Pattern.compile(
	    				"(\\&\\&|\\|\\|)|((^| +|\\}|\\;|\t)((if|for|while|catch)( +|\\()))|(\\?.*\\:)|((\t|^|\\;|\\{\\})(case +|continue;))",
	    				Pattern.MULTILINE);
	    		String ok = n.toString();
	    		String cleanText = ok.replaceAll("\\/\\/(.*)|\\/\\*([\\s\\S]*?)\\*\\/", "");
	    		Matcher matcher = pattern.matcher(cleanText);
	    		while (matcher.find()) {
	    			cyclocounter++;
	    		}
	           
	    	     nrcyclomethods.add(cyclocounter) ;

	    		
	    		
	    	    namesofmethods.add(n.getDeclarationAsString(false, false, false).replaceAll(" ", ""));
	            int methodBodyLength = n.getRange().map(range -> range.end.line - range.begin.line).orElse(0);
	            int x = Math.abs(methodBodyLength);
	             nrlinemethods.add(x);
	            counter++;
	            
	    		
	    	
	    	}
	    }
	    	
public static int getCycloCyclo(ArrayList<Integer> a) {
	
	for( int b :  a) {
		cyclocountercounter=cyclocountercounter + b ;
		
	}
	return cyclocountercounter;
	}
	


	

	
	}
	
	
	

	
