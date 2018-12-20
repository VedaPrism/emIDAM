package Generic_Libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfn {

	FileInputStream fi;
	XSSFWorkbook wb;
	
//	Initializing the excel
	
	public Excelfn(String fpath) throws Exception {
		
		fi = new FileInputStream(fpath);
		wb = new XSSFWorkbook(fi);
	}
	
//	Get the rowcount
	
	public int getrowcount(String sheetname) {
		XSSFSheet xs = wb.getSheet(sheetname);
		return xs.getLastRowNum();
	}
	
//	Get the columncount
	
	public int getcolcount(String sheetname) {
		
		XSSFSheet xs = wb.getSheet(sheetname);
		return xs.getRow(0).getLastCellNum();
	}
	
//	Reading the values from Excel
	
	public String readvalue(int ri, int ci, String sheetname) {
		
		XSSFSheet xs = wb.getSheet(sheetname);
		XSSFCell xc = xs.getRow(ri).getCell(ci);
		String cellvalue = null;
		if(xc.getCellTypeEnum() == xc.getCellTypeEnum().STRING) {
			
			cellvalue = xc.getStringCellValue();
		}else if (xc.getCellTypeEnum() == xc.getCellTypeEnum().NUMERIC) {
			
			cellvalue = String.valueOf(xc.getNumericCellValue());
		}else if ((xc.getCellTypeEnum() == xc.getCellTypeEnum().BLANK) || (xc.getCellTypeEnum() == xc.getCellTypeEnum().ERROR)) {
			
			cellvalue="";
		}
		return cellvalue;
	}
	
//	Write value to excel
	
	public void writevalue(String sheetname, int ri, int ci, String input) {
		
		XSSFSheet xs = wb.getSheet(sheetname);
		xs.getRow(ri).getCell(ci).setCellValue(input);
	}
	
	public void save_close(String fpath) throws Exception {
		
		FileOutputStream fs = new FileOutputStream(fpath);
		wb.write(fs);
		fi.close();
		fs.close();
		
	}
	
}
