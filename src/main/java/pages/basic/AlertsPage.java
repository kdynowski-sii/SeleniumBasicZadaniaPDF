package pages.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.Base64;

public class AlertsPage extends BasePage {
    @FindBy(css = "#simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(css = "#prompt-alert")
    private WebElement promptAlertButton;

    @FindBy(css = "#confirm-alert")
    private WebElement confirmAlertButton;

    @FindBy(css = "#prompt-label")
    private WebElement promptLabel;

    @FindBy(css = "#delayed-alert-label")
    private WebElement delayedAlertLabel;

    public WebElement getDelayedAlertLabel() {
        return delayedAlertLabel;
    }

    public WebElement getConfirmLabel() {
        return confirmLabel;
    }

    @FindBy(css = "#confirm-label")
    private WebElement confirmLabel;

    public WebElement getSimpleAlertButton() {
        return simpleAlertButton;
    }

    public WebElement getPromptAlertButton() {
        return promptAlertButton;
    }

    public WebElement getConfirmAlertButton() {
        return confirmAlertButton;
    }

    public WebElement getDelayedAlert() {
        return delayedAlert;
    }

    @FindBy(css = "#delayed-alert")
    private WebElement delayedAlert;

    public AlertsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getPromptLabel() {
        return promptLabel;
    }


}
