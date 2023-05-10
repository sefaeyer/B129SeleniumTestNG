package techproed.tests.Practice.day_02;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor {

    // 'https://www.amazon.com' adresine gidin
    // arama kutusuna "Java" yazip aratın
    // sonuc yazisinin "Java" icerdigini test edin
    // kontrollu olarak yeni bir sayfa acın
    // yeni acılan sayfada "Kitap" aratın
    // sonuc yazisinin Kitap icerdigini test edin

    // test raporu alınız


    @Test
    public void test01() {

        extentTest=extentReports.createTest("testname","tanim");

        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.pass("AMAZON ANA SAYFASINA GIDILDI");

        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java", Keys.ENTER);
        extentTest.pass("ARAMA KUTUSUNA JAVA YAZIP ARATILDI");


        // sonuc yazisinin "Java" icerdigini test edin
        String sonucYazisi = amazonPage.sonucYazisi.getText();
        Assert.assertTrue(sonucYazisi.contains("Java"));
        extentTest.pass("SONUC YAZISININ JAVA ICERDIGI TEST EDILDI");


        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.pass("KONTROLLU OLARAK YENI SEKME ACILDI");


        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Kitap",Keys.ENTER);
        extentTest.pass("YENI SEKMEDE ARAMA KUTUSUNA KITAP YAZIP ARATILDI");


        // sonuc yazisinin Kitap icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi2.getText().contains("Kitap"));
        extentTest.pass("SONUC YAZISININ KITAP ICERDIGI TEST EDILDI");


        // test raporu alınız


    }
}
