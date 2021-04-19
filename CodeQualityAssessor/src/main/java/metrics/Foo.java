package metrics;

import java.io.File;
import java.util.ArrayList;

public class Foo {
    private File fi;
    private MethodNames mn; 
    private MethodNr nrr;
    private int in;
    private int loc;
    private String pn;
    public static ArrayList<Foo> foos = new ArrayList<Foo>();
    
    public Foo(String p, File f, MethodNames s, int i, int lc, MethodNr nr) {
		this.fi=f;
		this.mn=s;
		this.in=i;
		this.pn=p;
		this.loc=lc;
		this.nrr=nr;
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
	}

	
