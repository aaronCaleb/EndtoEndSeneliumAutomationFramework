package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import teststoreobjects.SignInPage;
import teststoreobjects.SignInPageHashMap;

import java.time.Duration;

public class TestStoreFunctionPage extends AbstractComponent {
    public TestStoreFunctionPage(WebDriver driver, By element) {
        super(driver, element);
    }

    By testStoreLink=By.cssSelector("a[href='http://teststore.automationtesting.co.uk/']");
    By testStoreTopHeader=By.cssSelector(".header-nav .row");


    public SignInPage clickSignInPage(){
        WebElement element=findElement(testStoreLink);
        JavascriptExecutor executor=(JavascriptExecutor) DriverFactory.getInstance().getDriverThreadLocal();
        executor.executeScript("arguments[0].click();", element);
        return new SignInPage(DriverFactory.getInstance().getDriverThreadLocal(), testStoreTopHeader);
    }

    public SignInPageHashMap clickSignInPage2(){
        WebElement element=findElement(testStoreLink);
        JavascriptExecutor executor=(JavascriptExecutor) DriverFactory.getInstance().getDriverThreadLocal();
        executor.executeScript("arguments[0].click();", element);
        return new SignInPageHashMap(DriverFactory.getInstance().getDriverThreadLocal(), testStoreTopHeader);
    }
}
