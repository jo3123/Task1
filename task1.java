import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import java.io.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;
 class Excel {
        public static void main(String[] args) throws Exception{

                FileInputStream input_document = new FileInputStream(new File("d:\\data.xls"));

                HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);

                HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);

                Iterator<Row> rowIterator = my_worksheet.iterator();

                FileWriter my_csv=new FileWriter("convertedCSVFile.csv");
                CSVWriter my_csv_output=new CSVWriter(my_csv);

                while(rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        int i=0;//String array

                        String[] csvdata = new String[2];
                        Iterator<Cell> cellIterator = row.cellIterator();
                                while(cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next(); //Fetch CELL
                                        switch(cell.getCellType()) { //Identify CELL type

                                        case Cell.CELL_TYPE_STRING:
                                                csvdata[i]= cell.getStringCellValue();
                                                break;
                                        }
                                        i=i+1;
                                }
                my_csv_output.writeNext(csvdata);
                }
                my_csv_output.close(); //close the CSV file
                //we created our file..!!
                input_document.close(); //close xls
        }
}