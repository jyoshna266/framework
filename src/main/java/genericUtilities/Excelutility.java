package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	private Workbook wb;
	private Sheet Sh;
	DataFormatter df;
	public void excelInit(String excelpath,String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelpath);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		wb = WorkbookFactory.create(fis);
	}
	catch(EncryptedDocumentException| IOException e) {
		e.printStackTrace();
	}
	Sh = wb.getSheet(sheetName);
	df = new DataFormatter();
}
	public Map<String,String> readFromExcel(String expectedTestName) {
		Map<String, String> map = new HashMap<String,String>();
		for(int i=0; i<=  Sh.getLastRowNum();i++) {
			
			if(df.formatCellValue(Sh.getRow(i).getCell(1)).equals(expectedTestName)) {
	
				for(int j= i;j<=Sh.getFirstRowNum();j++) {
					map.put(df. formatCellValue(Sh.getRow(j).getCell(2)),
							df.formatCellValue(Sh.getRow(j).getCell(3)));
					if(df.formatCellValue(Sh.getRow(j).getCell(2)).equals("####"))
					break;
				}
					break;
				}
}
 
		return map;
}
 public void updateTeststatus(String expectedTestname,String status,String excelpath) {
	 for (int i =0; i<= Sh.getLastRowNum();i++) {
		 if(df.formatCellValue(Sh.getRow(i).getCell(1)).equals(expectedTestname)){
				 Cell c = Sh.getRow(i).createCell(4);
				 c.setCellValue(status);
		 break;
	 }
 	}
 FileOutputStream fos = null;
		 try {
			 fos = new FileOutputStream(excelpath);
		 }catch (FileNotFoundException e) {
			 e.printStackTrace();
		 }
		 try {
			 wb.write(fos);
		 } catch (IOException e) {
			 e.printStackTrace();
			 
		 }
	
		 }

	
public void closeExcel() {
	try {
		wb.close();
	}
	catch (IOException e ) {
	e.printStackTrace();
		}
	}
}


