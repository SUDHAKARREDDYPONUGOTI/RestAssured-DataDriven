package XLUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class xlsxfile_read_util {
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream("\\src\\test\\java\\XLUtil\\RestAPIdata.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IllegalFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = (Sheet) book.getSheet(sheetName);
		Object[][] data = new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum(); i++) {
			for (int k = 0; k < ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum(); k++) {
				data[i][k] = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

}
