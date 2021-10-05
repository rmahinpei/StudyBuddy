package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TopicTest {
    Topic t1;

    @BeforeEach
    public void setUp() {
        t1 = new Topic("Surface sketching");
    }

    @Test
    public void testConstructor() {
        assertEquals("Surface sketching", t1.getTopicName());
        assertEquals(0, t1.getNumCompleted());
        assertEquals(3, t1.getNumRemaining());
        // should 3 be hardcoded if it is a static constant?
    }

    @Test
    public void testCompleteQuestion() {
        t1.completeQuestion();
        // testing typical case
        assertEquals(2, t1.getNumRemaining());
        assertEquals(1, t1.getNumCompleted());
        // testing accumulation
        t1.completeQuestion();
        assertEquals(1, t1.getNumRemaining());
        assertEquals(2, t1.getNumCompleted());
        // testing edge case
        t1.completeQuestion();
        assertEquals(0, t1.getNumRemaining());
        assertEquals(3, t1.getNumCompleted());
        // testing more completed than needed
        t1.completeQuestion();
        assertEquals(0, t1.getNumRemaining());
        assertEquals(4, t1.getNumCompleted());
        // should these be divided into separate methods???
    }
}
