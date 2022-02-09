package pages.widgets;

import base.TestBase;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DatepickerPageTest extends TestBase {
    @Test
    public void InitClass(){
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        DatepickerPage page = new DatepickerPage(driver);

        final int year = Calendar.getInstance().get(Calendar.YEAR);
        final int month = Calendar.getInstance().get(Calendar.MONTH);
        final int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        page.clickElement(page.getDateInput());


        //TODAY
        page.scrollToYear(String.valueOf(year))
                .scrollToMonth(page.getMonth(month))
                .pickDay(String.valueOf(day));
        assertThat(page.getDateInput().getAttribute("value"))
                .isEqualTo(String.format("%02d/%02d/%04d",  month + 1, day, year));
        page.clickElement(page.getDateInput());


        //FIRST DAY OF NEXT MONTH
        String newYear = String.valueOf(year + (month + 1) / 12);
        page.scrollToYear(newYear)
                .scrollToMonth(page.getNextMonth(month))
                .pickDay("1");
        assertThat(page.getDateInput().getAttribute("value"))
                .isEqualTo(String.format("%02d/%02d/%04d",  (month + 2) % 12, 1, year + month / 12));

        //LAST OF JAN NEXT YEAR
        page.clickElement(page.getDateInput());
        page.scrollToYear(String.valueOf(year + 1))
                .scrollToMonth("January")
                .pickDay("31");
        assertThat(page.getDateInput().getAttribute("value"))
                .isEqualTo(String.format("%02d/%02d/%04d",  1, 31, year + 1));

        //REPEAT
        page.clickElement(page.getDateInput());
        page.scrollToYear(String.valueOf(year + 1))
                .scrollToMonth("January")
                .pickDay("31");
        assertThat(page.getDateInput().getAttribute("value"))
                .isEqualTo(String.format("%02d/%02d/%04d",  1, 31, year + 1));

        //RANDOM DAY FROM PREVIOUS MONTH
        Random rand = new Random();
        int monthNumber = (month + 11) % 12;
        String prevMonth = page.getMonth(monthNumber);
        String dayToGet = String.valueOf(rand.nextInt(28));
        String yearToGet = String.valueOf(year - (month > 0 ? 0 : 1));

        page.clickElement(page.getDateInput());
        page.scrollToYear(yearToGet)
                .scrollToMonth(prevMonth)
                .pickDay(dayToGet);
        assertThat(page.getDateInput().getAttribute("value"))
                .isEqualTo(String.format("%02d/%02d/%04d",  monthNumber + 1, Integer.parseInt(dayToGet),
                        Integer.parseInt(yearToGet)));


        //PICK RANDOM DATE FROM LAST YEAR
        monthNumber = rand.nextInt(12);
        prevMonth = page.getMonth(monthNumber);
        dayToGet = String.valueOf(rand.nextInt(29));
        yearToGet = String.valueOf(year - 1);

        page.clickElement(page.getDateInput());
        page.scrollToYear(yearToGet)
                .scrollToMonth(prevMonth)
                .pickDay(dayToGet);
        assertThat(page.getDateInput().getAttribute("value"))
                .isEqualTo(String.format("%02d/%02d/%04d",  monthNumber +1, Integer.parseInt(dayToGet),
                        Integer.parseInt(yearToGet)));
    }
}