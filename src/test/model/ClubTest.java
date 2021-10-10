package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClubTest extends AgendaTest {
    Club c2;

    @BeforeEach
    public void setUp() {
        c1 = new Club("nwPlus");
        c2 = new Club("HackerNoon");
        d1 = new Date(2021, 8, 8, DateType.OTHER);
        d2 = new Date(2022, 7, 18, DateType.MEETING);

        c1.addDate(d1);
        c1.addDate(d2);
    }

    @Test
    public void testConstructor() {
        assertEquals("nwPlus", c1.getName());
        assertEquals("HackerNoon", c2.getName());
    }

    @Test
    public void testAddReminder() {
        c2.addReminder("Review");
        assertEquals(1, c2.getReminders().size());
        assertTrue(c2.getReminders().contains("Review"));

        c2.addReminder("Study");
        assertEquals(2, c2.getReminders().size());
        assertTrue(c2.getReminders().contains("Study"));
    }

    @Test
    public void testRemoveReminderAtStart(){
        c2.addReminder("Review");
        c2.addReminder("Study");
        c2.addReminder("Practice");

        c2.removeReminder(1);
        assertEquals(2, c2.getReminders().size());
        assertFalse(c2.getReminders().contains("Review"));

        c2.removeReminder(1);
        assertEquals(1, c2.getReminders().size());
        assertFalse(c2.getReminders().contains("Study"));
    }

    @Test
    public void testRemoveReminderAtMiddle(){
        c2.addReminder("Review");
        c2.addReminder("Study");
        c2.addReminder("Practice");

        c2.removeReminder(2);
        assertEquals(2, c2.getReminders().size());
        assertFalse(c2.getReminders().contains("Study"));

    }
}
