package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.function.Consumer;

public class ContactUsFormFunction extends AbstractComponent {
    public ContactUsFormFunction(WebDriver driver, By element) {
        super(DriverFactory.getInstance().getDriverThreadLocal(), element);
    }

    By contactFormLink=By.cssSelector("a[href='contactForm.html']");
    By enterFName=By.cssSelector("form#contact_form > input[name='first_name']");
    By enterLName=By.cssSelector("form#contact_form > input[name='last_name']");
    By enterEmail=By.cssSelector("form#contact_form > input[name='email']");
    By comments=By.cssSelector("form#contact_form > textarea[name='message']");
    By submitBtn=By.cssSelector("[type='submit']");

    public void contactUsFormActions(HashMap<String, String> contactFillInDetails) throws InterruptedException {
        clickContactFormLink(c->enterFName(contactFillInDetails.get("First Name")));
        enterLName(contactFillInDetails.get("Last Name"));
        enterEmail(contactFillInDetails.get("Email"));
        clickSubmit();
        Thread.sleep(2000);
    }

    public void clickContactFormLink(Consumer<ContactUsFormFunction> consumer){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(contactFormLink)).click();
        consumer.accept(this);

    }

    public void enterFName(String FName) {
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(enterFName)).sendKeys(FName);
    }

    public void enterLName(String LName){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(enterLName)).sendKeys(LName);
    }

    public void enterEmail(String email){
         new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(enterEmail)).sendKeys(email);
    }

    public void clickSubmit(){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }
}
