package Utils;

public class ExcelUtilTest {
    public static void main(String[] args) {
    String excelPath = "./TestData.xlsx";
    String sheet = "sheet1";
    ExcelUtil excelUtil = new ExcelUtil(excelPath, sheet);
        excelUtil.getRowCount();
        excelUtil.getDATA(1,0);
        excelUtil.getDATA(1,1);
        excelUtil.getDATA(1, 2);
}
}
