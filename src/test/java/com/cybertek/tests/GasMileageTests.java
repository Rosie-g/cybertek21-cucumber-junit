package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    @Test
    public void gas_mileage_calculation() throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        String path = "src/test/resources/testData/GasMileageTestData.xlsx";
        fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {

            XSSFRow currentRow = sheet.getRow(rowNum);

            if (!currentRow.getCell(0).toString().equals("Y")) {

                if (currentRow.getCell(6) == null){
                    currentRow.createCell(6);
                }

                currentRow.getCell(6).setCellValue("Skip Requested");
                continue;
            }


            double current = currentRow.getCell(1).getNumericCellValue();


            gasMileageCalculatorPage.inputCurrentOdo.clear();
            // gasMileageCalculatorPage.inputCurrentOdo.sendKeys(current + ""); --> converting to String
            gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current));


            // double previous = 122000;
            double previous = currentRow.getCell(2).getNumericCellValue();

            gasMileageCalculatorPage.inputPreviousCurrentOdo.clear();
            gasMileageCalculatorPage.inputPreviousCurrentOdo.sendKeys(String.valueOf(previous));

            //double gas = 70;
            double gas = currentRow.getCell(3).getNumericCellValue();

            gasMileageCalculatorPage.inputGas.clear();
            gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));

            gasMileageCalculatorPage.calculateButton.click();

            // how does the calculation of AVG/MPG work
            //(current-previous)/gallons --> avg MPG

            double expectedResult = (current - previous) / gas;

            System.out.println(expectedResult);

            // actual result --> 14.29 mpg -->
            String[] actualResultArr = gasMileageCalculatorPage.resultInGas.getText().split(" ");
            System.out.println("actualResultArr = " + actualResultArr[0]);

            String actual = actualResultArr[0];
            String expected = String.valueOf(expectedResult);

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formattedExpected = decimalFormat.format(expectedResult);

            System.out.println("formattedExpected = " + formattedExpected);

            // If the cell is empty we need to create the cell before being able to pass
            // any data into t
            if (currentRow.getCell(4) == null) {

                currentRow.createCell(4);
            }

            // Passing the formattedExpected into our excel sheet "Expected" cell
            currentRow.getCell(4).setCellValue(formattedExpected);


            // Passing actual value into excel sheet
            if (currentRow.getCell(5) == null) {

                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actual);

            if (currentRow.getCell(6) == null) {

                currentRow.createCell(6);
            }

            if (currentRow.getCell(7) == null) {

                currentRow.createCell(7);
            }

            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());


            if (actual.equals(formattedExpected)) {
                //System.out.println("PASS!");
                currentRow.getCell(6).setCellValue("PASS!");
            } else {
                // System.out.println("FAIL!");
                currentRow.getCell(6).setCellValue("FAIL!");

            }

            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalTime.now().format(DTF));

        }
        //=================================================================================================
        // We need to write into excel file using .write method, otherwise changes will not be

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();


    }

}
