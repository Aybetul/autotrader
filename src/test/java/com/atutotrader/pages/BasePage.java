package com.atutotrader.pages;

import com.atutotrader.utilities.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver=MyDriver.get();
    protected WebDriverWait wait=new WebDriverWait(driver,15);

 public  BasePage(){
     PageFactory.initElements(driver,this);
 }

}
