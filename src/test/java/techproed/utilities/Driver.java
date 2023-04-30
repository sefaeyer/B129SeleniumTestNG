package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
        Driver class'ındaki temel mantık extends yöntemiyle değil yani ReusableMethods class'ına extent etmek yerine
    Driver class'ından static methodlar kullanarak driver oluştururuz. Static olduğu için class ismi ile
    her yerden methoda ulaşabileceğiz.
     */
    /*
    Singleton Pattern: Tekli kullanım kalıbı.
        Bir class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade
        Bir class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için
    private access modifire kullanarak bir constructor oluştururuz
     */
    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//if driver is pointing anywhere
            driver.close();//quit when I call closeDriver
            driver = null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }
    public static void quitDriver() {
        if (driver != null) {//if driver is pointing anywhere
            driver.quit();//quit when I call closeDriver
            driver = null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }
}
