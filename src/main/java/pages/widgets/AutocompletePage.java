package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.List;

public class AutocompletePage extends BasePage {
    @FindBy(css = "#search")
    private WebElement searchInput;


    public AutocompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAutocompletion(){
        return driver.findElements(By.cssSelector("li.ui-menu-item"));
    }

    public WebElement getSearchInput() {
        return searchInput;
    }
}
