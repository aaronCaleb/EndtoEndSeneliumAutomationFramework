package pagecomponents;

import abstractcomponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Toggle extends AbstractComponent {

    public Toggle(WebDriver driver, By element) {
        super(driver, element);
    }

    By toggleBtn=By.cssSelector(".toggle");

    public void toggleClickMethod(){
        findElement(toggleBtn).click();
    }
}
