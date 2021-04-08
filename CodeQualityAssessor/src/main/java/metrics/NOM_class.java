
	package metrics;

	

	import java.io.File;
	import java.io.FileInputStream;
	

	
	import com.github.javaparser.StaticJavaParser;
	import com.github.javaparser.ast.CompilationUnit;
	import com.github.javaparser.ast.body.MethodDeclaration;
	
	import com.github.javaparser.ast.visitor.VoidVisitorAdapter;



	/**
	 * @author fmmba
	 *
	 */




	public class NOM_class  {
	    public static int counter;

		

	  
	    public static void main(File file) throws Exception {
	        // creates an input stream for the file to be parsed
	     counter = 0;
	     FileInputStream in = new FileInputStream( file);
	try {
	      CompilationUnit cu = StaticJavaParser.parse(in);
	      new MethodVisitor().visit(cu, null);
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
	            System.out.println(n.getName()+""+n.getParameters());
	            counter++;
	        }
	       
	        }
	        
	    }

	
