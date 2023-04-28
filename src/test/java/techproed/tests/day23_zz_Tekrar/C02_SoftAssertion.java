package techproed.tests.day23_zz_Tekrar;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C02_SoftAssertion {

    @Test
    public void testSoftAssertion() {
        //1.Adim Soft assertion objesi olusturma
        SoftAssert softAssert = new SoftAssert();
        System.out.println("1. assertion");

        //2. Adim Assertion
        //1
        softAssert.assertEquals(2,1);
        System.out.println("2. assertion");

        //2
        softAssert.assertEquals(3,5);
        System.out.println("3. assertion");

        //3.Adim assertAll() methodu
        softAssert.assertAll();
        System.out.println("assertAll() methodu");
    }
}
