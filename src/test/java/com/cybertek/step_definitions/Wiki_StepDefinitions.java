package com.cybertek.step_definitions;

import com.cybertek.pages.WikiPage;
import com.cybertek.pages.WikiSearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class Wiki_StepDefinitions {

    WikiPage wikiPage = new WikiPage();
    WikiSearchPage wikiSearchPage = new WikiSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {

        String url = ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(url);

        String actual = Driver.getDriver().getTitle();
        String expected = "Wikipedia";

        Assert.assertTrue(actual.equals(expected));

    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikiPage.searchBox.sendKeys(string);

    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

        wikiPage.searchButton.click();

    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String title) {

        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue(actual.contains(title));

    }


    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String name) {

        String actual = wikiSearchPage.mainHeader.getText();
        String expected = name;

        Assert.assertEquals(actual,expected);

    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String name) {

        String actual = wikiSearchPage.image.getText();

        Assert.assertTrue(actual.contains(name));



    }
}
