package techproed.tests.day24_Properties_Pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterTechproPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_PageKullanimi {
    @Test
    public void test1() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterTechproPages testCenterTechproPages = new TestCenterTechproPages();
        testCenterTechproPages.userName.sendKeys(ConfigReader.getProperty("kullaniciAdi"), Keys.TAB,
                                                ConfigReader.getProperty("kullaniciPassword"),Keys.ENTER);
        Assert.assertTrue(testCenterTechproPages.text.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterTechproPages.logout.click();
        Assert.assertTrue(testCenterTechproPages.giris.isDisplayed());
        Driver.closeDriver();

    }
}
