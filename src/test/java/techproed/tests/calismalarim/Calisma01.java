package techproed.tests.calismalarim;


import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DemogaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Calisma01 {

// https://demoqa.com/ url'ine gidin.
//Alerts, Frame & Windows Butonuna click yap
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
//New Tab butonunun görünür olduğunu doğrula
//New Tab butonuna click yap
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
//İlk Tab'a geri dön
//New Tab butonunun görünür olduğunu doğrula


    @Test
    public void test1() {

        // https://demoqa.com/ url'ine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("demoqaUrl"));

        //Alerts, Frame & Windows Butonuna click yap
        DemogaPage demogaPage = new DemogaPage();

        demogaPage.afw.click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        Assert.assertTrue(demogaPage.text.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        demogaPage.browserWindow.click();

        String handle1 = Driver.getDriver().getWindowHandle();

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(demogaPage.newTab.isDisplayed());

        //New Tab butonuna click yap
        demogaPage.newTab.click();

        Set<String> handles = Driver.getDriver().getWindowHandles();
        List<String> listHandles = new ArrayList<>(handles);
        if(handle1.equals(listHandles.get(0))){
            Driver.getDriver().switchTo().window(listHandles.get(1));
        }else {
            Driver.getDriver().switchTo().window(listHandles.get(0));
        }

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Assert.assertTrue(demogaPage.samplePage.isDisplayed());

        //İlk Tab'a geri dön
        if(handle1.equals(listHandles.get(0))){
            Driver.getDriver().switchTo().window(listHandles.get(0));
        }else {
            Driver.getDriver().switchTo().window(listHandles.get(1));
        }

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(demogaPage.newTab.isDisplayed());

        //Kapanis
        Driver.closeDriver();

    }
}
