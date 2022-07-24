package testcases;

import annotations.Framework;
import base.TestBase;
import com.aventstack.extentreports.Status;
import enums.AuthorType;
import enums.CategoryType;
import homepage.MainPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import reportgeneration.ExtentFactory;
import utility.TestNGListeners;

import java.util.HashMap;

@Listeners({TestNGListeners.class})

public class SignInTestUsingHashMapDataProvider extends TestBase {

    @Framework(author = {AuthorType.NIREEKSHAN},
            category = {CategoryType.SANITY, CategoryType.SMOKE, CategoryType.REGRESSION})

    @Test(dataProvider = "testData")
    public void validateSignInPage(HashMap<String, String> signInDetails) throws InterruptedException {
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "SignIn Page Function validation Test started");
        MainPage mainPage = new MainPage();
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "MainPage object has been instantiated");
        mainPage.clickTestStorePage().testStoreClick().clickSignInPage2()
               .signInFunctionHashMap(signInDetails);
        ExtentFactory.getInstance().getExtent().log(Status.INFO, "SignIn Page Function validation Test ended");
        Assert.assertTrue(true);
    }

    @DataProvider(name = "testData")
    public Object[][] getData(){
        HashMap<String, String> signInDetails = new HashMap<String, String>();
        signInDetails.put("username", "n.kumar9@outlook.com");
        signInDetails.put("password", "Ilovemymom23#");
        return new Object[][]{
                //You can run different data Sets here. For example {SignInDetails0}, {SignInDetails1},
                // ....{SignInDetailsN}
                {signInDetails}
        };
    }


}


