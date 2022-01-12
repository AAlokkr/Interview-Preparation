package utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelUtils {

    public static Object[][] getExcelData(String filepath) throws IOException {

        String[][] dataTab;
        FileInputStream fileInputStream = new FileInputStream(filepath);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int startRow = 0;
        int startCol = 0;
        int totalRows = xssfSheet.getLastRowNum() - xssfSheet.getFirstRowNum() + 1;
        int totalCol = xssfSheet.getRow(startRow).getLastCellNum() - xssfSheet.getRow(startRow).getFirstCellNum();
        dataTab = new String[totalRows][totalCol];

        for (int i = startRow; i < totalRows; i++) {
            XSSFRow row = xssfSheet.getRow(i);
            for (int j = startCol; j < totalCol; j++) {
                dataTab[i][j] = row.getCell(j).getStringCellValue();
            }
        }
        return dataTab;
    }
}
