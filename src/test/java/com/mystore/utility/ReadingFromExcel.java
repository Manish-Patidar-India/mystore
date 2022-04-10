package com.mystore.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingFromExcel {

	public static Object[] readData(String sheetName) throws Throwable, IOException {

		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Testdata\\testdata1.xlsx");
		Map<String, String> map;

		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum();
		int totalCol = sheet.getRow(0).getLastCellNum();

		Object obj[] = new Object[totalRows];

		DataFormatter df = new DataFormatter();

		for (int i = 1; i <= totalRows; i++) {

			map = new HashMap<String, String>();
			for (int j = 0; j < totalCol; j++) {

				String key = df.formatCellValue(sheet.getRow(0).getCell(j));
				String value = df.formatCellValue(sheet.getRow(i).getCell(j));

				map.put(key, value);

			}
			obj[i - 1] = map;  //you can also create a list and sote into it and return it  or later can ocnvert into array
		}

		fs.close();
		return obj;   //we are returning the objects of hashmap  it is one dimensional
		//as in every object there is one hasmap object which contains keys and values for one row

		/*
		
		List<Map<String ,String>> list=new ArrayList<>();
		list.add((map);  jaha apne obj[i - 1] = map; ye likh rhe vha
		return list.toArray()     for returning object[]  same hai phle list banaye fir aray of object mai convert kiya
		
		agr tum chaho toh list he retun kr skte ho change your return type and methods mai accept toh map  he hoga because it is list of map
		*/
	}

}
