package homepage;

import base.DriverFactory;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pagecomponents.*;

import java.sql.Driver;


public class MainPage extends TestBase {

    By sideBar= By.cssSelector("div#sidebar");



    public Toggle clickToggleBtn(){
        return new Toggle(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }

    public HomePage clickHomePage(){
        return new HomePage(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }

    public AccordionPage clickAccordionPage(){
        return new AccordionPage(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }

    public ActionsPage clickActionsPage(){
        return new ActionsPage(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }

    public TestStorePage clickTestStorePage(){
        return new TestStorePage(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }

    public ContactUsForm clickContactUsFormPage(){
        return new ContactUsForm(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }

    public FileUploadPage goToFileUpLoadPage(){
        return new FileUploadPage(DriverFactory.getInstance().getDriverThreadLocal(), sideBar);
    }


}
