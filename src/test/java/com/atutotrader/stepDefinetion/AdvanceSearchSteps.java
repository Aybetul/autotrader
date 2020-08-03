package com.atutotrader.stepDefinetion;

import com.atutotrader.pages.AdvanceSearchPage;
import com.atutotrader.pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AdvanceSearchSteps {
    LandingPage landingPage= new LandingPage();
    AdvanceSearchPage advanceSearchPage= new AdvanceSearchPage();


    @Given("User clicks on Advanced Search Link on the Home Page")
    public void user_clicks_on_Advanced_Search_Link_on_the_Home_Page() {
        landingPage.clickOnAdvanceSearch();
    }

    @Then("User enters {string} into ZipCode box")
    public void user_enters_into_ZipCode_box(String string) {
       advanceSearchPage.enterZipCode(string);
    }

    @Then("User selects {string} Check box under Condition section")
    public void user_selects_Check_box_under_Condition_section(String string) {
       advanceSearchPage.checkBoxUnderCondition(string);
    }

    @Then("User selects {string} Check box under Style section")
    public void user_selects_Check_box_under_Style_section(String string) {
        advanceSearchPage.checkBoxUnderStyle(string);
    }
    @Then("User selects {string} in Minimum dDown and {string} Maximum dDown")
    public void user_selects_in_Minimum_dDown_and_Maximum_dDown(String string, String string2) {
      advanceSearchPage.selectPrice(string,string2);
    }

    @Then("User updates {string} in From dDown and {string} in To dDown")
    public void user_updates_in_From_dDown_and_in_To_dDown(String string, String string2) {
     advanceSearchPage.selectYear(string,string2);
    }

    @Then("User selects {string} in Any Make dDown under Make, Model&Trim section")
    public void user_selects_in_Any_Make_dDown_under_Make_Model_Trim_section(String string) {
      advanceSearchPage.selectMake(string);
    }

    @Then("User selects {string} in the Mileage section")
    public void user_selects_in_the_Mileage_section(String string) {
      advanceSearchPage.selectMileage(string);
    }

    @Then("User clicks on {string} link and checks {string} Check box under Specifications section")
    public void user_clicks_on_link_and_checks_Check_box_under_Specifications_section(String string, String string2) {
      advanceSearchPage.selectColor(string,string2);
    }

    @Then("User clicks Search button")
    public void user_clicks_Search_button() {
       advanceSearchPage.clickOnSearch();
    }

    @Then("User verifies he is in the result page")
    public void user_verifies_he_is_in_the_result_page() {
      advanceSearchPage.verifyOnResultPage();
    }

    @Then("User verifies he sees only {string} make cars")
    public void user_verifies_he_sees_only_make_cars(String string) {
       advanceSearchPage.verifyMakeResult(string);
    }

    @Then("User verifies the number of listings")
    public void user_verifies_the_number_of_listings() {
      advanceSearchPage.verifyNumberOfResult();
    }





}
