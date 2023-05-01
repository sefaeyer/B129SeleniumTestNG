package techproed.tests.day26_ExcelDataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.*;

import java.util.Arrays;

public class C03_DataProviderExcel {
    @Test
    public void test1() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        System.out.println(Arrays.deepToString(excelUtils.getDataArray()));
    }

    @Test(dataProvider = "blueRental",dataProviderClass = DataProviderUtils.class)
    public void test2(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();//login butonuna tiklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
