package techproed.tests.Practice.day_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C02_DependsOnMethods {

    // test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
    // test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim


    // test02 isimli test methodunu, test01'e baglayınız.
    // test03 isimli test methodunu, test02'ye baglayınız.


    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        Driver.getDriver().findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella" +
                Keys.ENTER);
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {
        WebElement sonucYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String sonucYazisiStr = sonucYazisi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Nutella"));

        /*
        DeopendsOnMethods test methodlarının calısma sırasına karısmaz.
        Sadece baglı olan test, baglandıgı testin sonucuna bakar
        Baglandıgı test Passed olmazsa, Baglanan test hic calısmaz.

         */
    }
}
