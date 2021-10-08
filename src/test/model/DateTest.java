package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    Date d1;

    @BeforeEach
    public void setUp() {
        d1 = new Date(2021, 4, 12, DateType.EXAM);
    }

    @Test
    public void testConstructor() {
        assertEquals(2021, d1.getDate()[0]);
        assertEquals(4, d1.getDate()[1]);
        assertEquals(12, d1.getDate()[2]);
        assertEquals("", d1.getDateDescription());
        assertEquals(DateType.EXAM, d1.getDateType());
        // should I test all my enum options?
    }

    @Test
    public void testDateToString() {
        assertEquals("EXAM: 2021/4/12", d1.dateToString());
    }

}