package widgets;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.widgets.AutocompletePage;

import java.util.List;
import java.util.Random;

public class AutocompletionTest extends TestBase {
    @Test
    public void AutoCompletionTest() {
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        AutocompletePage page = new AutocompletePage(driver);

        page.sendKeys(page.getSearchInput(), "a");
        List<WebElement> proposals = page.getAutocompletion();
        for(WebElement proposal: proposals){
            System.out.println(proposal.getText());
        }
        Random rand = new Random();
        WebElement selectElem = proposals.get(rand.nextInt(proposals.size()));
        selectElem.click();
        String textInSearchInput = page.getSearchInput().getText(), selectedText = selectElem.getText();
        Assert.assertEquals(textInSearchInput, selectedText);
        System.out.println(selectedText);
        driver.getCurrentUrl();
    }
}
