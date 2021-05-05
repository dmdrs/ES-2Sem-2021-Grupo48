package application;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javax.swing.JTable;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class CodeSmellsDetecao implements Serializable {
	private HSSFWorkbook workbookread2;
	private JTable tableLongMethod;
	private  JTable tableGodClass;
	
	public HSSFWorkbook getWorkbookread2() {
		return workbookread2;
	}

	public void setWorkbookread2(HSSFWorkbook workbookread2) {
		this.workbookread2 = workbookread2;
	}

	public JTable getTableLongMethod() {
		return tableLongMethod;
	}

	public void setTableLongMethod(JTable tableLongMethod) {
		this.tableLongMethod = tableLongMethod;
	}
	
	public JTable getTableGodClass() {
		return tableGodClass;
	}

	public void setTableGodClass(JTable tableGodClass) {
		this.tableGodClass = tableGodClass;
	}

	public void detecaoLongMethod(String file, String metrica1, int valor1, String andor1, String metrica2, int valor2)
			throws IOException {
		try {
			InputStream excelFile = new FileInputStream(file);
			workbookread2 = new HSSFWorkbook(excelFile);
			org.apache.poi.ss.usermodel.Sheet sheet = workbookread2.getSheetAt(0);
			HSSFRow colunacima = (HSSFRow) sheet.getRow(0);
			colunacima.createCell(9).setCellValue("is Long Method");
			if (andor1.equals("E")) {
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					boolean a = false;
					Row excelrow = sheet.getRow(i);
					Cell id = excelrow.getCell(0);
					Cell loc_method = excelrow.getCell(7);
					Cell cyclo_method = excelrow.getCell(8);
					String loc = loc_method.toString();
					String cyclo = cyclo_method.toString();
					DefaultTableModel model = (DefaultTableModel) tableLongMethod.getModel();
					if (metrica1.equals("LOC_method")) {
						if (Integer.parseInt(loc) > valor1 && Integer.parseInt(cyclo) > valor2) {
							a = true;
						} else {
							a = false;
						}
					} else {
						if (Integer.parseInt(cyclo) > valor1 && Integer.parseInt(loc) > valor2) {
							a = true;
						} else {
							a = false;
						}
					}
					model.addRow(new Object[] { id, a });
					excelrow.createCell(9).setCellValue(a);
				}
			} else {
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					boolean a = false;
					Row excelrow = sheet.getRow(i);
					Cell id = excelrow.getCell(0);
					Cell loc_method = excelrow.getCell(7);
					Cell cyclo_method = excelrow.getCell(8);
					String loc = loc_method.toString();
					String cyclo = cyclo_method.toString();
					DefaultTableModel model = (DefaultTableModel) tableLongMethod.getModel();
					if (metrica1.equals("LOC_method")) {
						if (Integer.parseInt(loc) > valor1 || Integer.parseInt(cyclo) > valor2) {
							a = true;
						} else {
							a = false;
						}
					} else {
						if (Integer.parseInt(cyclo) > valor1 || Integer.parseInt(loc) > valor2) {
							a = true;
						} else {
							a = false;
						}
					}
					model.addRow(new Object[] { id, a });
					excelrow.createCell(9).setCellValue(a);
				}
			}
			FileOutputStream fileOut = new FileOutputStream(file);
			workbookread2.write(fileOut);
			fileOut.close();
			workbookread2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void detecaoGodClass (String file, String metrica3 , int valor3,  String andor2, String metrica4, int valor4) throws IOException {
		try {
			InputStream excelFile = new FileInputStream(file);
			setWorkbookread2(new HSSFWorkbook(excelFile));
            org.apache.poi.ss.usermodel.Sheet sheet = getWorkbookread2().getSheetAt(0);
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
	             getWorkbookread2().write(fileOut);
	             fileOut.close();
	             getWorkbookread2().close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}