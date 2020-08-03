package com.atutotrader.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage{


@FindBy (xpath = "//option[text()='Any Make']")
private WebElement anyMake;

    @FindBy (xpath = "//option[text()='Any Model']")
    private WebElement anyModel;

    @FindBy (xpath = "//input[@name='zipcode']")
    private WebElement zipCode;

    @FindBy (xpath = "//button[text()='Browse by Make']")
    private WebElement byMake;

    @FindBy (xpath = "//button[text()='Browse by Style']")
    private WebElement byStyle;

    @FindBy (xpath = "//a[text()='Advanced Search']")
    private WebElement advanceSearch;

    @FindBy (id = "search")
    private WebElement search;


    public void verifyLinks(String expected) {
        String actual;

        if (expected.equals(byMake.getText())) {
            actual = byMake.getText();
            System.out.println("ByMake "+ actual);

          } else if (expected.equals(byStyle.getText())) {
          actual = byStyle.getText();
          System.out.println("ByStyle "+ actual);

           } else {
           actual =advanceSearch.getText();
           System.out.println("AdvanceSearch "+ actual);
           }

        Assert.assertEquals(actual, expected);
    }

public void verifyDropDown(String expected){
        String actual="";

        if (expected.equals(anyModel.getText())){
            actual= anyModel.getText();
            Assert.assertTrue(anyModel.isDisplayed());

        }else if (expected.equals(anyMake.getText())){
            actual=anyMake.getText();
            Assert.assertTrue(anyMake.isDisplayed());
        }
        Assert.assertEquals(actual,expected);

}
public void verifyZipCodeDisPlayed(){
    Assert.assertTrue(zipCode.isDisplayed()    );
}

    public void verifySearchButtonDisPlayed(){
        Assert.assertTrue(search.isDisplayed()    );
    }

    public void clickOnAdvanceSearch(){
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies());
        wait.until(ExpectedConditions.elementToBeClickable(advanceSearch));
      advanceSearch.click();
    }





}
