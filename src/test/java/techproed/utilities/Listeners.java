package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    /*
    Listeners: TestNG de bir testin durumunu ve sonucunu izleyen ve bu duruma yanit veren bir yapidir
    Testlerin passed ve failedd olma durumlarini, baslangic ve bitisini takip eder ve raporlayabilir.
        Bunun icin TestNG den ITestListener arayuzunu(interface) kullaniriz. Olusturdugumuz Listeners
        class ina ITestListener arayuzundeki methodlari override etmek icin implements ederiz
     */

    @Override
    public void onStart(ITestContext context) {//@BeforeClass gibi
        System.out.println("onStart Methodu -> Tum testlerden once tek bir sefer cagirilir "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish -> Tum testlerden sonra tek bir sefer cagirilir. "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {//@Before gibi
        System.out.println("onTestStart -> her bir testten once bir kez cagirilir. "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess -> PASSED olan testlerden sonra bir kez cagirilir. "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure -> FAILED olan testlerden sonra bir kez cagirilir. "+result.getName());
        ReusableMethods.tumSayfaResmi();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Methodu -> SKIP(atlanan) olan testlerden sonra tek bir sefer çağrılır "+result.getName());
    }
}
