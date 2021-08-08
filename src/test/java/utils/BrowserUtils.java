package utils;

import net.serenitybdd.core.pages.WebElementFacade;
import  net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public  class BrowserUtils extends PageObject {


    public  List<String> getAllHeaders(){
        return findAll("//main[@id='main']//div[@id='sp-site-details']//h3[contains(@class,'h4')]")
                .stream().map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
