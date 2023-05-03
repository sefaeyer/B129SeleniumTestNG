package techproed.tests.Practice.day_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.Driver;

public class C03_SoftAssert {

    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin


    @Test
    public void test01() {

        // "https://amazon.com" sayfasına gidiniz
        Driver.getDriver().get("https://amazon.com");

        // Title'in "Amazon" icerdigini test edin
        String amzTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(amzTitle.contains("Amazon"),"TITLE AMAZON ICERMIYOR");

        // Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"ARAMA KUTUSU ERISILEBILIR DEGIL");

        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi = Driver.getDriver().findElement
                (By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(),"SONUC YAZISI GORUNMUYOR");

        // Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"SONUC YAZISI NUTELLA ICERMIYOR");

        // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin
        softAssert.assertAll();

        /*
        softAssert.assertAll() yazıp tum hataları listelemesini istemeliyiz. Aksi halde hata vermez.
         */

    }
}
