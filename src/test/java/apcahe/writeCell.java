package apcahe;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeCell {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh =wb.createSheet("test2");

        Object empData[][] = {{100, "RAMU", "25"},
                {200, "SHaMU", "26"},
                {300, "Domu", "27"},

        };
        int rowLength = empData.length;
        int colLength = empData[0].length;
        System.out.println(empData);
        for (int i = 0; i <rowLength;i++) {
            XSSFRow row =sh.createRow(i);
            for (int j = 0; j < colLength;j++) {
                XSSFCell cell =row.createCell(j);
                Object value=empData[i][j];
                cell.setCellValue(value.toString());
            }
        }
        String k = System.getProperty("user.dir");
        System.out.println(k);
        k = k + File.separator + "writeData.xlsx";
        FileOutputStream fos=new FileOutputStream(k);
        wb.write(fos);
        wb.close();
        System.out.println("Excel Updated");
    }
}
