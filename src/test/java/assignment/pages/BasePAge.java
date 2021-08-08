package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public abstract class BasePAge {

    public BasePAge(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(xpath = "(//section[@class='card']/h3)[1]")
    public WebElement ncsc;

    @FindBy(id = "keyword-input")
    public WebElement keywordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;
}
