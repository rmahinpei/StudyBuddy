package ui;

import model.Club;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.ClubsJsonReader;
import persistence.JsonWriter;
import persistence.Writable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Manages clubs stored in StudyBuddy application
public class ClubsManager extends Writable implements AgendasManager {
    private static final String JSON_STORE = "./data/clubs.json";
    private JsonWriter jsonWriter;
    private ClubsJsonReader jsonReader;
    private List<Club> clubs;
    private Scanner input;
    private ClubManager clubManager;

    // EFFECTS: creates a ClubsManager; if there are clubs saved to file, it adds them clubs
    //          otherwise, it creates an empty list of clubs
    public ClubsManager() {
        clubs = new ArrayList<>();
        input = new Scanner(System.in);
        clubManager = new ClubManager();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new ClubsJsonReader(JSON_STORE);
        try {
            List<Club> savedClubs = jsonReader.readClubs();
            if (!savedClubs.isEmpty()) {
                clubs.addAll(savedClubs);
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    @Override
    // EFFECTS: prints clubs menu and prompts user to select an option
    public void displayMenu() {
        String command;
        boolean keepRunning = true;
        while (keepRunning) {
            if (!(clubs.isEmpty())) {
                System.out.println("\nHere are your clubs: ");
                for (Club c : clubs) {
                    System.out.println(c.getName());
                }
            }
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to view an existing club");
            System.out.println("B -> to add a club");
            System.out.println("C -> to remove a club");
            System.out.println("D -> to go back");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("D")) {
                keepRunning = false;
            } else {
                processMenuCommand(command);
            }
        }
    }

    @Override
    // EFFECTS: processes option chosen by user in clubs menu
    public void processMenuCommand(String command) {
        switch (command) {
            case "A":
                viewAgendaFromAgendas();
                break;
            case "B":
                addAgendaToAgendas();
                break;
            case "C":
                removeAgendaFromAgendas();
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    @Override
    // EFFECTS: proceeds to display a club only if it exists in user's clubs
    public void viewAgendaFromAgendas() {
        if (clubs.isEmpty()) {
            System.out.println("You currently don't have any clubs to view.");
        } else {
            System.out.println("Enter the name of the club you want to view: ");
            String clubName = input.next();
            for (Club c : clubs) {
                if (c.getName().equals(clubName)) {
                    clubManager.displayClubMenu(c);
                    break;
                }
            }
        }
    }

    @Override
    // MODIFIES: this
    // EFFECTS: adds a club to clubs
    public void addAgendaToAgendas() {
        System.out.println("Enter the name of the club you want to add: ");
        String clubName = input.next();
        clubs.add(new Club(clubName));
        System.out.println("Club was added!");
    }

    @Override
    // MODIFIES: this
    // EFFECTS: removes a club from clubs
    public void removeAgendaFromAgendas() {
        System.out.println("Enter the name of the club you want to remove: ");
        String clubName = input.next();
        for (Club c : clubs) {
            if (c.getName().equals(clubName)) {
                clubs.remove(c);
                System.out.println("Club was removed!");
                break;
            }
        }
    }

    // EFFECTS: saves all clubs in ClubManager to file
    public void saveClubs() {
        JSONObject json = new JSONObject();
        json.put("clubs", clubsToJson());
        try {
            jsonWriter.open();
            jsonWriter.saveToFile(json);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: creates a JSONArray of JSONObjects that represent clubs
    private JSONArray clubsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Club c : clubs) {
            jsonArray.put(clubToJson(c));
        }
        return jsonArray;
    }

    // EFFECTS: creates a JSONObject representing a club
    private JSONObject clubToJson(Club c) {
        JSONObject json = new JSONObject();
        json.put("name", c.getName());
        json.put("dates", datesToJson(c));
        json.put("reminders", remindersToJson(c));
        return json;
    }

    // EFFECTS: creates a JSONArray of strings that represent reminders of a club
    private JSONArray remindersToJson(Club c) {
        JSONArray jsonArray = new JSONArray();
        for (String r : c.getReminders()) {
            jsonArray.put(r);
        }
        return jsonArray;
    }

}
