package testcases;

import annotations.Framework;
import base.DriverFactory;
import base.TestBase;
import com.aventstack.extentreports.Status;
import enums.AuthorType;
import enums.CategoryType;
import homepage.MainPage;
import io.qameta.allure.*;
import org.jboss.arquillian.container.spi.context.annotation.DeploymentScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportgeneration.ExtentFactory;
import utility.TestNGListeners;


@Listeners(TestNGListeners.class)

public class UpLoadPageTest extends TestBase {

    @Framework(author = {AuthorType.NIREEKSHAN}, category = {CategoryType.REGRESSION})
    @Test
    @Description("Upload Page Test -> Validating the Uploading a file on the Upload Page")
    @Link("https://www.automationtesting.co.uk/")
    @Issue("123")
    @Severity(SeverityLevel.NORMAL)
    public void validateUpLoadPage(){
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"Upload Page Test Started ");
        MainPage mainPage=new MainPage();
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"Main Page instance has been instantiated Successfully");
        mainPage.goToFileUpLoadPage().goToFileUploadFunctionPage().fileUploadAction("C:/Users/nkuma/Pictures/IMG_0768.JPG");
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"Upload Page Test ended");
        Assert.assertTrue(true);


    }

}
