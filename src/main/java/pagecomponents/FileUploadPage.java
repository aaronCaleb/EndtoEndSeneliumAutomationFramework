package pagecomponents;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.FileUploadFunction;

public class FileUploadPage extends AbstractComponent {
    public FileUploadPage(WebDriver driver, By element) {
        super(driver, element);
    }

    By sideBar= By.cssSelector("div#sidebar");

    public FileUploadFunction goToFileUploadFunctionPage(){
        return new FileUploadFunction(DriverFactory.getInstance().getDriverThreadLocal(),sideBar);
    }
}
