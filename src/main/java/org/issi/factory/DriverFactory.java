package org.issi.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
            WebDriverManager.chromedriver().setup();
            dr.set(new ChromeDriver()); // with the help of thread local variable we are setting chromedriver object
        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            dr.set(new FirefoxDriver()); // with the help of thread local variable we are setting chromedriver object
        }
        else if (browser.equals("ie")){
            WebDriverManager.iedriver().setup();
            dr.set(new InternetExplorerDriver()); // with the help of thread local variable we are setting chromedriver object
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
