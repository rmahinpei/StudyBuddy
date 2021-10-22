package persistence;

import model.Club;
import model.Date;
import model.DateType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Modelled using UBC CPSC 210's JSONSerializationDemo
public class ClubsJsonWriterTest extends JsonTest {
    Club c1;
    Club c2;

    @Test
    public void testWriterInvalidFile() {
        try {
            ClubsJsonWriter jsonWriter = new ClubsJsonWriter("./data/\0illegalFile.json");
            jsonWriter.open();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptyClubsList() {
        try {
            ClubsJsonWriter writer = new ClubsJsonWriter("./data/testWriterEmptyListClubs.json");
            writer.open();
            writer.writeClubs(new ArrayList<>());
            writer.close();

            ClubsJsonReader reader = new ClubsJsonReader("./data/testWriterEmptyListClubs.json");
            List<Club> clubs = reader.readClubs();
            assertEquals(0, clubs.size());
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    @Test
    public void testWriterGeneralClubsList() {
        try {
            List<Club> clubsToWrite = makeListOfClubs();

            ClubsJsonWriter writer = new ClubsJsonWriter("./data/testWriterGeneralListClubs.json");
            writer.open();
            writer.writeClubs(clubsToWrite);
            writer.close();

            ClubsJsonReader reader = new ClubsJsonReader("./data/testWriterGeneralListClubs.json");
            List<Club> clubsToRead = reader.readClubs();

            assertEquals(2, clubsToRead.size());

            checkClub("nwPlus", 2, 1, clubsToRead.get(0));
            assertEquals("Volunteer", clubsToRead.get(0).getReminders().get(0));
            assertEquals("Write", clubsToRead.get(0).getReminders().get(1));
            checkDate(2022, 4, 12, "EXAM", clubsToRead.get(0).getDates().get(0));

            checkClub("HackerNoon", 1, 1, clubsToRead.get(1));
            assertEquals("Work", clubsToRead.get(1).getReminders().get(0));
            checkDate(2023, 5, 13, "MEETING", clubsToRead.get(1).getDates().get(0));
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    // helper method for testWriterGeneralListOfClubs()
    private List<Club> makeListOfClubs() {
        c1 = new Club("nwPlus");
        c1.addDate(new Date(2022, 4, 12, DateType.EXAM));
        c1.addReminder("Volunteer");
        c1.addReminder("Write");

        c2 = new Club("HackerNoon");
        c2.addDate(new Date(2023, 5, 13, DateType.MEETING));
        c2.addReminder("Work");

        List<Club> clubs = new ArrayList<>();
        clubs.add(c1);
        clubs.add(c2);

        return clubs;
    }

}
