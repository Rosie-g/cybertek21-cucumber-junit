package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    // In this test we will be reading excel file

    @Test
    public void excel_read_test() throws IOException {

        String path = "SampleData.xlsx";

        // To be able to read from excel file we need to load the file
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell

        // We created workbook instance and loaded with "SampleData" file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // Create the sheet and pass the name of the sheet we want to work on
        XSSFSheet sheet = workbook.getSheet("Employees");

        // ROW --> SHEET

        System.out.println(sheet.getRow(1).getCell(2));
        System.out.println(sheet.getRow(3).getCell(2));


        // Returns the count of used cells only
        // If there are cells not used the will not be counting
        // Starts from counting 1
        int usedRows = sheet.getPhysicalNumberOfRows();


        // Returns the count from top to bottom
        // Even counts if there are empty cells
        // this starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();


        // TODO: 1- CREATE A LOGIC TO PRINT OUT NEENA'S NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            XSSFCell currentCell = sheet.getRow(rowNum).getCell(0);

            if (currentCell.toString().equals("Neena")) {
                System.out.println("Current cell = " + currentCell);

            }
        }

        // TODO: 2- CREATE A LOGIC TO PRINT OUT ADAM SANDLER'S LAST NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            XSSFCell currentCell = sheet.getRow(rowNum).getCell(1);

            if (currentCell.toString().equals("Sandler")) {
                System.out.println("Sandler's last name: " + currentCell);
            }

        }

        // TODO: 2- CREATE A LOGIC TO PRINT OUT STEVEN'S KING JOB ID DYNAMICALLY
        // check for last name, if it is king, print out job_id

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            XSSFCell currentCell = sheet.getRow(rowNum).getCell(1);

            if (currentCell.toString().equals("King")){

                System.out.println("King's job id: "+sheet.getRow(rowNum).getCell(2));
            }

        }




    }
}
