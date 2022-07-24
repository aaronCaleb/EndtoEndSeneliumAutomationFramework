package testcases;

import annotations.Framework;
import base.DriverFactory;
import base.TestBase;
import com.aventstack.extentreports.Status;
import enums.AuthorType;
import enums.CategoryType;
import homepage.MainPage;
import io.qameta.allure.Description;
import org.apache.log4j.DailyRollingFileAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import reportgeneration.ExtentFactory;
import utility.TestNGListeners;

@Listeners(TestNGListeners.class)

public class AccordionPageFunctionTest extends TestBase {

    By sideBar= By.cssSelector("div#sidebar");

    @Framework(author={AuthorType.NIREEKSHAN},
                category = {CategoryType.REGRESSION,CategoryType.SANITY,CategoryType.SMOKE})

    @Test(groups={"SANITY","SMOKE","REGRESSION"})
    @Description("This is to test Accordions in the Accordions Page")
    public void validateAccordions(){
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"Accordion Page Function validation Test started");
        MainPage mainPage=new MainPage();
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"MainPage object has been instantiated");
        mainPage.clickAccordionPage().accordionPageClickMethod().setAccordions();
        ExtentFactory.getInstance().getExtent().log(Status.INFO,"Accordion Page Function validation Test ended");
        Assert.assertTrue(true);

    }
}
