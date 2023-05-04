package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DemogaPage {
    public DemogaPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//*[@class='card mt-4 top-card'])[3]")
    public WebElement afw ;

    @FindBy(xpath = "//*[text()='Please select an item from left to start practice.']")
    public WebElement text;

    @FindBy(xpath = "//*[text()='Browser Windows']")
    public WebElement browserWindow;

    @FindBy(xpath = "//*[text()='New Tab']")
    public WebElement newTab;

    @FindBy(xpath = "//*[@id='sampleHeading']")
    public WebElement samplePage;

}
