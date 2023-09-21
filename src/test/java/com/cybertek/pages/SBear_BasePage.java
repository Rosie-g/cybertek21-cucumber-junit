package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class SBear_BasePage {

    public SBear_BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

     // Common web elements that can be reached from multiple modules can se stored in BasePage
    //

    @FindBy(xpath ="//a[.='View all orders']" )
    public WebElement viewAllOrders;

    @FindBy(xpath ="//a[.='View all products']" )
    public WebElement viewAllProducts;

    @FindBy(xpath ="//a[.='Order']" )
    public WebElement order;


}
