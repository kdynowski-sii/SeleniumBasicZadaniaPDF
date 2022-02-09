package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class TabWindowsPage extends BasePage {
    @FindBy(css = "#newBrowserWindow")
    private WebElement newBrowserWindowButton;

    @FindBy(css = "#newMessageWindow")
    private WebElement newMessageWindowButton;

    @FindBy(css = "#newBrowserTab")
    private WebElement newBrowserTabButton;

    public TabWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getNewBrowserWindowButton() {
        return newBrowserWindowButton;
    }

    public WebElement getNewMessageWindowButton() {
        return newMessageWindowButton;
    }

    public WebElement getNewBrowserTabButton() {
        return newBrowserTabButton;
    }
}
