package com.cybertek.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    //create method name: wait
    //converting milliseconds to seconds
    //handle checked exception

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("Something happened in sleep method");
        }
    }


    public static void printNamesAndCities(WebDriver driver) {

        //Practice #5: Method: printNamesAndCities
        //• Create a method named printNamesAndCities in SmartBearUtils class.
        //• Method takes WebDriver object.
        //• This method should simply print all the names in the List of All Orders.
        //• Create a new TestNG test to test if the method is working as expected.
        //• Output should be like:
        //• Name1: name , City1: city
        //• Name2: name , City2: city


        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        List<WebElement> allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[7]"));


        for (int i = 0; i < allNames.size(); i++) {
            System.out.println("Name " + (i + 1) + " : " + allNames.get(i).getText() + " ," + " City " + (i + 1) + " : " + allCities.get(i).getText());
        }


    }

    // Method to assert title
    public static void titleVerification(String expectedTitle) {

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    // This method accepts List<WebElement> and returns List<String>
    public static List<String> getElementsText(List<WebElement> webElementList) {

        // Placeholder empty list of web element
        List<String> webElementAsString = new ArrayList<>();

        // Looping through of web elements and storing text into placeholder list
        for (WebElement each : webElementList) {
            webElementAsString.add(each.getText());

        }

        // returning final List<String>
        return webElementAsString;

    }


}
