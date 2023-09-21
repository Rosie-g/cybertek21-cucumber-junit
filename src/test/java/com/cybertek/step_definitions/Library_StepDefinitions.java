package com.cybertek.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Library_StepDefinitions {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page.");
    }


    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("Next step user enters LIBRARIAN username.");

        //Intentionally failing this step
        // Assert.fail("INTENTIONAL FAIL");
    }

    @When("user enters librarian password")
    public void user_enter_librarian_password() {
        System.out.println("Next step user enters LIBRARIAN password");
    }


    @Then("user should see dashboard")
    public void user_should_see_dashboard() {
        System.out.println("User sees dashboard");

    }

    @When("user enters student username")
    public void user_enters_student_username() {

        System.out.println("users enters STUDENT username");
    }

    @And("user enters student password")
    public void user_enters_student_password() {

        System.out.println("users enters STUDENT password");

    }

    @When("user enters admin username")
    public void user_enters_admin_username() {
        
        System.out.println("users enters ADMIN username");

    }

    @And("user enters admin password")
    public void user_enters_admin_password() {

        System.out.println("users enters ADMIN password");

    }
}
