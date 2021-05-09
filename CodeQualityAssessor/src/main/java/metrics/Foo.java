package metrics;

import java.io.File;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class Foo {
    private File fi;
    private MethodNames mn; 
    private MethodNr nrr;
    private Methodc cnrr;
    private int in;
    private int loc;
    private int cyclocyclo;
  
    private String pn;
    public static ArrayList<Foo> foos = new ArrayList<Foo>();
    
    public Foo(String p, File f, MethodNames s, int i, int lc, MethodNr nr, Methodc cnr, int wmc) {
		this.fi=f;
		this.mn=s;
		this.in=i;
		this.pn=p;
		this.loc=lc;
		this.nrr=nr;
		this.cnrr=cnr;
		this.cyclocyclo=wmc;
		
	}
	
    
	public static ArrayList<Foo> getFoo() {

		return foos;

	}
	public String getPackageName() {
		
	return pn;
	}
	
	public File getFile() {
	return fi;
	}
    public ArrayList<String> getList() {
    	return mn.getList();
    }
    public ArrayList<Integer> getListNr() {
    	return nrr.getList();
    }
    
    public int getLoc() {
    	
    	return loc;
    }
    
    public int getCycloCyclo() {
    	
    return cyclocyclo;	
    }
    

    public ArrayList<Integer> getCycloCount() {
    	return cnrr.getListc();
    }
    
    //deve ser 248
	public int getCount() {
		return in;
	}
	public static int getTotalCount() {
		int a = 0;
		for(Foo foo: foos) {
			 a =  a+ foo.getCount();
		}
		return a ;
	}


	public HSSFRow escreverMetricas(HSSFSheet sheet, int a, int i) {
		HSSFRow linham = sheet.createRow(a + i + 1);
		linham.createCell(0).setCellValue(Integer.toString(a + i + 1));
		linham.createCell(1).setCellValue(getPackageName());
		String classname = getFile().getName();
		String target = String.copyValueOf(".java".toCharArray());
		classname = classname.replace(target, "");
		linham.createCell(2).setCellValue(classname);
		linham.createCell(3).setCellValue(getList().get(i));
		linham.createCell(4).setCellValue(Integer.toString(getCount()));
		linham.createCell(5).setCellValue(Integer.toString(getLoc()));
		linham.createCell(6).setCellValue(Integer.toString(getCycloCyclo()));
		linham.createCell(7).setCellValue(Integer.toString(getListNr().get(i)));
		linham.createCell(8).setCellValue(Integer.toString(getCycloCount().get(i)));
		return linham;
	}
	}

	
