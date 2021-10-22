package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Modelled using UBC CPSC 210's JSONSerializationDemo
public class CoursesJsonWriterTest extends JsonTest {
    Course c1;
    Course c2;

    @Test
    public void testWriterInvalidFile() {
        try {
            CoursesJsonWriter jsonWriter = new CoursesJsonWriter("./data/\0illegalFile.json");
            jsonWriter.open();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyCoursesList() {
        try {
            CoursesJsonWriter writer = new CoursesJsonWriter("./data/testWriterEmptyListCourses.json");
            writer.open();
            writer.writeCourses(new ArrayList<>());
            writer.close();

            CoursesJsonReader reader = new CoursesJsonReader("./data/testWriterEmptyListCourses.json");
            List<Course> courses = reader.readCourses();
            assertEquals(0, courses.size());
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    @Test
    public void testWriterGeneralCoursesList() {
        try {
            List<Course> coursesToWrite = makeListOfCourses();

            CoursesJsonWriter writer = new CoursesJsonWriter("./data/testWriterGeneralListCourses.json");
            writer.open();
            writer.writeCourses(coursesToWrite);
            writer.close();

            CoursesJsonReader reader = new CoursesJsonReader("./data/testWriterGeneralListCourses.json");
            List<Course> coursesToRead = reader.readCourses();

            assertEquals(2, coursesToRead.size());

            checkCourse("CPSC210", 2, 1, coursesToRead.get(0));
            checkTopic("Abstraction", 0, coursesToRead.get(0).getTopics().get(0));
            checkTopic("Construction", 1, coursesToRead.get(0).getTopics().get(1));
            checkDate(2022, 4, 12, "EXAM", coursesToRead.get(0).getDates().get(0));

            checkCourse("MATH200", 1, 1, coursesToRead.get(1));
            checkTopic("Derivatives", 2, coursesToRead.get(1).getTopics().get(0));
            checkDate(2023, 5, 13, "MEETING", coursesToRead.get(1).getDates().get(0));
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    // helper method for testWriterGeneralListOfCourses()
    private List<Course> makeListOfCourses() {
        c1 = new Course("CPSC210");
        c1.addDate(new Date(2022, 4, 12, DateType.EXAM));
        c1.addTopic(new Topic("Abstraction"));
        c1.addTopic(new Topic("Construction", 1));

        c2 = new Course("MATH200");
        c2.addDate(new Date(2023, 5, 13, DateType.MEETING));
        c2.addTopic(new Topic("Derivatives", 2));

        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);

        return courses;
    }
}
