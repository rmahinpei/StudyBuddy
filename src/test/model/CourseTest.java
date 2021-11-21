package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest extends AgendaTest {
    Course c2;

    @BeforeEach
    public void setUp() {
        c1 = new Course("CPSC210");
        c2 = new Course("MATH200");
        d1 = new Date(2021, 8, 8, DateType.EXAM);
        d2 = new Date(2022, 7, 18, DateType.MEETING);

        c1.addDate(d1);
        c1.addDate(d2);

        c2.addTopic(new Topic("Surface sketching"));
        c2.addTopic(new Topic("Partial derivatives", 1));
    }

    @Test
    public void testConstructor() {
        assertEquals("CPSC210", c1.getName());
        assertEquals("MATH200", c2.getName());
    }


    @Test
    public void testAddTopic() {
        assertEquals(2, c2.getTopics().size());
        assertEquals("Surface sketching", c2.getTopics().get(0).getTopicName());

        assertEquals("Partial derivatives", c2.getTopics().get(1).getTopicName());
        assertEquals(1, c2.getTopics().get(1).getNumCompleted());
        assertEquals(3 - 1, c2.getTopics().get(1).getNumRemaining());
    }

    @Test
    public void testAddTopics() {
        List<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Surface sketching"));
        topics.add(new Topic("Partial derivatives", 1));

        Course c3 = new Course("MATH200");
        c3.addTopics(topics);

        assertEquals(2, c3.getTopics().size());
        assertEquals("Surface sketching", c3.getTopics().get(0).getTopicName());

        assertEquals("Partial derivatives", c3.getTopics().get(1).getTopicName());
        assertEquals(1, c3.getTopics().get(1).getNumCompleted());
        assertEquals(3 - 1, c3.getTopics().get(1).getNumRemaining());
    }

    @Test
    public void testRemoveFirstTopic() {
        c2.removeTopic("Surface sketching");
        assertEquals(1, c2.getTopics().size());
        assertEquals("Partial derivatives", c2.getTopics().get(0).getTopicName());
    }

    @Test
    public void testRemoveSecondTopic() {
        c2.removeTopic("Partial derivatives");
        assertEquals(1, c2.getTopics().size());
        assertEquals("Surface sketching", c2.getTopics().get(0).getTopicName());
    }

    @Test
    public void testRemoveNotValidTopic() {
        c2.removeTopic("Some topic not in topics");
        assertEquals(2, c2.getTopics().size());
        assertEquals("Surface sketching", c2.getTopics().get(0).getTopicName());
        assertEquals("Partial derivatives", c2.getTopics().get(1).getTopicName());
    }

}
