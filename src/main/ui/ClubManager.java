package ui;

import model.Club;
import model.Date;
import model.Topic;

// Manages a club stored in StudyBuddy application
public class ClubManager extends AgendaManager {
    private Club club;

    // creates a ClubManager with a scanner
    public ClubManager() {
        super();
    }

    // EFFECTS: prints club menu and prompts user to select an option
    public void displayClubMenu(Club club) {
        this.club = club;
        String command;
        boolean keepRunning = true;

        while (keepRunning) {
            displayDetails();
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to add a date");
            System.out.println("B -> to remove a date");
            System.out.println("C -> to add a reminder");
            System.out.println("D -> to remove a reminder");
            System.out.println("E -> to go back\n");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("E")) {
                keepRunning = false;
            } else {
                processMenuCommand(command);
            }
        }
    }

    @Override
    // EFFECTS: prints dates and reminders in club only if they are not empty
    protected void displayDetails() {
        if (!(club.getDates().isEmpty())) {
            System.out.println("\nHere are the dates in " + club.getName() + ":");
            for (Date d : club.getDates()) {
                System.out.println(d.dateToString());
            }
        }
        if (!(club.getReminders().isEmpty())) {
            System.out.println("\nHere are the reminders in " + club.getName() + ":");
            for (String r : club.getReminders()) {
                System.out.println(r);
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
            case "C":
                addReminder();
                break;
            case "D":
                removeReminder();
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a reminder to reminders of club
    private void addReminder() {
        System.out.println("Enter your reminder: ");
        String reminder = input.next();
        club.addReminder(reminder);
        System.out.println("Reminder was added!");
    }

    // MODIFIES: this
    // EFFECTS: removes a reminder from the reminders in club
    private void removeReminder() {
        System.out.println("Enter the position of the reminder you want to remove: ");
        int position = input.nextInt();
        club.removeReminder(position);
        System.out.println("Reminder was removed!");
    }

}
