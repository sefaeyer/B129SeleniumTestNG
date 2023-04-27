package techproed.tests.day22_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    /*
    @Test: Testlerimizi yazmak için kullandığımız notasyon
    @BeforeSuite:Her bir test suite'inden önce bir kez çalışır
    @AfterSuite:Her bir test suite'inden sonra bir kez çalışır
    @BeforeTest:Her bir test öncesi bir kez çalışır
    @AfterTest:Her bir test sonrası bir kez çalışır
    @BeforeClass:Her bir class'tan önce bir kez çalışır
    @AfterClass:Her bir class'tan sonra bir kez çalışır
    @BeforeMethod:Her bir test methodundan önce bir kez çalışır => JUnit'teki @Before
    @AfterMethod:Her bir test methodundan sonra bir kez çalışır => JUnit'teki @After
    --TestNG de @BeforeGroups,@AfterGroups,@FindBy gibi notasyonlarda vardır bunları ileriki konularda göreceğiz
    --JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip methodlar static olmak ZORUNDAYDI.
    TestNG frameworkunde böyle bir zorunluluk yoktur.

    ------------
    Test NG'de  test methodları alfabetik sıraya göre çalışır.
    @Test(priority = 1) Test casleride öncelikli çalıştırma için kullanuılır.
    Not: priority kullanılmayan testlerin varsayilan priority değeri 0'dır
    ------------
    @Ignore: @Test caseleri atlamak için kullanılır
    @Test(enable=false) @Test caseleri kullanıma kapatmak için kullanılır
     */

    @Test
    public void test1() {
        System.out.println("Test 1 calisti ");
    }
    @Test
    public void test2() {
        System.out.println("Test 2 calisti ");
    }
    @Test
    public void test3() {
        System.out.println("Test 3 calisti ");
    }
    @Test
    public void test4() {
        System.out.println("Test 4 calisti ");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After MEthod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
     /*
Before Suite
Before Test
Before Class
Before Method
Test 1 Çalıştı
After Method
Before Method
Test 2 Çalıştı
After Method
Before Method
Test 3 Çalıştı
After Method
Before Method
Test 4 Çalıştı
After Method
After Class
After Test
After Suite
     */
}
