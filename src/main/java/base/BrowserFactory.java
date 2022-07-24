package base;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    //Create WebDriver Object for a given Browser;
    public WebDriver createBrowserInstance(String browser){
        WebDriver driver=null;

        if(browser.equalsIgnoreCase("Chrome")){

            WebDriverManager.chromedriver().setup();
            System.setProperty("WebDriver.chrome.silenceOutput", "true");

            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--incognito");
           driver=new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();

        }else if(browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }

        return driver;
    }
}
