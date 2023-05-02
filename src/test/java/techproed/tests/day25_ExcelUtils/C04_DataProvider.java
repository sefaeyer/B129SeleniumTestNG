package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProvider {

            /*
        -DataProvider, birçok veriyi test caselere loop kullanmadan aktarmak için kullanılır.
        TestNG'den gelen bir özellilktir.2 boyutlu br object array return eder.
        DDT(Data Driven Testing) için kullanılır. Yani birden fazla veriyi test case'lerde aynı anda kullanmak için
        kullanılır.
        Kullanımı için @Test notasyonundan sonra parametre olarak dataprovider yazılır ve String bir isim belirtilir.
        Bu belirttiğimiz isimle @DataProvider notasyonu ile bir method oluşturulur.
         */


    /*
    Eger farkli bir test methodu icin ayni dataProvider kullanilacaksa
    @DataProvider(name = "googleTest") seklinde dataprovider notasyonundan sonra name parametresine yeni
    olusturdugumuz methodun adini yazariz
     */

    @Test(dataProvider = "googleTest")
    public void testdataprovider(String data) { //DataP.daki verileri alabilmek icin
                                                // Test methodumuza String bir parametre atamasi yapariz
        System.out.println(data);

    }
    @DataProvider(name = "googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"}};
    }

    @Test(dataProvider = "googleTest")
    public void googleTest(String araclar) {
        //Google sayfasina gidiniz
        //Driver.getDriver().get("https://google.com");
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"}
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);


        //Her aramadan sonra sayfa resmi aliniz
        ReusableMethods.tumSayfaResmi();
        ReusableMethods.bekle(1);
        Driver.closeDriver();
    }
}
