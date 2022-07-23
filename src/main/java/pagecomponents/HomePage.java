package pagecomponents;

import abstractcomponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractComponent {

    public HomePage(WebDriver driver, By element) {
        super(driver, element);
    }

    By homePageLink= By.cssSelector("li:nth-of-type(1) > a");

    public void homePageClickMethod(){
        findElement(homePageLink).click();
    }
}
