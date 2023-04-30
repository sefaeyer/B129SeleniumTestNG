package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterTechproPages {
    public TestCenterTechproPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='exampleInputEmail1']")
    public WebElement userName;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement text;

    @FindBy(xpath = "//*[text()=' Logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[text()='Login Page']")
    public WebElement giris;
}
