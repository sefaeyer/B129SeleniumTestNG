package techproed.tests.day24_Properties_Pages;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_ClassWork {
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Driver.closeDriver();
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
        Driver.closeDriver();
    }
}
