package ru.mirapolis;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    protected ConfigFileReader config = new ConfigFileReader();
    public static WebDriver driver;

    @Before
    public void setUp() {
        switch (config.getBrowser())
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", config.getDriverPath() + "/chromedriver.exe");
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", config.getDriverPath() + "/geckodriver.exe");
                this.driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", config.getDriverPath() + "/msedgedriver.exe");
                this.driver = new EdgeDriver();
                break;
        }
    }

    @After
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
