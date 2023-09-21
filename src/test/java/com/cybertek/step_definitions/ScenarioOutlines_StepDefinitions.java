package com.cybertek.step_definitions;

import com.cybertek.pages.SBear_OrderPage;
import com.cybertek.pages.SBear_ViewAllOrdersPage;
import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;


public class ScenarioOutlines_StepDefinitions {

    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    SBear_OrderPage sBear_orderPage = new SBear_OrderPage();
    SBear_ViewAllOrdersPage sBear_viewAllOrdersPage = new SBear_ViewAllOrdersPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {

        String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);

        smartBearLoginPage.loginToSmartBear();
        sBear_orderPage.order.click();

    }


    @When("User fills out form as followed from the table below:")
    public void user_fills_out_form_as_followed_from_the_table_below() {

    }

    @When("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {

        Select productDropdown = new Select(sBear_orderPage.productDropdown);

        productDropdown.selectByVisibleText(string);

    }

    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String string) {

        sBear_orderPage.quantity.sendKeys(Keys.BACK_SPACE + string);

    }

    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String string) {

        sBear_orderPage.customerName.sendKeys(string);

    }

    @When("User enters {string} to street")
    public void user_enters_to_street(String string) {

        sBear_orderPage.street.sendKeys(string);
    }

    @When("User enters {string} to city")
    public void user_enters_to_city(String string) {

        sBear_orderPage.inputCity.sendKeys(string);

    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String string) {

        sBear_orderPage.inputState.sendKeys(string);

    }

    @When("User enters {string} to zip")
    public void user_enters_to_zip(String string) {

        sBear_orderPage.inputZip.sendKeys(string);

    }

    @When("User selects {string} as card type")
    public void user_selects_as_card_type(String string) {

        sBear_orderPage.visaCredit.click();
    }

    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String string) {

        sBear_orderPage.inputCardNumber.sendKeys(string);

    }

    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String string) {

        sBear_orderPage.inputExpireDate.sendKeys(string);

    }

    @When("User clicks process button")
    public void user_clicks_process_button() {

        sBear_orderPage.processButton.click();

    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String expected) {


        sBear_orderPage.viewAllOrders.click();

        String actualText = sBear_viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertTrue(actualText.equals(expected));





    }

}
