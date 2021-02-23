package org.issi.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 * This class is used to handles driver initialization
 */
public class DriverFactory {
    /**
     * we are creating a global driver reference
     */
    public WebDriver driver;

    /**
     * Here we are using a concept of ThreadLocal because to avoid issue while executing parallel mode
     * initializing webdriver with the help of ThreadLocal
     */
    public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    //creating a method to initialize the driver based on the value tha we pass

    /**
     * This method is used to initialize the thread local driver based on the value that we pass
     * @param browser value
     * @return dr webdriver instance
     */
    public WebDriver initDriver(String browser){
        System.out.println("browser value is : " + browser);
        if (browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
            dr.set(new ChromeDriver(options)); // with the help of thread local variable we are setting chromedriver object
        }
        else if (browser.equals("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            WebDriverManager.firefoxdriver().setup();
            dr.set(new FirefoxDriver(options)); // with the help of thread local variable we are setting chromedriver object
        }
        else if (browser.equals("ie")){
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            ieOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            WebDriverManager.iedriver().setup();
            dr.set(new InternetExplorerDriver(ieOptions)); // with the help of thread local variable we are setting chromedriver object
        }
        else {
            System.out.println("Please pass the correct browser value " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    // we are creating a method to get the driver this will returns webdriver instance

    /**
     * we are creating a method to get the driver
     * to get thread synchronizing on parallel execution we are using 'synchronized' keyword here
     * @return webdriver instance
     */
    public static synchronized WebDriver getDriver(){
        return dr.get();
    }

}
