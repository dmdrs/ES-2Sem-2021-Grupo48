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
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import metrics.CYCLO_method;

public class Gui {

	private JFrame frame;
	private JTable table;
	private CYCLO_method CYCLO_method;

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
	          readContent(file);
	        } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	      }
	    }
	  }
	
	public void readContent(File file) throws IOException{
	    System.out.println("reading file " + file.getCanonicalPath() );
	    try(BufferedReader br  = new BufferedReader(new FileReader(file))){
	      String strLine;
	      // le linhas do ficheiro, retorna null quando o ficheiro nao tem mais linhas 
	      while((strLine = br.readLine()) != null){
	      System.out.println("Line is - " + strLine);
	      }
	    }
	  }
}