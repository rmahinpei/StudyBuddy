package persistence;

import model.Club;
import model.Date;
import model.DateType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClubsJsonWriterTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            ClubsJsonWriter jsonWriter = new ClubsJsonWriter("./data/\0illegalFile.json");
            jsonWriter.open();
            fail("IO exception expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyListOfClubs() {
        try {
            String jsonStore = "./data/testWriterEmptyListOfClubs.json";
            ClubsJsonWriter writer = new ClubsJsonWriter(jsonStore);
            writer.open();
            writer.writeClubs(new ArrayList<>());
            writer.close();

            ClubsJsonReader reader = new ClubsJsonReader("./data/testWriterEmptyListOfClubs.json");
            List<Club> clubs = reader.readClubs();
            assertEquals(0, clubs.size());
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    @Test
    public void testWriterGeneralListOfClubs() {
        try {
            Club c1 = new Club("nwPlus");
            c1.addDate(new Date(2022, 4, 12, DateType.EXAM));
            c1.addReminder("Volunteer");
            Club c2 = new Club("HackerNoon");
            c2.addDate(new Date(2023, 5, 13, DateType.MEETING));
            c2.addReminder("Work");
            List<Club> clubsToWrite = new ArrayList<>();
            clubsToWrite.add(c1);
            clubsToWrite.add(c2);

            String jsonStore = "./data/testWriterGeneralListOfClubs.json";
            ClubsJsonWriter writer = new ClubsJsonWriter(jsonStore);
            writer.open();
            writer.writeClubs(clubsToWrite);
            writer.close();

            ClubsJsonReader reader = new ClubsJsonReader("./data/testWriterGeneralListOfClubs.json");
            List<Club> clubsToRead = reader.readClubs();
            assertEquals(2, clubsToRead.size());
            checkClub("nwPlus", 1, 1, clubsToRead.get(0));
            assertTrue(clubsToRead.get(0).getReminders().get(0).contains("Volunteer"));
            checkDate(2022, 4, 12, "EXAM", clubsToRead.get(0).getDates().get(0));
            checkClub("HackerNoon", 1, 1, clubsToRead.get(1));
            assertTrue(clubsToRead.get(1).getReminders().get(0).contains("Work"));
            checkDate(2023, 5, 13, "MEETING", clubsToRead.get(1).getDates().get(0));
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    // HELPER METHOD
    private void checkClub(String name, int numReminders, int numDates, Club c) {
        assertEquals(name, c.getName());
        assertEquals(numReminders, c.getReminders().size());
        assertEquals(numDates, c.getDates().size());
    }

    // HELPER METHOD
    private void checkDate(int year, int month, int day, String type, Date d) {
        assertEquals(year, d.getDate()[0]);
        assertEquals(month, d.getDate()[1]);
        assertEquals(day, d.getDate()[2]);
        assertEquals(type, d.getDateType().toString());
    }

}
