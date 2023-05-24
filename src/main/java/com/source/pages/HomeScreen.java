package com.source.pages;

import com.source.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AbstractScreen {


    @FindBy(xpath = "//*[text()='Products']")
    private WebElement productTitleLabel;

    @FindBy(className = "product_sort_container")
    private WebElement productFilterDropDown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPriceList;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    public boolean productLabelIsDisplayed() {
        if (Utility.waitForWebElement(driver, productTitleLabel, 5)) {
            return true;
        }
        return false;
    }

    public boolean selectFilter(String text) {
        if (Utility.waitForWebElement(driver, productFilterDropDown, 5)) {
            Utility.selectDropDownByVisibleText(productFilterDropDown, text);
            return true;
        }
        return false;
    }

    private List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPriceList) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        return prices;
    }

    private boolean isSortedAscending(List<Double> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedDescending(List<Double> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) < values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean areProductsSortedByPriceAscending() {
        List<Double> prices = getProductPrices();
        return isSortedAscending(prices);
    }

    public boolean areProductsSortedByPriceDescending() {
        List<Double> prices = getProductPrices();
        return isSortedDescending(prices);
    }
}
