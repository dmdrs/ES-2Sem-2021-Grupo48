package application;

/**
 * @author rgmpo-iscte
 *
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import metrics.Foo;
import metrics.NOM_class;
import metrics.LOC_class;

public class Gui {

	private JFrame frame;
	private JTable table;
	private HSSFWorkbook workbookread;
	protected String name;
	protected String filepath;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1137, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton readjavabutton = new JButton("Carregar projeto Java");
		readjavabutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            int option = fileChooser.showOpenDialog(frame);
	            if(option == JFileChooser.APPROVE_OPTION){
	               File file = fileChooser.getSelectedFile();
	               filepath =  (String) file.getAbsolutePath();
	               name = (String) file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\")+1);
	               System.out.println("Folder Selected: " + filepath);
	               listAllFiles (file);
	            }else{
	            	System.out.println("Open command canceled");
	            }
			}
		});
		readjavabutton.setBounds(10, 11, 165, 23);
		frame.getContentPane().add(readjavabutton);
		
		JButton excelbutton = new JButton("Gerar excel com métricas");
		excelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
		            String excelname = filepath + "/" + name + "_metrics.xls" ;
		            HSSFWorkbook workbook = new HSSFWorkbook();
		            HSSFSheet sheet = workbook.createSheet("Code Smells");  

		            HSSFRow colunacima = sheet.createRow((short)0);
		            colunacima.createCell(0).setCellValue("ID.");
		            colunacima.createCell(1).setCellValue("Package");
		            colunacima.createCell(2).setCellValue("class");
		            colunacima.createCell(3).setCellValue("method");
		            colunacima.createCell(4).setCellValue("NOM_class");
		            colunacima.createCell(5).setCellValue("LOC_class");
		            colunacima.createCell(6).setCellValue("WMC_class");
		            colunacima.createCell(7).setCellValue("LOC_method");
		            colunacima.createCell(8).setCellValue("CYCLO_method");
		           
		           
		            System.out.println(Foo.getTotalCount());
		            int a = 0;
		            for(Foo foo : Foo.foos) {
		           
		            if(foo.getList().size()!=0 || foo.getCount()!=0) {
		        	
		            for(int i =0 ; i!= foo.getCount(); i++) {

		            HSSFRow linham= sheet.createRow(a+i+1);
		            	
		            linham.createCell(0).setCellValue(Integer.toString(a+i+1));
		            	
		            linham.createCell(1).setCellValue(foo.getPackageName());
		            
		            String classname= foo.getFile().getName();
		            String target=String.copyValueOf(".java".toCharArray());
		            classname=classname.replace(target, "");
		            linham.createCell(2).setCellValue(classname);
		            	
		            linham.createCell(3).setCellValue(foo.getList().get(i));
		   
		            linham.createCell(4).setCellValue(Integer.toString(foo.getCount()));
		            
		            linham.createCell(5).setCellValue(Integer.toString(foo.getLoc()));
		            
		            linham.createCell(6).setCellValue(Integer.toString(foo.getCycloCyclo()));
		            
		            linham.createCell(7).setCellValue(Integer.toString(foo.getListNr().get(i)));
		           
		            linham.createCell(8).setCellValue(Integer.toString(foo.getCycloCount().get(i)));

//		            linham.createCell(7).setCellValue(Integer.toString(foo.getListNr().get(i)));

		            }
		            
		          
		            }
		            a = a + foo.getCount();
		            }
		           
		            
		            FileOutputStream fileOut = new FileOutputStream(excelname);
		            workbook.write(fileOut);
		            fileOut.close();
		            workbook.close();
		            System.out.println("Your excel file has been generated!");

		        } catch ( Exception ex ) {
		            System.out.println(ex);
		        }
		    
			}
			
		});
		excelbutton.setBounds(185, 11, 187, 23);
		frame.getContentPane().add(excelbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 760, 248);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID.", "Package", "class", "method", "NOM_class", "LOC_class", "WMC_class", "LOC_method", "CYCLO_method"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(8).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		
		
		JButton viewmetricsbutton = new JButton("Visualizar Métricas");
		viewmetricsbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					importExcelToJtable();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		viewmetricsbutton.setBounds(10,510, 165, 31);
		frame.getContentPane().add(viewmetricsbutton);
		
		JButton guardaregras = new JButton("Guardar Regras Definidas");
		guardaregras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		guardaregras.setBounds(180, 510, 175, 31);
		frame.getContentPane().add(guardaregras);
		
		JButton avaliarcodesmells = new JButton("Detetar Code Smells");
		avaliarcodesmells.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		avaliarcodesmells.setBounds(364, 510, 193, 31);
		frame.getContentPane().add(avaliarcodesmells);
	}
	
	public void listAllFiles(File folder){
	    File[] fileNames = folder.listFiles();
	    
	    for(File file : fileNames){
	      if(file.isDirectory()){
    	  //Caso identifique que é uma subpasta lança outra vez o ListAllFiles
	         listAllFiles(file);
	      }else{
	        try {
	        	if(file.getName().endsWith("java")) {
	          readContent(file);
	        	}
	        } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	      }
	    }
	  }
	
	//será que tem de ter algo para não ler imagens? perguntar ao prof
	public void readContent(File file) throws IOException{
	    System.out.println("reading file " + file.getCanonicalPath() );
	    
	    try {
			NOM_class.main(file);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    }
	public void importExcelToJtable() throws IOException {
		ArrayList<String> packages = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> metodos = new ArrayList<String>();
		ArrayList<String> linhas = new ArrayList<String>();
		try {
			InputStream excelFile = new FileInputStream(filepath + "/" + name + "_metrics.xls");
			workbookread = new HSSFWorkbook(excelFile);
            org.apache.poi.ss.usermodel.Sheet sheet = workbookread.getSheetAt(0);
			for (int i = 1; i <= sheet.getLastRowNum(); i++)//iterate all rows from the first one to the last 
			{
				Row excelrow = sheet.getRow(i);
				
				Cell id = excelrow.getCell(0);
                Cell packagename = excelrow.getCell(1);
                Cell classname = excelrow.getCell(2);
                Cell methodname = excelrow.getCell(3);
                Cell nom_class = excelrow.getCell(4);
                Cell loc_class = excelrow.getCell(5);
                Cell wmc_class = excelrow.getCell(6);
                Cell loc_method = excelrow.getCell(7);
                Cell cyclo_method = excelrow.getCell(8);
                
                packages.add(packagename.toString());
                classes.add(classname.toString());
                metodos.add(methodname.toString());
                linhas.add(loc_method.toString());

               
			  	//Adiciona a tabela os valores
			  	DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{id,packagename,classname, methodname, nom_class,loc_class,wmc_class,loc_method,cyclo_method});
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		int countpack = getocurrencias(packages);
		int countclass = getocurrencias(classes);
		int countmethod = getocurrencias(metodos);
		int countlines = somalinhas(linhas);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(800, 43, 300, 248);
		frame.getContentPane().add(scrollPane_1);
		JTextArea textArea = new JTextArea();
		textArea.setRows(4);
		textArea.append("Número de Packages: "+countpack+"\n");
		textArea.append("Número de Classes: "+countclass+"\n");
		textArea.append("Número de Métodos: "+countmethod+"\n");
		textArea.append("Número de linhas total do código: "+countlines+"\n");
		scrollPane_1.setViewportView(textArea);				
	}
	public static int getocurrencias(ArrayList <String> lista) {
		Set<String> set = new HashSet<>(lista);
		lista.clear();
		lista.addAll(set);
		int count=lista.size();
		return count;
	}
	public static int somalinhas(ArrayList <String> lista) {
		int soma =0;
		for (int i=0;i<lista.size();i++) {
			soma += Integer.parseInt(lista.get(i));
		}
		return soma;
	}
}

