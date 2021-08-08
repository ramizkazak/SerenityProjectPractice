package assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePAge{


    @FindBy(xpath = "(//div//li[@role='button'])[2]")
    public WebElement sitesTab;


    @FindBy(xpath = "(//a[@class='site-search-results-list__link site-name--pre-wrap'])[3]")
    public WebElement searchResult3;

    public By result = By.xpath("//tabs//li[@role='button']/span");
    @FindBy(xpath = "//tabs//li[@role='button']/span")
    public WebElement totalResultElement;


}
