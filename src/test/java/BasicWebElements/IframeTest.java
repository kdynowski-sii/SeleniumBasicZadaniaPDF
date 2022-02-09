package BasicWebElements;

import base.TestBase;
import org.testng.annotations.Test;
import pages.basic.Iframe2;
import pages.basic.IframesPage;

public class IframeTest extends TestBase {
    @Test
    public void testIframes(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        IframesPage page = new IframesPage(driver);

        page.switchToFrame1();
        page.getFrame1().fillForm("Andrew", "Gotham");
        page.switchToMainFrame();

        page.switchToFrame2();
        Iframe2 secondFrame = new Iframe2(driver);
        secondFrame.fillForm("ObiWan", "8***7&@!Abba", "asia", "2");
        driver.switchTo().defaultContent();

        page.clickElement(page.getBasicLink());
        {}
    }
}
