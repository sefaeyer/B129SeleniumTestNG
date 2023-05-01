package techproed.tests.day26_ExcelDataProvider;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class C02_DataProvider {

    // Eger baska bir classta dataprovider'larimizi yaziyorsak
    // dataProvider = "cityDatas" 'dan sonra
    // dataProvider'imizin nerede oldugunu belirtmemiz gerekiyor.
    // Bu yuzden virgul koyup 'dataProviderClass = DataProviderUtils.class)' diyerek yerini gosterdik.
    @Test(dataProvider = "sehirVerileri", dataProviderClass = DataProviderUtils.class)
    public void test1(String ad, String bolge, String plaka) {
        System.out.println(ad+" | "+bolge+" | "+plaka);

    }

    @Test(dataProvider = "kullanicilar",dataProviderClass = DataProviderUtils.class)
    public void test2(String username, String password) {
        System.out.println(username+" | "+password);

    }
    /*  O D E V
        Yukaridaki orneklerdeki gibi blueRentalCar sayfasina login olunuz
        Her data icin login oldugunuzu dogrulayiniz.
        NOT: configuration.properties dosyasindaki verileri kullaniniz
     */


}
