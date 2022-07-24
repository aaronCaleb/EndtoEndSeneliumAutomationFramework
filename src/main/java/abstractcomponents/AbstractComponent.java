package abstractcomponents;

import base.DriverFactory;
import com.aventstack.extentreports.Status;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportgeneration.ExtentFactory;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

abstract public class AbstractComponent {

    WebElement element;
    FluentWait<WebDriver> wait = null;

    public AbstractComponent(WebDriver driver, By element) {
        driver = DriverFactory.getInstance().getDriverThreadLocal();
        this.element = driver.findElement(element);
    }


    public WebElement findElement(By findElement) {
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"This findElement is for a specific section on the Main Page");
        return element.findElement(findElement);
    }

    public List<WebElement> findElements(By findElements) {
        return element.findElements(findElements);
    }

    public void sendKeys(By element, String fieldName, String valueToBeSent){
        try{
            findElement(element).sendKeys(valueToBeSent);
            //Log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Entered Value as: "+valueToBeSent);
        }catch(Exception e){
            //Log Failure message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+" ==> is Failed due to exception: "+e);
        }
    }

    public void click(By element, String fieldName) {
        try {
            findElement(element).click();
            //log success message in extent report
            ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Clicked Successfully! ");
        } catch (Exception e) {
            //log failure in extent
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click on field: " +fieldName +" due to exception: "+e);
        }
    }


    public void explicitWait(WebDriver driver, By element, long timeOut){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(timeOut))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));

        findElement(element).click();
    }

    public void fluentWait(WebDriver driver,By element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            findElement(element).click();
        }catch(Exception e) {
        }
    }

    public boolean dragAndDrop(WebDriver driver,By source, By target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop((WebElement) source, (WebElement) target).perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("DragAndDrop Action is performed");
            } else {
                System.out.println("DragAndDrop Action is not performed");
            }
        }
    }




}
