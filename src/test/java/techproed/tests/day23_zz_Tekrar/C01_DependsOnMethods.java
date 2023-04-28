package techproed.tests.day23_zz_Tekrar;

import org.testng.annotations.Test;

public class C01_DependsOnMethods {

    @Test
    public void test1() {
        System.out.println("Anasayfaya gidildi.");
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        System.out.println("Arama yapildi");
    }

    @Test(dependsOnMethods = "test1")
    public void test3() {
        System.out.println("giris yapildi");
    }
}
