package com.source.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Utility {

    public static boolean waitForWebElementClickable(WebDriver driver, WebElement elements, int timeOuts) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
            wait.until(ExpectedConditions.elementToBeClickable(elements));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForWebElement(WebDriver driver, WebElement element, int timeOuts) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            System.out.println("Failed to find element");
            return false;
        }
    }
    public static Properties readPropertiesFile(String filepath) {
        Properties prop = new Properties();
        InputStream input = null;
        File configFile = new File(filepath);
        try {
            input = new FileInputStream(configFile.getAbsolutePath());
            prop.load(input);
        } catch (Exception e) {
            System.out.println("ERROR: Unable to read config file");
        }
        return prop;
    }

}

