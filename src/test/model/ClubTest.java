package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClubTest extends AgendaTest {
    @BeforeEach
    public void setUp() {
        c1 = new Club("nwPlus");
        d1 = new Date(2021, 8, 8, DateType.OTHER);
        d2 = new Date(2022, 7, 18, DateType.MEETING);

        c1.addDate(d1);
        c1.addDate(d2);
        //c1.addReminder("Review");
        //c1.addReminder("Study");
    }

    @Test
    public void testConstructor() {
        assertEquals("nwPlus", c1.getName());
    }
}
