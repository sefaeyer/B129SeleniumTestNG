package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C05_DataProvider {


    /*
            sam.walker@bluerentalcars.com   c!fas_art
            kate.brown@bluerentalcars.com   tad1$Fas
            raj.khan@bluerentalcars.com v7Hg_va^
            pam.raymond@bluerentalcars.com  Nga^g6!
            Verileri kullanarak bluerentalcar sayfasına login olalim
             */

    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{"sam.walker@bluerentalcars.com","c!fas_art"},
                                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                                {"pam.raymond@bluerentalcars.com","Nga^g6!"}};
    }
    @Test(dataProvider = "blueRental")
    public void testdataprovider(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();//login butonuna tiklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);
        Driver.closeDriver();

        /*--> O D E V
        C05 class'ındaki task için her kullanıcı için doğrulama yapalım
        En son sayfayı kapalım
         */
    }
}
