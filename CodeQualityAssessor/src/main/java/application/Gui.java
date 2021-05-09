package application;

/**
 * @author rgmpo-iscte
 *
 */

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


import metrics.Foo;
import metrics.Metricas;

public class Gui {

	private JFrame frame;
	private JTable table;
	private HSSFWorkbook workbookread;
	protected String name;
	protected String filepath;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	protected ArrayList<String> classes = new ArrayList<String>();
	private static String excelLocation;

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
					gerarexcel();

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
		
		JLabel labelLongMethod = new JLabel("Long Method:");
		labelLongMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelLongMethod.setBounds(10, 302, 121, 23);
		frame.getContentPane().add(labelLongMethod);
		
		JLabel labelGodClass = new JLabel("God Class:");
		labelGodClass.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelGodClass.setBounds(10, 394, 121, 23);
		frame.getContentPane().add(labelGodClass);
		
		JLabel lblNewLabel = new JLabel(">");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(143, 353, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(">");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(432, 353, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(">");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(143, 446, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(">");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(432, 446, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox andor1 = new JComboBox();
		andor1.setModel(new DefaultComboBoxModel(new String[] {"E", "OU"}));
		andor1.setBounds(239, 351, 47, 22);
		frame.getContentPane().add(andor1);
		
		JComboBox andor2 = new JComboBox();
		andor2.setModel(new DefaultComboBoxModel(new String[] {"E", "OU"}));
		andor2.setBounds(239, 444, 47, 22);
		frame.getContentPane().add(andor2);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField1.setBounds(167, 352, 62, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField2.setColumns(10);
		textField2.setBounds(454, 352, 62, 20);
		frame.getContentPane().add(textField2);
		
		textField3 = new JTextField();
		textField3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField3.setColumns(10);
		textField3.setBounds(167, 445, 62, 20);
		frame.getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField4.setColumns(10);
		textField4.setBounds(454, 445, 62, 20);
		frame.getContentPane().add(textField4);
		
		JComboBox metrica1 = new JComboBox();
		metrica1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		metrica1.setModel(new DefaultComboBoxModel(new String[] {"LOC_method", "CYCLO_method"}));
		metrica1.setBounds(10, 351, 126, 22);
		frame.getContentPane().add(metrica1);
		
		JComboBox metrica2 = new JComboBox();
		metrica2.setModel(new DefaultComboBoxModel(new String[] {"CYCLO_method", "LOC_method"}));
		metrica2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		metrica2.setBounds(296, 351, 126, 22);
		frame.getContentPane().add(metrica2);
		
		JComboBox metrica3 = new JComboBox();
		metrica3.setModel(new DefaultComboBoxModel(new String[] {"WMC_class", "NOM_class", "LOC_class"}));
		metrica3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		metrica3.setBounds(10, 444, 126, 22);
		frame.getContentPane().add(metrica3);
		
		JComboBox metrica4 = new JComboBox();
		metrica4.setModel(new DefaultComboBoxModel(new String[] {"NOM_class", "WMC_class", "LOC_class"}));
		metrica4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		metrica4.setBounds(296, 444, 126, 22);
		frame.getContentPane().add(metrica4);
		
		JScrollPane scrollPane_historico = new JScrollPane();
		scrollPane_historico.setBounds(576, 302, 535, 195);
		frame.getContentPane().add(scrollPane_historico);
		
		JTextArea textAreahistorico = new JTextArea();
		scrollPane_historico.setViewportView(textAreahistorico);
		try {
			Historico.mostrarhistorico(textAreahistorico);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JButton guardaregras = new JButton("Guardar Regras Definidas");
		guardaregras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historico.escreverhistorico(metrica1.getSelectedItem().toString(), Integer.parseInt(textField1.getText()),  andor1.getSelectedItem().toString(), metrica2.getSelectedItem().toString(), Integer.parseInt(textField2.getText()), metrica3.getSelectedItem().toString(), Integer.parseInt(textField3.getText()), andor2.getSelectedItem().toString(), metrica4.getSelectedItem().toString(), Integer.parseInt(textField4.getText()));
				try {
					Historico.mostrarhistorico(textAreahistorico);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		guardaregras.setBounds(180, 510, 175, 31);
		frame.getContentPane().add(guardaregras);
		
		JButton avaliarcodesmells = new JButton("Detetar Code Smells");
		avaliarcodesmells.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CodeSmells dialog = new CodeSmells();
				dialog.setVisible(true);
				try {
					dialog.detecaoLongMethod(filepath + "/" + name + "_metrics.xls",metrica1.getSelectedItem().toString(), Integer.parseInt(textField1.getText()),  andor1.getSelectedItem().toString(), metrica2.getSelectedItem().toString(), Integer.parseInt(textField2.getText()));
					dialog.detecaoGodClass(filepath + "/" + name + "_metrics.xls",metrica3.getSelectedItem().toString(), Integer.parseInt(textField3.getText()), andor2.getSelectedItem().toString(), metrica4.getSelectedItem().toString(), Integer.parseInt(textField4.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	public void readContent(File file) throws IOException{
	    try {
			Metricas.main(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	public void gerarexcel() throws IOException {
		String excelname = filepath + "/" + name + "_metrics.xls" ;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Code Smells");  
        setLocation(excelname);

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
           
        int a = 0;
        for(Foo foo : Foo.foos) {
       
        if(foo.getList().size()!=0 || foo.getCount()!=0) {
    	
        for(int i =0 ; i!= foo.getCount(); i++) {

        HSSFRow linham = foo.escreverMetricas(sheet, a, i);

        }
      
        }
        a = a + foo.getCount();
        }
       
        
        FileOutputStream fileOut = new FileOutputStream(excelname);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
       

	}

	public void importExcelToJtable() throws IOException {
		ArrayList<String> packages = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		ArrayList<String> metodos = new ArrayList<String>();
		ArrayList<String> linhas = new ArrayList<String>();
		int countmethod = 0;
		try {
			InputStream excelFile = new FileInputStream(filepath + "/" + name + "_metrics.xls");
			workbookread = new HSSFWorkbook(excelFile);
            org.apache.poi.ss.usermodel.Sheet sheet = workbookread.getSheetAt(0);
            countmethod = sheet.getLastRowNum();
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

	public ArrayList<String> getStringList() {
	    return classes;
	}
	
	public void setStringList(ArrayList<String> s) {
	    this.classes=s;
	}
	
	public static String getLocation() {
		return excelLocation;
	}
	public void setLocation(String s) {
		//s=filepath + "/" + name + "_metrics.xls";
		this.excelLocation = s;
	}
	
}

