package persistence;

import model.Club;
import model.Course;
import model.Date;
import model.Topic;

import static org.junit.jupiter.api.Assertions.*;

// Contains a series of helper methods for persistence test classes
public class JsonTest {
    protected void checkClub(String name, int numReminders, int numDates, Club c) {
        assertEquals(name, c.getName());
        assertEquals(numReminders, c.getReminders().size());
        assertEquals(numDates, c.getDates().size());
    }

    protected void checkCourse(String name, int numTopics, int numDates, Course c) {
        assertEquals(name, c.getName());
        assertEquals(numDates, c.getDates().size());
        assertEquals(numTopics, c.getTopics().size());
    }

    protected void checkTopic(String name, int numCompleted, Topic t) {
        assertEquals(name, t.getTopicName());
        assertEquals(numCompleted, t.getNumCompleted());
    }

    protected void checkDate(int year, int month, int day, String type, Date d) {
        assertEquals(year, d.getDate()[0]);
        assertEquals(month, d.getDate()[1]);
        assertEquals(day, d.getDate()[2]);
        assertEquals(type, d.getDateType().toString());
    }
}
