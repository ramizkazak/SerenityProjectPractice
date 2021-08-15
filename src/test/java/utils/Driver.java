package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;

public class Driver {

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            synchronized (Driver.class) {

                String browser = ConfigurationReader.getProperty("browser");

                String runningMode = ConfigurationReader.getProperty("chrome.switches");

                if(runningMode.equalsIgnoreCase("--headless")){

                    switch (browser) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            ChromeOptions options = new ChromeOptions();
                            options.setHeadless(true);
                           // options.addArguments("--headless");
                            //options.addArguments("--disable-gpu");
                           // options.addArguments("--window-size=1400,800");
                            driverPool.set(new ChromeDriver(options));


                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            FirefoxOptions firefoxOptions = new FirefoxOptions();
                            firefoxOptions.addArguments("--headless");
                            firefoxOptions.addArguments("--disable-gpu");
                            firefoxOptions.addArguments("--window-size=1400,800");
                            driverPool.set(new FirefoxDriver(firefoxOptions));

                            break;
                    }

                }else {

                    switch (browser) {
                        case "chrome":
                            WebDriverManager.chromedriver().setup();
                            driverPool.set(new ChromeDriver());
                            driverPool.get().manage().window().maximize();
                            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            break;
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            driverPool.set(new FirefoxDriver());
                            driverPool.get().manage().window().maximize();
                            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            break;
                        case "safari":

                            WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
                            driverPool.set(new SafariDriver());
                            driverPool.get().manage().window().maximize();
                            driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    }
                }
            }
        }

        return driverPool.get();

    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
