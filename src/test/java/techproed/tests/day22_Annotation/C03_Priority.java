package techproed.tests.day22_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C03_Priority {
    /*
        TestNG test method'larını isim sırasına (alfabetik) göre çaliştirir. Eğer isim sıralamasının
    dışında bir sıralama ile çalışmasını isterseniz o zaman test methodlarına öncelik(priority)
    tanımlayabiliriz.
        Priority küçükten büyüğe göre çalışır. Eğer bir test methoduna priority atanmamışsa
    default olarak priority=0 kabul edilir.

        ------------
    Test NG'de  test methodları alfabetik sıraya göre çalışır.
    @Test(priority = 1) Test casleride öncelikli çalıştırma için kullanuılır.
    Not: priority kullanılmayan testlerin varsayilan priority değeri 0'dır
    ------------
    @Ignore: @Test caseleri atlamak için kullanılır
    @Test(enable=false) @Test caseleri kullanıma kapatmak için kullanılır
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
@Ignore // gormezden gelir
    @Test
    public void test1() {
        System.out.println("Test1");
    }

    @Test(enabled = false)
    public void test2() {
        System.out.println("Test2");
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