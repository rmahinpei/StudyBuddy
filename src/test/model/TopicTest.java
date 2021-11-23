package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TopicTest {
    Topic t1;
    Topic t2;

    @BeforeEach
    public void setUp() {
        t1 = new Topic("Surface sketching");
    }

    @Test
    public void testSingleParamConstructor() {
        assertEquals("Surface sketching", t1.getTopicName());
        assertEquals(0, t1.getNumCompleted());
        assertEquals(3, t1.getNumRemaining());
        assertEquals("", t1.getCourse().getName());
    }

    @Test
    public void testSetCourse() {
        Course c1 = new Course("MATH 200");
        t1.setCourse(c1);
        assertEquals(c1, t1.getCourse());
    }

    @Test
    public void testTwoParamConstructorMoreCompletedThanMin() {
        t2 = new Topic("Derivatives", 5);
        assertEquals(5, t2.getNumCompleted());
        assertEquals(0, t2.getNumRemaining());
    }

    @Test
    public void testTwoParamConstructorLessCompletedThanMin() {
        t2 = new Topic("Derivatives", 1);
        assertEquals(1, t2.getNumCompleted());
        assertEquals(2, t2.getNumRemaining());
    }

    @Test
    public void testCompleteQuestion() {
        t1.completeQuestion();
        // testing typical case
        assertEquals(2, t1.getNumRemaining());
        assertEquals(1, t1.getNumCompleted());

        // testing accumulation of completed questions
        t1.completeQuestion();
        assertEquals(1, t1.getNumRemaining());
        assertEquals(2, t1.getNumCompleted());

        // testing edge case
        t1.completeQuestion();
        assertEquals(0, t1.getNumRemaining());
        assertEquals(3, t1.getNumCompleted());

        // testing more questions completed than needed
        t1.completeQuestion();
        assertEquals(0, t1.getNumRemaining());
        assertEquals(4, t1.getNumCompleted());

    }
}
