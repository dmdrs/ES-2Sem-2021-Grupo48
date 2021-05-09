package application;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import java.io.Serializable;

public class CodeSmellsComparar implements Serializable {
	private HSSFWorkbook workbookread;
	private HSSFWorkbook workbookread3;
	private int VP1;
	private int FP1;
	private int VN1;
	private int FN1;
	private int VP2;
	private int FP2;
	private int VN2;
	private int FN2;
	private InputStream excelFile;
	private InputStream excelFile3;
	private org.apache.poi.ss.usermodel.Sheet sheet;
	private org.apache.poi.ss.usermodel.Sheet sheet3;
	private Cell classname;
	private Cell methodname;
	private Cell isLongMethod;
	private Cell isGodClass;
	private int lastRowNum;
	
	
	public int getVP1() {
		return VP1;
	}

	public int getFP1() {
		return FP1;
	}

	public int getVN1() {
		return VN1;
	}

	public int getFN1() {
		return FN1;
	}

	public int getVP2() {
		return VP2;
	}

	public int getFP2() {
		return FP2;
	}

	public int getVN2() {
		return VN2;
	}

	public int getFN2() {
		return FN2;
	}
	
	public void setExcelFile() throws IOException {
			this.excelFile = new FileInputStream(Gui.getLocation());
		
	}

	public void setExcelFile3() throws IOException {
			this.excelFile3 = new FileInputStream("Code_Smells.xls");

	}
	
	public InputStream getExcelFile() {
		return excelFile;
	}

	public InputStream getExcelFile3() {
		return excelFile3;
	}

	public int getLastRowNum() {
		return lastRowNum;
	}

	public void setLastRowNum(int lastRowNum) {
		this.lastRowNum = lastRowNum;
	}
	
	public void setWorkbookread3() throws IOException {
		VP1 = 0;
		FP1 = 0;
		VN1 = 0;
		FN1 = 0;
		setExcelFile3();
		workbookread3 = new HSSFWorkbook(excelFile3);	
		sheet3 = workbookread3.getSheetAt(0);
	}

	public void setWorkbookread() throws IOException {
		setExcelFile();
		workbookread = new HSSFWorkbook(excelFile);
		sheet = workbookread.getSheetAt(0);
	}

	public void goThroughSheet() {
		setLastRowNum(sheet.getLastRowNum());
		//lastRowNum = sheet.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			Row excelrow = sheet.getRow(i);
			classname = excelrow.getCell(2);
			methodname = excelrow.getCell(3);
			isLongMethod = excelrow.getCell(9);
			isGodClass = excelrow.getCell(10);
			forLongMethod();
			if (isGodClass != null) {
				forGodClass();
			}
		}
	}

	private void forLongMethod() {
		for (int j = 1; j <= sheet3.getLastRowNum(); j++) {
			Row excelrow2 = sheet3.getRow(j);
			Cell classname2 = excelrow2.getCell(2);
			Cell methodname2 = excelrow2.getCell(3);
			Cell isLongMethod2 = excelrow2.getCell(10);
			if (classname.toString().equals(classname2.toString())
					&& methodname.toString().equals(methodname2.toString())) {
				if (isLongMethod.getBooleanCellValue() == true && isLongMethod2.getBooleanCellValue() == true) {
					VP1++;
				}
				if (isLongMethod.getBooleanCellValue() == true && isLongMethod2.getBooleanCellValue() == false) {
					FP1++;
				}
				if (isLongMethod.getBooleanCellValue() == false && isLongMethod2.getBooleanCellValue() == false) {
					VN1++;
				}
				if (isLongMethod.getBooleanCellValue() == false && isLongMethod2.getBooleanCellValue() == true) {
					FN1++;
				}
			}
		}	
	}

	private void forGodClass() {
		for (int j = 1; j <= sheet3.getLastRowNum(); j++) {
			Row excelrow2 = sheet3.getRow(j);
			Cell classname2 = excelrow2.getCell(2);
			Cell isGodClass2 = excelrow2.getCell(7);
			if (classname.toString().equals(classname2.toString())) {
				if (isGodClass.getBooleanCellValue() == true && isGodClass2.getBooleanCellValue() == true) {
					VP2++;
				}
				if (isGodClass.getBooleanCellValue() == true && isGodClass2.getBooleanCellValue() == false) {
					FP2++;
				}
				if (isGodClass.getBooleanCellValue() == false && isGodClass2.getBooleanCellValue() == false) {
					VN2++;
				}
				if (isGodClass.getBooleanCellValue() == false && isGodClass2.getBooleanCellValue() == true) {
					FN2++;
				}
					j = sheet3.getLastRowNum();
			}
		}
	}		
	
	public void compararGodClass() throws IOException {
		setWorkbookread3();
		setWorkbookread();
		goThroughSheet();
		}
	
	public void compararLongMethod() throws IOException {
		setWorkbookread3();
		setWorkbookread();
		goThroughSheet();
	}


}	

