package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
    Locate'lerimizi tek bir yerde düzenli bir şekilde tutabilmek için;
        1-İlk olarak oluşturmuş olduğumuz page class'ımızda bir constructor oluştururuz
        2-PageFactory class'ından initElements() methodu ile driver'i tanıtırız
        3-@FindBy notasyonu kullanarak locatelerimizi alırız
     */
    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Driver.getDriver().findElement(By.xpath("locate"));
    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement login;

    @FindBy(xpath = "//h6")
    public WebElement dashboard;





}
