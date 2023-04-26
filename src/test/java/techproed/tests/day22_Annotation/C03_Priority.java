package techproed.tests.day22_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_Priority {
    /*
        TestNG test method'larını isim sırasına (alfabetik) göre çaliştirir. Eğer isim sıralamasının
    dışında bir sıralama ile çalışmasını isterseniz o zaman test methodlarına öncelik(priority)
    tanımlayabiliriz.
        Priority küçükten büyüğe göre çalışır. Eğer bir test methoduna priority atanmamışsa
    default olarak priority=0 kabul edilir.
     */
    WebDriver driver;
    @Test(priority = -3)
    public void techproedTest() {
        driver.get("https://techproeducation.com");
    }

    @Test(priority = -1)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Test(priority = -2)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}