package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//*[@role='button'])[1]")
    public WebElement  login;

    @FindBy(xpath = "//*[@id='formBasicEmail']")
    public WebElement  email;

    @FindBy(id = "dropdown-basic-button")
    public WebElement  verify;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement  hataMesaji;

    @FindBy(xpath = "//*[@id='dropdown-basic-button']")
    public WebElement login3;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[text()='OK']")
    public WebElement ok;

    //Bu bir örnektir
    @FindBy(xpath = "//*[text()='OK']")//-> Linklerin listesinin locati
    public List<WebElement> listler;
    //Normalde Webelementleri locate için findelements kullanıyorduk
    //TestNG de page class'ında bunun kullanımı yukarıdaki örnekteki gibidir


    //-------------------------------------------------------------


    @FindBy(xpath = "//*[@name='car']")
    public WebElement aracSecimi;

    @FindBy(xpath = "(//*[@class='form-control is-invalid'])[1]")
    public WebElement pickup;

    @FindBy (xpath = "(//*[@class='form-control is-invalid'])[2]")
    public WebElement dropOff;
    @FindBy (xpath = "(//*[@class='form-control is-invalid'])[3]")
    public WebElement pickUpDate;
    @FindBy (xpath = "(//*[@class='form-control is-invalid'])[4]")
    public WebElement dropOffDate;
    @FindBy (xpath = "(//*[@class='form-control'])[2]")
    public WebElement dropOffTime;
    @FindBy (xpath = "(//*[@class='form-control is-invalid'])[3]")
    public WebElement pickUpTime;

    @FindBy(xpath = "//*[@class='w-100 btn btn-primary btn-lg']")
    public  WebElement continueReservation;
}
