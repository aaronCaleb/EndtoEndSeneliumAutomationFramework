package pageobjects;

import abstractcomponents.AbstractComponent;
import base.DriverFactory;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportgeneration.ExtentFactory;

import java.time.Duration;
import java.util.function.Consumer;

public class FileUploadFunction extends AbstractComponent {
    public FileUploadFunction(WebDriver driver, By element) {
        super(driver, element);
    }

    //Locators on FileUpLoad Page
    By fileUploadLink=By.cssSelector("[href='fileupload\\.html']");
    By uploadClick=By.cssSelector("input#fileToUpload");
    By submitBtn=By.cssSelector("[type='submit']");

    //Main Method for fileUpLoad Action
    public void fileUploadAction(String filePath){
        clickFileUploadLink(u->upLoadFile(filePath));
    }

    //Execute Around Method for enabling webDriver to click the main link (located on the side Bar)
    // to get into File Upload Page

    public void clickFileUploadLink(Consumer<FileUploadFunction> consumer) {
        try {
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(fileUploadLink)).click();
            consumer.accept(this);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, " ==> File main link to Upload Page clicked Successfully");
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "==> Failed due to exception: " + e);
        }
    }

    //Method for executing uploading the file and clicking submit button
    public void upLoadFile(String filePath){
        try{
            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(uploadClick)).sendKeys(filePath);

            new WebDriverWait(DriverFactory.getInstance().getDriverThreadLocal(), Duration.ofSeconds(20))
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, " ==> File UploadCLick clicked Successfully");

        }catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "==> Failed due to exception: " + e);
        }

    }

}
