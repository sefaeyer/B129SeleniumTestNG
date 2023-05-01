package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {


    @DataProvider
    public Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","IcAnadolu","06"},{"Izmir","Ege","35"},{"Diyarbakir","Dogu","21"}};
    }

    @DataProvider
    public Object[][] kullanicilar() {
        return new Object[][]{{"Sefa","34436345647"},{"Nuri","56456563456"},{"Gul","2346545365"},{"Erol","3456456345"}};
    }

    @DataProvider
    public Object[][] blueRental() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        return excelUtils.getDataArray();
    }
}
