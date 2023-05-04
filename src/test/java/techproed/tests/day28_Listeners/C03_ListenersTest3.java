package techproed.tests.day28_Listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class C03_ListenersTest3 {
    /*
    Test class imizda fail olma durumu olan bir testin listeners ile tekrar calismasini istersek
    @Test notasyonundan sonra parametre olarak retryAnalyzer yazar ve olusturdugumuz ListenersRetry class inin
    yolunu belirtiriz.
     */

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test1() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test2() {
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandı");//Testi atlar yani ignore eder
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        throw new NoSuchElementException("NOSUCHELEMENTEXCEPTION");
        /*
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.xpath("lksdlfkjsldkjfs"));
         */
    }
}
