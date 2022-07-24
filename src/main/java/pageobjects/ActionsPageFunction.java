package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.apache.log4j.DailyRollingFileAppender;
import org.bouncycastle.crypto.prng.drbg.DualECPoints;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsPageFunction extends AbstractComponent {
    public ActionsPageFunction(WebDriver driver, By element) {
        super(driver, element);
    }

    By actionsLink=By.linkText("ACTIONS");
    By fromElement=By.cssSelector("#dragtarget");
    By toElement=By.cssSelector("#main [class] [ondrop='drop\\(event\\)']:nth-child(3)");

    public void setActions(){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(actionsLink)).click();

        Actions actions= new Actions(DriverFactory.getInstance().getDriverThreadLocal());
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(fromElement));
        Action dragAndDrop= actions.clickAndHold((WebElement) fromElement)
                .moveToElement((WebElement) toElement)
                .release((WebElement) toElement)
                .build();
        dragAndDrop.perform();


    }


}
