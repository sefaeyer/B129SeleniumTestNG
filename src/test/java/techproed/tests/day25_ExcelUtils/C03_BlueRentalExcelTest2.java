package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest2 {
    @Test
    public void test1() {
        /*
        EXCEL dosyasindaki tum email ve passwordler ile
        BlueRentalCar sayfasina gidip login olalim?
        */
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        //Sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        //Bir loop olusturup excel dosyasindaki tum verileri girdirelim
        for(int i=1; i<= excelUtils.rowCount(); i++){//i yi 1 den baslattik cunku veriler 1. satirdan basliyor
            String mail = excelUtils.getCellData(i,0);
            String password = excelUtils.getCellData(i,1);
            System.out.println(mail+" || "+password);

            blueRentalPage.login.click();
            ReusableMethods.bekle(1);
            blueRentalPage.email.sendKeys(mail, Keys.TAB,password,Keys.ENTER);
            assert blueRentalPage.verify.isDisplayed();
            ReusableMethods.bekle(1);
            blueRentalPage.login3.click();
            ReusableMethods.bekle(1);
            blueRentalPage.logout.click();
            ReusableMethods.bekle(1);
            blueRentalPage.ok.click();



        }
        Driver.closeDriver();

    }
}
