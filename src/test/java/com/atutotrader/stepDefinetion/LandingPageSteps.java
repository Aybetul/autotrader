package com.atutotrader.stepDefinetion;

import com.atutotrader.pages.LandingPage;
import com.atutotrader.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LandingPageSteps {
    private WebDriver driver= MyDriver.get();
    LandingPage landingPage = new LandingPage();

    @Given("User opens Autotrader Webside")
    public void user_opens_Autotrader_Webside() {
        System.out.println("We are in landing Page");
        String actualTitle=MyDriver.get().getTitle();
        System.out.println(actualTitle);
        String expectedTitle="Used and New Car Sales, Review - Autotrader";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("User verifies link {string} is present")
    public void user_verifies_link_is_present(String string) {
        landingPage.verifyLinks(string);

    }

    @Then("User Verifies dropdown {string} is present")
    public void user_Verifies_dropdown_is_present(String string) {
      landingPage.verifyDropDown(string);
    }

    @Then("User Verifies  ZipCode window  is present")
    public void user_Verifies_ZipCode_window_is_present() {
        landingPage.verifyZipCodeDisPlayed();
    }

    @Then("User verifies Search button is present")
    public void user_verifies_Search_button_is_present() {
     landingPage.verifySearchButtonDisPlayed();
    }





}
