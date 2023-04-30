package techproed.tests.day24_Properties_Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PageKullanimi {
    @Test
    public void test1() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));
        /*
            Yukardaki adress için 20 adet test methodu oluşturursak sonrasında yukardaki url'de bir değişiklik
        olduğunda bütün test methodlarından tek tek url düzeltmek yerine bir kere .properties dosyamdan
        url'li düzeltirim ve bu bizim için daha hızlı daha düzenli ve daha kolay olur
        */

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Login Testini basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());
        Driver.closeDriver();


    }
}
