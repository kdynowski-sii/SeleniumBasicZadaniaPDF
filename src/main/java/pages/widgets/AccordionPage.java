package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.List;

public class AccordionPage extends BasePage {
    @FindBy(css = "h3")
    private List<WebElement> headers;

    @FindBy(css = "div.ui-accordion-content")
    private List<WebElement> divs;

    public List<WebElement> getDivs() {
        return divs;
    }

    public AccordionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getHeaders() {
        return headers;
    }

    public String getParagraphsText(){
        for(WebElement div: divs){
            if(div.isDisplayed()){
                return div.getText();
            }
        }
        return null;
    }
}
