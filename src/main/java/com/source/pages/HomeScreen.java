package com.source.pages;

import com.source.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends AbstractScreen{


    @FindBy(xpath = " //*[text()='Products']")
    WebElement productTiteLabel;

    public HomeScreen(WebDriver driver){
        super(driver);
    }

    public boolean productLabelIsDisplayed()
    {
        if(Utility.waitForWebElement(driver,productTiteLabel,5)){
            return true;
        }
        return false;
    }
}
