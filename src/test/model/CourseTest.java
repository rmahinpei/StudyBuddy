package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    Agenda c1;
    Date d1;
    Date d2;

    @BeforeEach
    public void setUp() {
        c1 = new Course("CPSC 210");
        d1 = new Date(2021,8,8, DateType.EXAM);
        d2 = new Date(2022,7,18, DateType.MEETING);
    }

    @Test
    public void testAddDate() {
        assertEquals(0, c1.getDates().size());

        c1.addDate(d1);
        assertEquals(1, c1.getDates().size());
        assertTrue(c1.getDates().contains(d1));

        c1.addDate(d2);
        assertEquals(2, c1.getDates().size());
        assertTrue(c1.getDates().contains(d2));
    }

}
