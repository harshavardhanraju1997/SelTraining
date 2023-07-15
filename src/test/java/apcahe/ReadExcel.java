package apcahe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
    public static void main(String[] args) throws IOException {

        String k=System.getProperty("user.dir");
        System.out.println(k);
        k= k+ File.separator+"SampleData.xlsx";
        System.out.println(k);
        FileInputStream fis=new FileInputStream(k);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("SalesOrders");
        int rows=sheet.getLastRowNum();
        System.out.println(rows);
        int cols=sheet.getRow(1).getLastCellNum();
        System.out.println(cols);


        for (int i=0; i<=rows; i++){

            XSSFRow row=sheet.getRow(i);
            System.out.print(i +"row:");
            for (int j=0; j<cols; j++){
                String cellValue="";
                double cellDoubleValue=0;
                XSSFCell cell=row.getCell(j);
//                System.out.println(cell +" "+cell.getCellType());
               String c= String.valueOf(cell.getCellType());

                if(c.equals("NUMERIC")){

                    cellDoubleValue=Double.parseDouble(String.valueOf(row.getCell(j).getNumericCellValue()));
                }

                if(c.equals("STRING")){
                    cellValue=row.getCell(j).getStringCellValue();
                }

                System.out.print(cell.toString()+"|");
            }
            System.out.println();

        }




    }
}
