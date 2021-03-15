package PremierLeague;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDate {
    Date date = new Date(22,4,2020);

    @Test
    public void getDay(){
        assertEquals(22,date.getDay());
    }
    @Test
    public void setDay(){
        int day = 7;
        date.setDay(day);
        assertEquals(day,date.getDay());
    }
    @Test
    public void getMonth(){
        assertEquals(4,date.getMonth());
    }
    @Test
    public void setMonth(){
        int month = 7;
        date.setMonth(month);
        assertEquals(month,date.getMonth());
    }
    @Test
    public void getYear(){
        assertEquals(2020,date.getYear());
    }
    @Test
    public void setYear(){
        int year = 7;
        date.setYear(year);
        assertEquals(year,date.getYear());
    }
}
