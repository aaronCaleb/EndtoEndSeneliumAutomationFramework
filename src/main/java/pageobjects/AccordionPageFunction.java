package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccordionPageFunction extends AbstractComponent {
    public AccordionPageFunction(WebDriver driverThreadLocal, By sideBar) {
        super(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);

    }

    By accordionLink=By.cssSelector("[href='accordion\\.html']");
    By accordion1=By.cssSelector(".accordion > div:nth-of-type(1)");
    By accordion2=By.cssSelector(".accordion > div:nth-of-type(3)");
    By accordion3=By.cssSelector(".accordion > div:nth-of-type(5)");

    public boolean setAccordions(){
        new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(accordionLink)).click();
        for(int i=0;i<10;++i){
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(accordion1)).click();

            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(accordion2)).click();

            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(accordion3)).click();

        }
        return false;
    }
}
