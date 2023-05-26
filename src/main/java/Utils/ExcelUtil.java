package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtil(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void getDATA(int getRow, int getCell) {

        DataFormatter dataFormatter = new DataFormatter();
        Object value = dataFormatter.formatCellValue(sheet.getRow(getRow).getCell(getCell));

        System.out.println(value);

    }
    public void getRowCount() {

        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowCount);

    }
}
