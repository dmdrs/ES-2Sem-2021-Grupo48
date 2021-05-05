package application;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CodeSmells extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private HSSFWorkbook workbookread;
	private HSSFWorkbook workbookread2;
	private HSSFWorkbook workbookread3;
	private JTable tableLongMethod;
	private  JTable tableGodClass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CodeSmells dialog = new CodeSmells();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CodeSmells() {
		setTitle("Deteção de Code Smells");
		setBounds(100, 100, 1104, 693);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 39, 526, 565);
		contentPanel.add(scrollPane1);
		
		tableLongMethod = new JTable();
		tableLongMethod.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Method ID", "is Long Method"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane1.setViewportView(tableLongMethod);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(573, 39, 493, 565);
		contentPanel.add(scrollPane2);
		
		tableGodClass = new JTable();
		tableGodClass.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Class", "is God Class"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane2.setViewportView(tableGodClass);
		
		JLabel lblLongMethod = new JLabel("Long Method:");
		lblLongMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLongMethod.setBounds(10, 11, 204, 26);
		contentPanel.add(lblLongMethod);
		
		JLabel lblGodClass = new JLabel("God Class:");
		lblGodClass.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGodClass.setBounds(573, 11, 204, 26);
		contentPanel.add(lblGodClass);
		
		JButton btnqualidade = new JButton("Avaliar Qualidade dos Code Smells Detetados");
		btnqualidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnqualidade.setBounds(10, 615, 249, 28);
		contentPanel.add(btnqualidade);
	}
	
	public void detecaoLongMethod (String file, String metrica1 , int valor1,  String andor1, String metrica2, int valor2) throws IOException {
		try {
			InputStream excelFile = new FileInputStream(file);
			workbookread2 = new HSSFWorkbook(excelFile);
            org.apache.poi.ss.usermodel.Sheet sheet = workbookread2.getSheetAt(0);
            HSSFRow colunacima = (HSSFRow) sheet.getRow(0);
            colunacima.createCell(9).setCellValue("is Long Method");
			if (andor1.equals("E")) {
				for (int i = 1; i <= sheet.getLastRowNum(); i++){ 
				boolean a = false;
				Row excelrow = sheet.getRow(i);
				Cell id = excelrow.getCell(0);
                Cell loc_method = excelrow.getCell(7);
                Cell cyclo_method = excelrow.getCell(8);
                String loc = loc_method.toString();
                String cyclo = cyclo_method.toString();
                DefaultTableModel model = (DefaultTableModel) tableLongMethod.getModel();
                
                if (metrica1.equals("LOC_method")) {
                	if (Integer.parseInt(loc)>valor1 && Integer.parseInt(cyclo)>valor2) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                else {
                	if(Integer.parseInt(cyclo)>valor1 && Integer.parseInt(loc)>valor2) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
			  model.addRow(new Object[]{id,a});
			  excelrow.createCell(9).setCellValue(a);
				
				}
				
			}
				else {//OR
					for (int i = 1; i <= sheet.getLastRowNum(); i++){ 
						boolean a = false;
						Row excelrow = sheet.getRow(i);
						Cell id = excelrow.getCell(0);
		                Cell loc_method = excelrow.getCell(7);
		                Cell cyclo_method = excelrow.getCell(8);
		                String loc = loc_method.toString();
		                String cyclo = cyclo_method.toString();
		                DefaultTableModel model = (DefaultTableModel) tableLongMethod.getModel();
		                
		                if (metrica1.equals("LOC_method")) {
		                	if (Integer.parseInt(loc)>valor1 || Integer.parseInt(cyclo)>valor2) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                else {
		                	if(Integer.parseInt(cyclo)>valor1 || Integer.parseInt(loc)>valor2) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
					  model.addRow(new Object[]{id,a});
					  excelrow.createCell(9).setCellValue(a);	
						}
				}
			
			FileOutputStream fileOut = new FileOutputStream(file);
            workbookread2.write(fileOut);
            fileOut.close();
            workbookread2.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	public void detecaoGodClass (String file, String metrica3 , int valor3,  String andor2, String metrica4, int valor4) throws IOException {
		try {
			InputStream excelFile = new FileInputStream(file);
			workbookread2 = new HSSFWorkbook(excelFile);
            org.apache.poi.ss.usermodel.Sheet sheet = workbookread2.getSheetAt(0);
            HSSFRow colunacima = (HSSFRow) sheet.getRow(0);
            colunacima.createCell(10).setCellValue("is God Class");
            
				for (int i = 1; i <= sheet.getLastRowNum(); i++){ 
				boolean a = false;
				Row excelrow = sheet.getRow(i);
				Row excelrow2 = sheet.getRow(i-1);
				Cell classname = excelrow.getCell(2);
				Cell classname2 = excelrow2.getCell(2);
                Cell nom_class = excelrow.getCell(4);
                Cell loc_class = excelrow.getCell(5);
                Cell wmc_class = excelrow.getCell(6);
                String nom = nom_class.toString();
                String loc = loc_class.toString();
                String wmc = wmc_class.toString();
                DefaultTableModel model = (DefaultTableModel) tableGodClass.getModel();
                if(classname.toString().equals(classname2.toString())==false) {
                if (andor2.equals("E")) {
                if (metrica3.equals("LOC_class")&&metrica4.equals("NOM_class")) {
                	if (Integer.parseInt(loc)>valor3 && Integer.parseInt(nom)>valor4) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                if (metrica3.equals("LOC_class")&&metrica4.equals("WMC_class")) {
                	if(Integer.parseInt(loc)>valor3 && Integer.parseInt(wmc)>valor4) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
                if (metrica3.equals("WMC_class")&&metrica4.equals("NOM_class")) {
                	if (Integer.parseInt(wmc)>valor3 && Integer.parseInt(nom)>valor4) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                if (metrica3.equals("WMC_class")&&metrica4.equals("LOC_class")) {
                	if(Integer.parseInt(wmc)>valor3 && Integer.parseInt(loc)>valor4) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
                if (metrica3.equals("NOM_class")&&metrica4.equals("LOC_class")) {
                	if (Integer.parseInt(nom)>valor3 && Integer.parseInt(loc)>valor4) {
                		a=true;
                	}
                	else {
        				a=false;
                	}
                }
                
                if (metrica3.equals("NOM_class")&&metrica4.equals("WMC_class")) {
                	if(Integer.parseInt(nom)>valor3 && Integer.parseInt(wmc)>valor4) {
                		a=true;
                	}
                	else {
                		a=false;
                	}
                }
			  model.addRow(new Object[]{classname,a});
			  excelrow.createCell(10).setCellValue(a);
				
				}
				else {//OR
				
		                if (metrica3.equals("LOC_class")&&metrica4.equals("NOM_class")) {
		                	if (Integer.parseInt(loc)>valor3 || Integer.parseInt(nom)>valor4) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                if (metrica3.equals("LOC_class")&&metrica4.equals("WMC_class")) {
		                	if(Integer.parseInt(loc)>valor3 || Integer.parseInt(wmc)>valor4) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
		                if (metrica3.equals("WMC_class")&&metrica4.equals("NOM_class")) {
		                	if (Integer.parseInt(wmc)>valor3 || Integer.parseInt(nom)>valor4) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                if (metrica3.equals("WMC_class")&&metrica4.equals("LOC_class")) {
		                	if(Integer.parseInt(wmc)>valor3 || Integer.parseInt(loc)>valor4) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
		                if (metrica3.equals("NOM_class")&&metrica4.equals("LOC_class")) {
		                	if (Integer.parseInt(nom)>valor3 || Integer.parseInt(loc)>valor4) {
		                		a=true;
		                	}
		                	else {
		        				a=false;
		                	}
		                }
		                
		                if (metrica3.equals("NOM_class")&&metrica4.equals("WMC_class")) {
		                	if(Integer.parseInt(nom)>valor3 || Integer.parseInt(wmc)>valor4) {
		                		a=true;
		                	}
		                	else {
		                		a=false;
		                	}
		                }
					  model.addRow(new Object[]{classname,a});
					  excelrow.createCell(10).setCellValue(a);
						
						}
						
					}
				}
			
				FileOutputStream fileOut = new FileOutputStream(file);
	             workbookread2.write(fileOut);
	             fileOut.close();
	             workbookread2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}