package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public abstract class AgendaTest {
    Agenda c1;
    Date d1;
    Date d2;

    @Test
    public void testAddDate() {
        assertEquals(2, c1.getDates().size());
        assertTrue(c1.getDates().contains(d1));
        assertTrue(c1.getDates().contains(d2));
    }

    @Test
    public void testRemoveDate() {
        c1.removeDate(d2);
        assertEquals(1, c1.getDates().size());
        assertFalse(c1.getDates().contains(d2));
    }


    //@Test
    //public void testAddReminder() {
    //    assertEquals(2, c1.getReminders());
    //    assertTrue(c1.getReminders().contains("Review"));
    //    assertTrue(c1.getReminders().contains("Study"));
    //}

    //@Test
    //public void testRemoveFirstReminder() {
    //    c1.removeReminder(0);
    //    assertEquals(1, c1.getReminders().size());
    //    assertFalse(c1.getReminders().contains("Review"));
    //}

    //@Test
    //public void testRemoveSecondReminder() {
    //    c1.removeReminder(1);
    //    assertEquals(1, c1.getReminders().size());
    //    assertFalse(c1.getReminders().contains("Study"));
    //}
}
