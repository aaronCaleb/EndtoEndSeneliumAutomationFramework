package testcases;

import base.TestBase;
import dataprovider.DataProviderForReadingYamlFile;
import homepage.MainPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestNGListeners;

import java.util.HashMap;

@Listeners(TestNGListeners.class)

public class ContactFormPageTest extends TestBase {

    @Test(description="Validating Contact Us Form", dataProviderClass = DataProviderForReadingYamlFile.class,
                dataProvider = "dataProvider2")
    public void validateContactUsForm(HashMap<String, String> contactFillInDetails) throws InterruptedException {
        MainPage mainPage=new MainPage();
        mainPage.clickContactUsFormPage().contactUsFormClick().contactUsFormActions(contactFillInDetails);
        Assert.assertTrue(true);
    }
}
