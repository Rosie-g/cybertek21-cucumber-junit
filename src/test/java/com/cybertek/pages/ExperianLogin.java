package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class ExperianLogin {

    public ExperianLogin() {

        PageFactory.initElements(Driver.getDriver(),this);

    }
}
