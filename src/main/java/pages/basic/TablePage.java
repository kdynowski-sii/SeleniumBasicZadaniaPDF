package pages.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.List;

public class TablePage extends BasePage {
    @FindBy(css = "tbody tr")
    List<WebElement> rowFromTable;

    public TablePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getRowFromTable() {
        return rowFromTable;
    }

    public String stringifyRow(WebElement row){
        String mountain = "Rank: " + row.findElement(By.cssSelector("th")).getText();
        mountain += " Peak: " + row.findElement(By.cssSelector("td:nth-of-type(1)")).getText();
        mountain += " Mountain range: " + row.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
        return mountain;
    }

    public boolean higherThan(WebElement row, int height){
        int actual = Integer.parseInt(row.findElement(By.cssSelector("td:last-of-type")).getText());
        return actual > height;

    }

    public boolean inRange(WebElement row, String range) {
        String actual = row.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
        return actual.contains(range);
    }
}
