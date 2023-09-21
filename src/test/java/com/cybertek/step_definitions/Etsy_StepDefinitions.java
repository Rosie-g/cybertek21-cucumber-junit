package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Etsy_StepDefinitions {

    EtsyPage etsyPage = new EtsyPage();


    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {

        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);

    }



    @Then("user should see as expected")
    public void user_should_see_as_expected() {

        String actual = Driver.getDriver().getTitle();
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertEquals(actual,expected);

    }


    @When("user searches {string}")
    public void userSearches(String search) {

        etsyPage.searchBox.sendKeys(search+ Keys.ENTER);


    }

    @Then("user should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String expected) {

       // String some = expected.substring(0,1).toUpperCase();
        String actual = Driver.getDriver().getTitle();
        Assert.assertTrue(actual.contains(expected));

    }
}
