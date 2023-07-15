package apcahe;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class WriteExcelUSingObject {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("test");
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"EMP ID", "Name", "Age"});
        list.add(new Object[]{"1", "Ram", "20"});
        list.add(new Object[]{"2", "Sham", "21"});
        int rowCount = 0;
        int colCount = 0;

        for (Object[] row : list) {

            XSSFRow rows = sheet.createRow(rowCount);
            rowCount++;
            for (Object cell : row) {
                XSSFCell cellType = rows.createCell(colCount);
                if (cell instanceof String)
                    cellType.setCellValue((String) cell);
                if (cell instanceof Integer)
                    cellType.setCellValue((Integer) cell);
                if (cell instanceof Boolean)
                    cellType.setCellValue((Boolean) cell);
                colCount++;

            }
            colCount = 0;

        }
        String k = System.getProperty("user.dir");
        System.out.println(k);
        k = k + File.separator + "writeData.xlsx";
        System.out.println(k);
        FileOutputStream fos = new FileOutputStream(k);
        book.write(fos);
        book.close();

    }
}
