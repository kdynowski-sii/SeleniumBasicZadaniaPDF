package BasicWebElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.basic.TabWindowsPage;
import pages.basic.TablePage;

import java.util.ArrayList;
import java.util.List;

public class TabWindowsTest extends TestBase {
    @Test
    public void windowsTabsTest() {
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
        TabWindowsPage page = new TabWindowsPage(driver);

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        page.clickElement(page.getNewBrowserWindowButton());

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        TablePage tpage = new TablePage(driver);
        List<WebElement> rows = tpage.getRowFromTable();

        for (WebElement row : rows) {
            if (tpage.higherThan(row, 4000) && tpage.inRange(row, "Switzerland")) {
                System.out.println(tpage.stringifyRow(row));
            }
        }

        driver.close();
        driver.switchTo().window(winHandleBefore);

        page.clickElement(page.getNewMessageWindowButton());
        windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.close();
        driver.switchTo().window(winHandleBefore);

        page.clickElement(page.getNewBrowserTabButton());
        windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        tpage = new TablePage(driver);
        rows = tpage.getRowFromTable();

        for (WebElement row : rows) {
            if (tpage.higherThan(row, 4000) && tpage.inRange(row, "Switzerland")) {
                System.out.println(tpage.stringifyRow(row));
            }
        }

        driver.close();
        driver.switchTo().window(winHandleBefore);
    }
}
