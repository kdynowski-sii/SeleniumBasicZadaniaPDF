package BasicWebElements;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.basic.AlertsPage;

public class AlertsTest extends TestBase {
    @Test
    public void simpleAlertPopUpTest(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertsPage page = new AlertsPage(driver);

        page.clickElement(page.getSimpleAlertButton());
        driver.switchTo().alert().accept();
    }

    @Test
    public void promptAlertTest(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertsPage page = new AlertsPage(driver);

        page.clickElement(page.getPromptAlertButton());
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        String output = page.getTextFromElement(page.getPromptLabel());
        Assert.assertEquals(output, "Hello Lord Vader! How are you today?");
    }

    @Test
    public void confirmAlertTest(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertsPage page = new AlertsPage(driver);

        page.clickElement(page.getConfirmAlertButton());
        driver.switchTo().alert().accept();
        String output = page.getTextFromElement(page.getConfirmLabel());
        Assert.assertEquals(output, "You pressed OK!");

        page.clickElement(page.getConfirmAlertButton());
        driver.switchTo().alert().dismiss();
        output = page.getTextFromElement(page.getConfirmLabel());
        Assert.assertEquals(output, "You pressed Cancel!");
    }

    @Test
    public void delayedAlertTest(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertsPage page = new AlertsPage(driver);

        page.clickElement(page.getDelayedAlert());
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
        String output = page.getTextFromElement(page.getDelayedAlertLabel());

        Assert.assertEquals(output, "OK button pressed");
    }
}
