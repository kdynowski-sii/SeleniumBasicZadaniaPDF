package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class IframesPage extends BasePage {
    private Iframe1 frame1;
    public WebElement getBasicLink() {
        return basicLink;
    }

    @FindBy(xpath = "//a[contains(text(), 'Basic')]")
    private WebElement basicLink;

    public IframesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Iframe1 getFrame1() {
        return frame1;
    }


    public void switchToFrame1(){
        driver.switchTo().frame("iframe1");
        frame1 = new Iframe1(driver);
    }

    public void switchToFrame2(){
        driver.switchTo().frame("iframe2");
    }

    public void switchToMainFrame(){
        driver.switchTo().defaultContent();
    }

    public class Iframe1 extends BasePage{
        @FindBy(css = "#inputFirstName3")
        private WebElement firstnameInput;

        @FindBy(css = "#inputSurname3")
        private WebElement lastnameInput;

        @FindBy(css = "button.btn")
        private WebElement submitButton;

        public Iframe1(WebDriver webDriver){
            super(webDriver);
            PageFactory.initElements(driver, this);
        }

        public void fillForm(String fname, String lname){
            sendKeys(firstnameInput, fname)
                    .sendKeys(lastnameInput, lname)
                    .clickElement(submitButton);
        }
    }


}
