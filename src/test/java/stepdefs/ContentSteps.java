package stepdefs;

import com.source.core.TestContext;
import com.source.pages.*;
import com.source.utils.Utility;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class ContentSteps {
    TestContext context;
    WebDriver driver;
    LoginScreen loginScreen;

    Properties prop;

    public ContentSteps(TestContext context) {
        this.context = context;
        loginScreen = context.getPageObjectManager().getLoginScreen();
        prop = context.getDriverManager().getProperties();

    }




}
