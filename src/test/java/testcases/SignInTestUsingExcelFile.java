package testcases;

import annotations.Framework;
import base.TestBase;
import com.aventstack.extentreports.Status;
import dataprovider.DataProviderForReadingExcelFile;
import dataprovider.DataProviderForReadingJSONFile;
import enums.AuthorType;
import enums.CategoryType;
import homepage.MainPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportgeneration.ExtentFactory;
import utility.TestNGListeners;

import java.io.IOException;

@Listeners({TestNGListeners.class})

public class SignInTestUsingExcelFile extends TestBase {

    @Framework(author = {AuthorType.NIREEKSHAN},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})

    @Test(description = "SignInTest", dataProviderClass = DataProviderForReadingExcelFile.class,
            dataProvider = "getTestData")
    public void validateSignInPage(String username, String password) throws InterruptedException {
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "SignIn Page Function validation Test started");
        MainPage mainPage = new MainPage();
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "MainPage object has been instantiated");
        mainPage.clickTestStorePage().testStoreClick().clickSignInPage()
                .signInFunction(username,password);
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "SignIn Page Function validation Test ended");
        Assert.assertTrue(true);

    }



}


