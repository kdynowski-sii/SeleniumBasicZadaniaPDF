package widgets;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.widgets.AccordionPage;

import java.util.List;

public class AccordionTest extends TestBase {
    @Test
    public void displayPrintAll(){
        driver.get("https://seleniumui.moderntester.pl/accordion.php");
        AccordionPage page = new AccordionPage(driver);

        List<WebElement> toClick = page.getHeaders();
        for (WebElement clickMe: toClick) {

            if(!clickMe.getAttribute("class").contains("active")) {
                page.clickElement(clickMe);
                wait.until(ExpectedConditions.invisibilityOf(page.getDivs()
                        .get(toClick.indexOf(clickMe)-1))); // Waits till done after click
            }
            System.out.println(page.getParagraphsText());
        }
    }
}
