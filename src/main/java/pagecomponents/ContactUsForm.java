package pagecomponents;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.ContactUsFormFunction;

public class ContactUsForm extends AbstractComponent {
    public ContactUsForm(WebDriver driver, By element) {
        super(DriverFactory.getInstance().getDriverThreadLocal(), element);
    }

    By sideBar= By.cssSelector("div#sidebar");

    public ContactUsFormFunction contactUsFormClick(){
        return new ContactUsFormFunction(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }
}
