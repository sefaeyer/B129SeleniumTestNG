package techproed.tests.day28_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.NoSuchElementException;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {
    /*
   Bir class'ta listeners kullanabilmek için class'dan önce @Listeners notasyonu eklememiz gerekir.
       Notasyon içine parametre olarak oluşturmuş olduğumuz utilities package'i altındaki
   Listeners class'ının yolunu belirtmemiz gerekir.
    */
    @Test
    public void test1() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }
    @Test
    public void test2() {
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandı");//Testi atlar yani ignore eder
    }
    @Test
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        throw new NoSuchElementException("NOSUCHELEMENTEXCEPTION");
        /*
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.xpath("lksdlfkjsldkjfs"));
         */
    }
}
