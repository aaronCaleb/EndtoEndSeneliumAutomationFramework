package pagecomponents;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.AccordionPageFunction;

public class AccordionPage extends AbstractComponent {
    public AccordionPage(WebDriver driver, By element) {
        super(driver, element);
    }

    By sideBar= By.cssSelector("div#sidebar");

    public AccordionPageFunction accordionPageClickMethod(){
        return new AccordionPageFunction(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }
}
