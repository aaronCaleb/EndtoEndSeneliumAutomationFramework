package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(testStoreLink)).click();
        return new SignInPage(DriverFactory.getInstance().getDriverThreadLocal(), testStoreTopHeader);
    }

    public SignInPageHashMap clickSignInPage2(){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(testStoreLink)).click();
        return new SignInPageHashMap(DriverFactory.getInstance().getDriverThreadLocal(), testStoreTopHeader);
    }
}
