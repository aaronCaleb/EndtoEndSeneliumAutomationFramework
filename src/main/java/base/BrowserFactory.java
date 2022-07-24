package base;

import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import reportgeneration.ExtentFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
    public WebDriver driver;
    //Create WebDriver Object for a given Browser;
    public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
        driver=DriverFactory.getInstance().getDriverThreadLocal();

        if(browser.equalsIgnoreCase("Chrome")){

            //System.setProperty("WebDriver.chrome.silenceOutput", "true");
            try {
                WebDriverManager.chromedriver().setup();
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
                desiredCapabilities.setVersion("103");
                //desiredCapabilities.setPlatform(Platform.valueOf("Windows 11"));
                DriverFactory.getInstance()
                        .setDriverThreadLocal
                                (new RemoteWebDriver(new URL("http://192.168.1.111:4444/"), desiredCapabilities));
            }catch(MalformedURLException e){
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Browser start-up failure due to : " +e);
            }

        } else if (browser.equalsIgnoreCase("Firefox")) {
            try {
                WebDriverManager.firefoxdriver().setup();
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(Browser.FIREFOX.browserName());
                desiredCapabilities.setVersion("102");
                DriverFactory.getInstance().setDriverThreadLocal
                        (new RemoteWebDriver(new URL("http://192.168.1.111:4444"), desiredCapabilities));
            }catch (MalformedURLException e){
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Browser start-up failure due to : " +e);
            }

        }else if(browser.equalsIgnoreCase("edge")) {
            try {
                WebDriverManager.edgedriver().setup();
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(Browser.EDGE.browserName());
                DriverFactory.getInstance().setDriverThreadLocal
                        (new RemoteWebDriver(new URL("http://192.168.1.111:4444"), desiredCapabilities));
            }catch (MalformedURLException e){
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Browser start-up failure due to : " +e);
            }
        }

        return driver;
    }
}
