package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HelloClass {

       // Driver.getDriver.get("");
       // inside we have driver.manage().window().maximize();
       // and driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

       public static void main(String[] args) {


              WebDriverManager.chromedriver().setup();
              WebDriver driver = new ChromeDriver();

              driver.get("https://www.amazon.com");
              driver.manage().window().maximize();
              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

              WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
              searchBox.sendKeys("masks"+ Keys.ENTER);

              String expectedTitle = "Amazon.com : masks";
              String actualTitle = driver.getTitle();

              if (expectedTitle.equals(actualTitle)){
                     System.out.println("Passed");
              }else {
                     System.out.println("Failed");
              }

              WebElement firstMask = driver.findElement(By.linkText("Comix Disposable Face-Masks with 3-Layer Adult Masks, L707 Pack of 100"));
              firstMask.click();
              driver.close();
       }
}