package techproed.tests.Practice.day_02;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HerokuapPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_NegativeLoginDataProvider {


// https://id.heroku.com/login sayfasına gidin
// yanlis email ve password giriniz
// login butonuna tıklayınız
// "There was a problem with your login." texti gorunur oldugunu test edin
// sayfayı kapatınız


    // NOT: birden fazla email ve password'u dataProvider kullanarak sırayla deneyin
    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {{"ali@gmail.com","123456"},
                                         {"veli@gmail.com","654321"},
                                         {"hasan@gmail.com","655673"}
        };

        return kullaniciBilgileri;
    }

    /*
        email ve password leri bir liste gibi tutup
        bize yollayacak bir veri saglayicisidir.
     */

    @Test(dataProvider = "kullaniciListesi")
    public void test01(String email, String password) {

        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuapUrl"));

        // yanlis email ve password giriniz
        HerokuapPage herokuapPage = new HerokuapPage();

        herokuapPage.emailBox.sendKeys(email);
        herokuapPage.passwordBox.sendKeys(password);

        // login butonuna tıklayınız
        herokuapPage.logInButonu.click();

        // "There was a problem with your login." texti gorunur oldugunu test edin
        Assert.assertTrue(herokuapPage.theWasaProblemYaziElementi.isDisplayed());

        // sayfayı kapatınız
        Driver.closeDriver();


        // NOT: birden fazla email ve password'u dataProvider kullanarak sırayla deneyin


    }
}
