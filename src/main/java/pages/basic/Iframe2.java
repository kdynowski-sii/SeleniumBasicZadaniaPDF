package pages.basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

import java.util.List;

public class Iframe2 extends BasePage {
    @FindBy(css = "#inputLogin")
    private WebElement inputLogin;

    @FindBy(css = "#inputPassword")
    private WebElement inputPassword;

    @FindBy(css = "#inlineFormCustomSelectPref")
    private WebElement selectCont;

    private final Select continentSelect;

    @FindBy(css = "input.form-check-input")
    List<WebElement> yearsOfExperienceRadios;

    @FindBy(css = "button.btn")
    private WebElement submitButton;

    public Iframe2(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        continentSelect = new Select(selectCont);
    }

    public void fillForm(String login, String password, String continentValue, String yearsValue){
        sendKeys(inputLogin, login)
                .sendKeys(inputPassword, password);
        continentSelect.selectByValue(continentValue);
        clickElement(yearsOfExperienceRadios.get(Integer.parseInt(yearsValue) - 1));
        clickElement(submitButton);
    }
}