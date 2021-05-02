package application;

/**
 * @author rgmpo-iscte
 *
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import metrics.Foo;
import metrics.NOM_class;
import metrics.LOC_class;

public class Gui {

	private JFrame frame;
	private JTable table;
	

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
		            String excelname = "C:\\Users\\frank\\Desktop\\anothertest\\anothertest.xls" ;
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
		            
		            linham.createCell(6).setCellValue(foo.getCycloCyclo());
		            
		            linham.createCell(7).setCellValue(foo.getListNr().get(i));
		           
		            linham.createCell(8).setCellValue(foo.getCycloCount().get(i));
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(10, 45, 462, 345);
		frame.getContentPane().add(table);
		
		JButton viewmetricsbutton = new JButton("Visualizar Métricas");
		viewmetricsbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Código para ler e importar excel gerado para a Jtable
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
	  }

