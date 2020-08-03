package com.atutotrader.pages;


import com.atutotrader.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdvanceSearchPage extends BasePage {




  @FindBy(name="zip")
    private WebElement zipCode;

    @FindBy(name="minPrice")
    private WebElement minPriceDropDown;

    @FindBy(name="maxPrice")
    private WebElement maxPriceDropDown;

    @FindBy(name="startYear")
    private WebElement yearFromDropDown;

    @FindBy(name="endYear")
    private WebElement yearToDropDown;


    @FindBy(name="makeFilter0")
    private WebElement anyMakeDropDown;

    @FindBy(name="maxMileage")
    private WebElement maxMileageDropDown;

    @FindBy(xpath="//strong[text()='Exterior Color']")
    private WebElement exteriorColorDropDown;

    @FindBy(xpath="//strong[text()='Interior Color']")
    private WebElement interiorColorDropDown;

    @FindBy(xpath="//button[text()='Search']")
    private WebElement searchButton;

    @FindBy(className="results-text-container text-size-200")
    private WebElement expectedResult;

    @FindBy(xpath="//div[contains(@data-cmp,'inventoryListing')]")
    private List<WebElement > carList;





    public void enterZipCode(String string){
        zipCode.clear();
   zipCode.sendKeys(string);
  }


   public void checkBoxUnderCondition(String box){
      driver.findElement(By.xpath("//div[text()='"+box+"']")).click();

}
    public void checkBoxUnderStyle(String box){
        driver.findElement(By.xpath("//div[text()='"+box+"']")).click();

    }


    public void selectPrice(String min, String max){
//minPriceDropDown.click();
BrowserUtils.wait(5);
Select select= new Select(minPriceDropDown);
select.selectByValue(min);
Select select1= new Select(maxPriceDropDown);
select1.selectByValue(max);
    }


 public void selectYear(String from, String to){

      BrowserUtils.scrollTo(yearFromDropDown);

  Select select= new Select(yearFromDropDown);
  select.selectByValue(from);
  Select select1= new Select(yearToDropDown);
  select.selectByValue(to);
     BrowserUtils.wait(5);

 }
public void selectMake(String string ){
        BrowserUtils.scrollTo(anyMakeDropDown);
        Select select= new Select(anyMakeDropDown);
    select.selectByVisibleText(string);
    BrowserUtils.wait(5);
}
    public void selectMileage(String string ){
        BrowserUtils.scrollTo(maxMileageDropDown);
        BrowserUtils.wait(5);
        Select select= new Select(maxMileageDropDown);
        select.selectByVisibleText(string);
        BrowserUtils.wait(5);
    }

public void selectColor(String exteriorOrInterior, String color){

        if(exteriorOrInterior.equals("Exterior Color")){
            BrowserUtils.scrollTo(exteriorColorDropDown);
            BrowserUtils.wait(5);
            exteriorColorDropDown.click();
         WebElement clr=   driver.findElement(By.xpath("(//div[text()='"+color+"'])[1]"));
            System.out.println("Exterior Color    "+clr.getText());
                 clr.click();
        }else if(exteriorOrInterior.equals("Interior Color")) {
            BrowserUtils.scrollTo(interiorColorDropDown);
            interiorColorDropDown.click();
            BrowserUtils.wait(5);
            driver.findElement(By.xpath("(//div[text()='" + color + "'])[2]")).click();

        }else{
            System.out.println("invalid area or invalid color");
        }

}
public void clickOnSearch(){
BrowserUtils.scrollTo(searchButton);
driver.manage().deleteAllCookies();
    BrowserUtils.wait(5);
searchButton.click();


//wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
}

public void verifyOnResultPage(){
        BrowserUtils.wait(10);
    String expectedResultText =expectedResult.getText();
    Assert.assertTrue(expectedResultText.contains("Results"));
}



public void verifyNumberOfResult(){
        String expectedResultText =expectedResult.getText();
        String arr[]=expectedResultText.split(" ");
      String expected= "";
        if(arr.length>2){
            expected= arr[0].split("-")[1];
        }else{
           expected=arr[0];
        }
    List<String> carLst=BrowserUtils.TextFromWebElement(carList);
    String  actual=String.valueOf(carLst.size());
    Assert.assertEquals(actual,expected);
}

    public void verifyMakeResult(String make) {
        List<String> carLst=BrowserUtils.TextFromWebElement(carList);
        for (String each :carLst) {
            Assert.assertTrue(each.contains(make));

        }

    }
}
