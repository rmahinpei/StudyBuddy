package ui;

import model.Club;
import model.Date;

public class ClubManager extends AgendaManager {
    private Club club;

    public ClubManager() {
        super();
    }

    public void displayClubMenu(Club club) {
        this.club = club;
        String command;
        boolean keepRunning = true;

        while (keepRunning) {
            displayDetails();
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to add a date");
            System.out.println("B -> to remove a date");
            System.out.println("C -> to go back");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("C")) {
                keepRunning = false;
            } else {
                processMenuCommand(command);
            }
        }
    }

    @Override
    protected void displayDetails() {
        if (!(club.getDates().isEmpty())) {
            System.out.println("\nHere are the dates in " + club.getName() + ":");
            for (Date d : club.getDates()) {
                System.out.println(d.dateToString());
            }
        }
    }

    @Override
    // EFFECTS: processes option chosen by user in club menu
    protected void processMenuCommand(String command) {
        switch (command) {
            case "A":
                addDate(club);
                break;
            case "B":
                removeDate(club);
                break;
        }
    }

}
