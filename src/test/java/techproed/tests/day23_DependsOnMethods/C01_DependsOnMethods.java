package techproed.tests.day23_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class C01_DependsOnMethods {

    /*
    Test NG'de @Test metotları birbirinden bağımsız çalışır.
    Methodları bağımlı çalıştırmak istiyorsak "dependsOnMethods" parametresi kullanılır.
    Aşağıda seachTest() methodu homePageTest() methoduna bağlıdır.
    Eğer homePageTest() çalışırsa seachTest() de çalışır.
    Eğer homePageTest() fail olursa seachTest() çalışmaz, "ignore" edilir.
     */

    @Test
    public void homePageTest() {
        assertEquals(1, 2);//Burada "hard assertion" kullanıldığı için test fail olduğunda Java çalışmayı durdurur ve sonraki kodlar çalışmaz.
        System.out.println("Anasayfaya gidildi");
    }

    @Test(dependsOnMethods = "homePageTest")
    public void seachTest() {
        System.out.println("Arama yapıldı");
    }

    @Test(dependsOnMethods = "homePageTest")
    public void signInTest() {
        System.out.println("Giriş yapıldı");
    }
}
