package pagecomponents;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.ActionsPageFunction;

public class ActionsPage extends AbstractComponent {
    public ActionsPage(WebDriver driver, By element) {
        super(driver, element);
    }

    By sideBar= By.cssSelector("div#sidebar");

    public ActionsPageFunction actionClickMethod(){
        return new ActionsPageFunction(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }
}
