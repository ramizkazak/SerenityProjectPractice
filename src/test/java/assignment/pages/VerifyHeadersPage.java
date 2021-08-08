package assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VerifyHeadersPage  extends BasePAge{



    @FindBy(xpath = "//ul[@class='tab-group__nav']/li")
    public List<WebElement> tabs;

    @FindBy(id = "sp-site-details")
    public WebElement siteDetails;

    @FindBy(xpath = "//h2[contains(@class, 'site-profile-site-details__h2')]")
    public List<WebElement> topHeader;

    @FindBy(xpath = "//main[@id='main']//div[@id='sp-site-details']//h3[contains(@class,'h4')]")
    public List<WebElement> headerList;


}
