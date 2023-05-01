package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;
    private String path;
    //Constuctor: Excel path ine ve Exceldeki sayfaya ulasmak icin 2 parametreli cons. olusturduk
    public ExcelUtils (String path, String sheetName){
        this.path = path;
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Satir ve sütun sayilari girildiğinde, o hücredeki veriyi return eder
    public String getCellData(int rowNum, int colNum){
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }
    //Excel deki satir sayisini return eder
    public int rowCount(){
        return  sheet.getLastRowNum();
    }

    //Excel deki sutun sayisini return eder
    public int columnCount(){
        return  sheet.getRow(0).getLastCellNum();
    }

    //Exceldeki datalari baslik olmadan alabilmek icin 2 boyutlu bir array method yapalim
    public String [][] getDataArray(){
        String[][] data= new String[rowCount()][columnCount()];
        for (int i = 1; i <=rowCount() ; i++) {
            for (int j = 0; j <columnCount() ; j++) {
                String value = getCellData(i,j);
                data[i-1][j] = value;
            }
        }
        return data;
    }

    //==============Sutun isimlerini verir==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
    //=========Deger, Satir, Sutun girindiginde, O satır ve sutuna girilen veriyi ekler===============//
    public void setCellData(String value, int rowNum, int colNum) {
        try {
            sheet.getRow(rowNum).createCell(colNum).setCellValue(value);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    Bu metot ustdeki metotla birlikde calisir. Overload eder. Parametreleri farklidir
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }
}
