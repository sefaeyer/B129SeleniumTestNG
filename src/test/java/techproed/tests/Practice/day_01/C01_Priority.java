package techproed.tests.Practice.day_01;

import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_Priority extends ReusableMethods {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız


    @Test(priority = 1)
    public void amazon() {
        Driver.getDriver().get("https://amazon.com");
    }
    @Test(priority = 2)
    public void bestbuy() {
        Driver.getDriver().get("https://bestbuy.com");
    }
    @Test// (priority = 0) defoult 0 dir.
    public void techproeducation() {
        Driver.getDriver().get("https://techproeducation.com");
    }
}
