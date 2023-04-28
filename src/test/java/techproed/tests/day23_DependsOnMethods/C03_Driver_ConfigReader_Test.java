package techproed.tests.day23_DependsOnMethods;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.Assert.assertTrue;

public class C03_Driver_ConfigReader_Test {

    @Test
    public void driverTest() {

        //https://techproeducation.com/ sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));


        //Title testi yapınız
        assertTrue(Driver.getDriver().getTitle().contains("Techpro"));
        System.out.println(ConfigReader.getProperty("username"));
        System.out.println(ConfigReader.getProperty("password"));

        //sayfayı kapatınız.
        Driver.closeDriver();


    }
}














//https://techproeducation.com/ sayfasına gidiniz
//Title testi yapınız
//sayfayı kapatınız.