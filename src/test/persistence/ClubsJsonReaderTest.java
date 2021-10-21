package persistence;

import model.Club;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Modelled using UBC CPSC 210's JSONSerializationDemo
public class ClubsJsonReaderTest extends JsonTest {
    @Test
    public void testReaderInvalidFile() {
        ClubsJsonReader reader = new ClubsJsonReader("./data/invalidFile.json");
        try {
            List<Club> clubs = reader.readClubs();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testReaderEmptyClubsList() {
        ClubsJsonReader reader = new ClubsJsonReader("./data/testReaderEmptyListClubs.json");
        try {
            List<Club> clubs = reader.readClubs();
            assertEquals(0, clubs.size());
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    @Test
    void testReaderGeneralClubsList() {
        ClubsJsonReader reader = new ClubsJsonReader("./data/testReaderGeneralListClubs.json");
        try {
            List<Club> clubs = reader.readClubs();
            assertEquals(2, clubs.size());

            checkClub("nwPlus", 1, 1, clubs.get(0));
            assertTrue(clubs.get(0).getReminders().get(0).contains("Volunteer"));
            checkDate(2022, 4, 12, "EXAM", clubs.get(0).getDates().get(0));

            checkClub("HackerNoon", 1, 1, clubs.get(1));
            assertTrue(clubs.get(1).getReminders().get(0).contains("Work"));
            checkDate(2023, 5, 13, "MEETING", clubs.get(1).getDates().get(0));
        } catch (IOException e) {
            fail("No exception expected");
        }
    }
}
