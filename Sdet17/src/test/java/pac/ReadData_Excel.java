package pac;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		FileInputStream f = new FileInputStream("../Sdet17/SDET17.xlsx");	
		Workbook wb = WorkbookFactory.create(f);
		Sheet sh = wb.getSheet("Sheet1");		//it will open 'Sheet1' of excel file
//		Row r = sh.getRow(1);
//		String data = r.getCell(4).toString();
//		System.out.println(data);	
		
		Row r0 = sh.getRow(0);					//it will select row 1
		for(int i=0;i<5;i++) {
			String data = r0.getCell(i).getStringCellValue();
			System.out.print(data+"\t");
		}
		
		System.out.println();
		
		Row r1 = sh.getRow(1);					
		for(int i=0;i<5;i++) {
			String data = r1.getCell(i).getStringCellValue();
			System.out.print(data+"\t");
		}
	}
}