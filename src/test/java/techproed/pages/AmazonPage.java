package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // dropdown'dan "Computers" optionunu secin
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement ddm;

    // arama motoruna "Asus" yazıp aratın
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement aramaKutusu;


    // ikinci urunun fotografını cekin
    @FindBy(xpath = "(//img[@class='s-image'])[2]")
    public WebElement ikinciUrun;



    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisi;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement sonucYazisi2;




}
