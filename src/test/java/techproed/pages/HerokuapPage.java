package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HerokuapPage {

    public HerokuapPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
    public WebElement logInButonu;


    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement theWasaProblemYaziElementi;


}
