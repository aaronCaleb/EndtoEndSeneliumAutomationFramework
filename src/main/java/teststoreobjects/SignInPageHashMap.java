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

public class SignInPageHashMap extends AbstractComponent {

    public SignInPageHashMap(WebDriver driver, By element) {
        super(driver, element);
    }

    //Elements for actioning SignIn Page----------------------------------------------------------------//

    By signInLink=By.cssSelector("[title] .hidden-sm-down");
    By enterEmail=By.cssSelector("section input[name='email']");
    By enterPassword=By.cssSelector("[name='password']");
    By signInBtn=By.cssSelector("[data-link-action='sign-in']");

    //--------------------------------------------------------------------------------------------------//

    //Main SignIn Method that is used to sign In to the TestStore

    public void signInFunctionHashMap(HashMap<String, String> signInDetails) throws InterruptedException {
        clickSignIn(e->enterEmail(signInDetails.get("username")));
        enterPassword(signInDetails.get("password"));
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
        Thread.sleep(2000);
    }

    //Execute Around Method that clicks signIn link, since is used again and again
    public void clickSignIn(Consumer<SignInPageHashMap> consumer){
        findElement(signInLink).click();
        consumer.accept(this);
    }

    //Enter email ID as username Method
    public void enterEmail(String email){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(enterEmail)).sendKeys(email);

    }

    //Enter Password as password Method
    public void enterPassword(String password){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(enterPassword)).sendKeys(password);
    }

}
