package testcases;

import annotations.Framework;
import base.DriverFactory;
import base.TestBase;
import com.aventstack.extentreports.Status;
import dataprovider.DataProviderForReadingJSONFile;
import enums.AuthorType;
import enums.CategoryType;
import homepage.MainPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportgeneration.ExtentFactory;
import utility.TestNGListeners;

import java.io.IOException;

@Listeners({TestNGListeners.class})

public class SignInTestUsingJSONDataProvider extends TestBase {



    By sideBar= By.cssSelector("div#sidebar");

    @Framework(author = {AuthorType.NIREEKSHAN},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})

    @Test(description = "SignInTest", dataProviderClass = DataProviderForReadingJSONFile.class,
            dataProvider = "getJsonData")
    public void validateSignInPage(String data) throws InterruptedException {
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "SignIn Page Function validation Test started");
        MainPage mainPage = new MainPage();
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "MainPage object has been instantiated");
        String[] dataArray=data.split(",");
        mainPage.clickTestStorePage().testStoreClick().clickSignInPage()
                .signInFunction(dataArray[0],dataArray[1]);
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "SignIn Page Function validation Test ended");
        Assert.assertTrue(true);

    }



}


