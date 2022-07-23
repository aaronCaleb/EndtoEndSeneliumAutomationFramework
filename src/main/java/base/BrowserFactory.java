package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;

public class BrowserFactory {

    //Create WebDriver Object for a given Browser;
    public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

       WebDriver driver =null;

        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            System.setProperty("WebDriver.chrome.silenceOutput", "true");

            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("disable-infobars");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.setCapability("browserVersion", "103");
            chromeOptions.setCapability("platformName", "Windows 11");
            driver=new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("--private");
            firefoxOptions.setCapability("browser", "Firefox");
            firefoxOptions.setCapability("OS", "Windows 11");
            firefoxOptions.setCapability("build", "selenium Java Firefox Profile");
            driver=new FirefoxDriver(firefoxOptions);

        }else {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions=new EdgeOptions();
            edgeOptions.addArguments("--");
            driver=new EdgeDriver(edgeOptions);
        }

        return driver;
    }
}
