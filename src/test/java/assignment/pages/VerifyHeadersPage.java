package assignment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class VerifyHeadersPage {

    public VerifyHeadersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@class='tab-group__nav']/li")
    public List<WebElement> tabs;

    @FindBy(id = "sp-site-details")
    public WebElement siteDetails;

    @FindBy(xpath = "//h2[contains(@class, 'site-profile-site-details__h2')]")
    public List<WebElement> topHeader;
}
