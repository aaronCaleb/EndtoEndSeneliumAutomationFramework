package teststoreobjects;

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

public class SignInPage extends AbstractComponent {

    public SignInPage(WebDriver driver, By element) {
        super(driver, element);
    }

    //Elements for actioning SignIn Page----------------------------------------------------------------//

    By signInLink = By.cssSelector("[title] .hidden-sm-down");
    By enterEmail = By.cssSelector("section input[name='email']");
    By enterPassword = By.cssSelector("[name='password']");
    By signInBtn = By.cssSelector("[data-link-action='sign-in']");

    //--------------------------------------------------------------------------------------------------//

    //Main SignIn Method that is used to sign In to the TestStore

    public void signInFunction(String username, String password) throws InterruptedException {
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(enterEmail)).sendKeys(username);
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(enterPassword)).sendKeys(password);
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
        Thread.sleep(2000);
    }


}


