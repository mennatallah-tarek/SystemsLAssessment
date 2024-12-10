package Utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDataFromExcel {
    public static Map<String, String> readExcel(String filePath, String sheetName) {
        Map<String, String> data = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            // Access the specified sheet
            Sheet sheet = workbook.getSheet(sheetName);

            // Read the data from the first row (excluding headers)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String key = row.getCell(0).getStringCellValue(); // Column A
                String value = row.getCell(1).getStringCellValue(); // Column B
                data.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}

