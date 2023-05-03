package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Odev {
    /*

Acceptance Criteria:
Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
Ve giris yapilmadiginda
Hata mesaji almali : Please first login
Giris yapildiginda hata mesaji alınmamalı

         */

    @Test
    public void test1() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        WebElement secim = blueRentalPage.aracSecimi;
        Select options = new Select(secim);
        options.selectByVisibleText("Audi Q8");

        blueRentalPage.pickup.sendKeys(ConfigReader.getProperty("aracAlinacakKonum"));
        ReusableMethods.bekle(1);
        blueRentalPage.dropOff.sendKeys(ConfigReader.getProperty("aracBirakilacakKonum"));
        ReusableMethods.bekle(1);
        blueRentalPage.pickUpDate.sendKeys(ConfigReader.getProperty("alinacakTarih"));
        ReusableMethods.bekle(1);
        blueRentalPage.pickUpTime.sendKeys(ConfigReader.getProperty("alinacakSaat"));
        ReusableMethods.bekle(1);
        blueRentalPage.dropOffDate.sendKeys(ConfigReader.getProperty("teslimTarihi"));
        ReusableMethods.bekle(1);
        blueRentalPage.dropOffTime.sendKeys(ConfigReader.getProperty("teslimSaati"),Keys.ENTER);

        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());
    }
}
