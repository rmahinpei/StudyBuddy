package model;

import org.junit.jupiter.api.BeforeEach;

public class ClubTest extends AgendaTest {
    @BeforeEach
    public void setUp() {
        c1 = new Course("CPSC 210");
        d1 = new Date(2021, 8, 8, DateType.EXAM);
        d2 = new Date(2022, 7, 18, DateType.MEETING);

        c1.addDate(d1);
        c1.addDate(d2);
        //c1.addReminder("Review");
        //c1.addReminder("Study");
    }
}
