package testcases;

import base.TestBase;
import homepage.MainPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pagecomponents.HomePage;
import utility.TestNGListeners;

@Listeners(TestNGListeners.class)

public class ActionsPageFunctionTest extends TestBase {

    @Test
    public void validateActionsPageFunctions(){
        MainPage mainPage=new MainPage();
        mainPage.clickActionsPage().actionClickMethod().setActions();
    }

}
