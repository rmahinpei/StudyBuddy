package persistence;

import model.Course;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Modelled using UBC CPSC 210's JSONSerializationDemo
public class CoursesJsonReaderTest extends JsonTest {
    @Test
    public void testReaderInvalidFile() {
        CoursesJsonReader reader = new CoursesJsonReader("./data/invalidFile.json");
        try {
            List<Course> courses = reader.readCourses();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyCoursesList() {
        CoursesJsonReader reader = new CoursesJsonReader("./data/testReaderEmptyListCourses.json");
        try {
            List<Course> courses = reader.readCourses();
            assertEquals(0, courses.size());
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    @Test
    void testReaderGeneralCoursesList() {
        CoursesJsonReader reader = new CoursesJsonReader("./data/testReaderGeneralListCourses.json");
        try {
            List<Course> courses = reader.readCourses();
            assertEquals(2, courses.size());

            checkCourse("CPSC210", 2, 1, courses.get(0));
            checkTopic("Abstraction", 0, courses.get(0).getTopics().get(0));
            checkTopic("Construction", 1, courses.get(0).getTopics().get(1));
            checkDate(2022, 4, 12, "EXAM", courses.get(0).getDates().get(0));

            checkCourse("MATH200", 1, 1, courses.get(1));
            checkTopic("Derivatives", 2, courses.get(1).getTopics().get(0));
            checkDate(2023, 5, 13, "MEETING", courses.get(1).getDates().get(0));
        } catch (IOException e) {
            fail("No exception expected");
        }
    }
}
