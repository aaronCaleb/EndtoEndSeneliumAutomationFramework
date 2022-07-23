package pagecomponents;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.TestStoreFunctionPage;

public class TestStorePage extends AbstractComponent {
    public TestStorePage(WebDriver driver, By element) {
        super(driver, element);
    }

    By sideBar= By.cssSelector("div#sidebar");

    public TestStoreFunctionPage testStoreClick(){
        return new TestStoreFunctionPage(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }
}
