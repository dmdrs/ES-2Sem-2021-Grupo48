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

import metrics.CYCLO_method;
import metrics.Foo;
import metrics.NOM_class;
import metrics.LOC_class;

public class Gui {

	private JFrame frame;
	private JTable table;
	private HSSFWorkbook workbookread;
	protected String name;
	

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
		frame.setBounds(100, 100, 797, 532);
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
	               String filename = file.getAbsolutePath();
	               name = (String) file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\")+1);
	               System.out.println("Folder Selected: " + filename);
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
					//Resolver nome do ficheiro. Tem de ser nomedapastarecebida_metrics.xls
		            String excelname = "D:/"+ name +"_metrics.xls" ;
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
		           
		            
		            //Código abaixo tem de ser substituido pelas métricas 
		            System.out.println(Foo.getTotalCount());
		            int a = 0;
		            for(Foo foo : Foo.foos) {
		           
		            if(foo.getList().size()!=0 || foo.getCount()!=0) {
		        	
		            for(int i =0 ; i!= foo.getCount(); i++) {

		            HSSFRow linham= sheet.createRow(a+i+1);
		            	
		            linham.createCell(0).setCellValue(a+i+1);
		            	
		            linham.createCell(1).setCellValue(foo.getPackageName());
		            
		            String classname= foo.getFile().getName();
		            String target=String.copyValueOf(".java".toCharArray());
		            classname=classname.replace(target, "");
		            linham.createCell(2).setCellValue(classname);
		            	
		            linham.createCell(3).setCellValue(foo.getList().get(i));
		   
		            linham.createCell(4).setCellValue(foo.getCount());
		            
		            linham.createCell(5).setCellValue(foo.getLoc());
		            
		            linham.createCell(7).setCellValue(foo.getListNr().get(i));

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
		scrollPane.setBounds(10, 43, 520, 248);
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
		viewmetricsbutton.setBounds(10, 407, 165, 31);
		frame.getContentPane().add(viewmetricsbutton);
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
		try {
			InputStream excelFile = new FileInputStream("D:/"+ name +"_metrics.xls");
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
                
               
			  	//Adiciona a tabela os valores
			  	DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{id,packagename,classname, methodname, nom_class,loc_class,wmc_class,loc_method,cyclo_method});
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
				
	}
	  }

