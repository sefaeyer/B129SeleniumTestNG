package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C02_BlueRentalExcelTest {
    @Test
    public void excelTest() {
        /*
            Eger bir veriyi(datayi) .propersties dosyasindan almak istiyorsak configReader class indan getProperty()
        methodunu kullanarak .properties dosyamiza girdigimiz key degerini belirtiriz ve bize bu key degereinin
        value sunu dondurur.
            Eger bir veriyi excel dosyasindan almak istiyorsak, olusturdugumuz ExcelUtils class indaki methodlari
            kullanarak istedgimiz veriyi alabiliriz.
         */
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        String email= excelUtils.getCellData(1,0);
        String password= excelUtils.getCellData(1,1);
        System.out.println("email = " + email);
        System.out.println("password = " + password);

        //Bluerantal car adresine gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        //Excel dosyamızdan aldıgımız ılk emaıl ve password ıle sayfaya login olalım.
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();//login butonuna tiklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);

        //Login oldugumuzu dogrulyalım.
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());
    }
}
