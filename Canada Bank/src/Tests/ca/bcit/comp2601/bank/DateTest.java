package ca.bcit.comp2601.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest
{
    Date d1;
    Date d2;
    Date d3;
    Date d4;

    @BeforeEach
    void setUp()
    {
        d1 = new Date(1, 1,1);
        d2 = new Date(1704, 06, 20);
        d3 = new Date(1907, 12, 31);
        d4 = new Date(2024, 01, 24);
    }

    @AfterEach
    void tearDown()
    {
        Date d1 = null;
        Date d2 = null;
        Date d3 = null;
        Date d4 = null;
    }

    @Test
    void getYear()
    {
        assertEquals(1, d1.getYear());
        assertEquals(2024, d4.getYear());
    }

    @Test
    void getMonth()
    {
        assertEquals(1, d1.getMonth());
        assertEquals(12, d3.getMonth());
    }

    @Test
    void getDay()
    {
        assertEquals(20, d2.getDay());
        assertEquals(31, d3.getDay());
    }

    @Test
    void getYYYYMMDD()
    {
        assertEquals("0001-01-01", d1.getYYYYMMDD());
        assertEquals("2024-01-24", d4.getYYYYMMDD());
    }

    @Test
    void getDayOfTheWeek()
    {
        assertEquals("Monday", d1.getDayOfTheWeek());
        assertEquals("Friday", d2.getDayOfTheWeek());
        assertEquals("Tuesday", d3.getDayOfTheWeek());
        assertEquals("Wednesday", d4.getDayOfTheWeek());
    }
}