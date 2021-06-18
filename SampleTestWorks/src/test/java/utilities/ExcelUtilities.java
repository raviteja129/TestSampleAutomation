package utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtilities {
    public File fie;
    public FileInputStream fi;
    public XSSFWorkbook wb;

    public ExcelUtilities () {
        fie = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/QA_TestData.xlsx");
        try {
            fi = new FileInputStream(fie);
            wb = new XSSFWorkbook(fi);
        }
        catch (Exception e) {
            System.out.println("Unable to read excl file" + e.getMessage());
        }
    }

    public String getStringData(int sheetIndex, int row, int col) {
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
    }

    public String getStringData(String sheetName, int row, int col) {
        return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public double getNumericData(String sheetName, int row, int col) {
        return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }
}
