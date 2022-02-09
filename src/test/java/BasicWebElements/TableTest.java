package BasicWebElements;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.basic.TablePage;

import java.util.List;

public class TableTest extends TestBase {

    @Test
    public void printingOutAMountain(){
        driver.get("https://seleniumui.moderntester.pl/table.php");
        TablePage page = new TablePage(driver);
        List<WebElement> rows = page.getRowFromTable();

        for(WebElement row: rows){
            if(page.higherThan(row, 4000) && page.inRange(row,"Switzerland")) {
            System.out.println(page.stringifyRow(row));
            }
        }
    }
}
