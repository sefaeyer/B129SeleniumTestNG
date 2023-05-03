package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FacebookPage {

    public FacebookPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisButonu;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girdiginSfireYanlis;

}
