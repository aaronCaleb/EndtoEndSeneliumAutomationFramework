package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import teststoreobjects.SignInPage;
import teststoreobjects.SignInPageHashMap;

public class TestStoreFunctionPage extends AbstractComponent {
    public TestStoreFunctionPage(WebDriver driver, By element) {
        super(driver, element);
    }

    By testStoreLink=By.linkText("TEST STORE");
    By testStoreTopHeader=By.cssSelector(".header-nav .row");


    public SignInPage clickSignInPage(){
        findElement(testStoreLink).click();
        return new SignInPage(DriverFactory.getInstance().getDriverThreadLocal(), testStoreTopHeader);
    }

    public SignInPageHashMap clickSignInPage2(){
        findElement(testStoreLink).click();
        return new SignInPageHashMap(DriverFactory.getInstance().getDriverThreadLocal(), testStoreTopHeader);
    }
}
