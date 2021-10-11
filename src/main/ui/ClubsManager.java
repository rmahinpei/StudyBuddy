package ui;

import model.Club;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Manages clubs stored in StudyBuddy application
public class ClubsManager implements AgendasManager {
    private List<Club> clubs;
    private Scanner input;
    private ClubManager clubManager;

    // EFFECTS: creates a ClubsManager with an empty clubs list, a scanner, and a ClubManager
    public ClubsManager() {
        clubs = new ArrayList<>();
        input = new Scanner(System.in);
        clubManager = new ClubManager();
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
            System.out.println("Enter the name of the course you want to view: ");
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
}
