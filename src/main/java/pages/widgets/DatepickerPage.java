package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DatepickerPage extends BasePage {
    private final List<String> monthsNames = new ArrayList<String>(List.of("January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"));
    @FindBy(css = "#datepicker")
    private WebElement dateInput;
    @FindBy(css = "span.ui-datepicker-month")
    private WebElement monthOnWidget;
    @FindBy(css = "span.ui-datepicker-year")
    private WebElement yearOnWidget;
    @FindBy(css = "a.ui-datepicker-next")
    private WebElement nextMonth;
    @FindBy(css = "a.ui-datepicker-prev")
    private WebElement previousMonth;
    @FindBy(css = "table.ui-datepicker-calendar")
    private WebElement linksOfDays;

    public DatepickerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public DatepickerPage scrollToYear(String year){
        wait.until(ExpectedConditions.visibilityOf(yearOnWidget));
        if(yearOnWidget.getText().equalsIgnoreCase(year))
            return this;

        while(stringLargerThan(yearOnWidget.getText(), year)){
            clickElement(previousMonth);
        }

        while(stringSmallerThan(yearOnWidget.getText(), year)){
            clickElement(nextMonth);
        }

        return this;
    }

    public DatepickerPage scrollToMonth(String month){
        assertThat(month).isIn(monthsNames);
        while(!monthOnWidget.getText().equals(month)){
            if(monthsNames.indexOf(monthOnWidget.getText()) > monthsNames.indexOf(month)){
                clickElement(previousMonth);
            }
            else{
                clickElement(nextMonth);
            }
        }
        return this;
    }

    private boolean stringSmallerThan(String text, String year) {
        return Integer.parseInt(text) < Integer.parseInt(year);
    }

    private boolean stringLargerThan(String text, String year) {
        return Integer.parseInt(text) > Integer.parseInt(year);
    }

    public DatepickerPage pickDay(String day){
        String selector = "//a[text()='" + day + "']";
        clickElement(linksOfDays.findElement(By.xpath(selector)));
        return this;
    }

    public WebElement getDateInput() {
        return dateInput;
    }

    public String getMonth(int index) {
        return monthsNames.get(index);

    }

    public String getNextMonth(int month) {
        try {
            return getMonth(month + 1);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return getMonth(0);
        }
    }
}
