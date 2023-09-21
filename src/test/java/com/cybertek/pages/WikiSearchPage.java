package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    public WikiSearchPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    @FindBy(xpath = "//img[@alt='Steve Jobs Headshot 2010-CROP (cropped 2).jpg']")
    public WebElement image;


}
