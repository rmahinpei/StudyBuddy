package persistence;

import model.Club;
import model.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Contains a series of helper methods for test classes
public class JsonTest {
    protected void checkClub(String name, int numReminders, int numDates, Club c) {
        assertEquals(name, c.getName());
        assertEquals(numReminders, c.getReminders().size());
        assertEquals(numDates, c.getDates().size());
    }

    protected void checkDate(int year, int month, int day, String type, Date d) {
        assertEquals(year, d.getDate()[0]);
        assertEquals(month, d.getDate()[1]);
        assertEquals(day, d.getDate()[2]);
        assertEquals(type, d.getDateType().toString());
    }
}
