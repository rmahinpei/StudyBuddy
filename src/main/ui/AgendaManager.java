package ui;

import model.*;

import java.util.Scanner;

// Manages dates in an Agenda subtype
public abstract class AgendaManager {
    protected Scanner input;

    public AgendaManager() {
        input = new Scanner(System.in);
    }

    protected abstract void displayDetails();

    protected abstract void processMenuCommand(String command);

    // MODIFIES: course
    // EFFECTS: adds a date to course
    protected void addDate(Agenda agenda) {
        Date returnedDate = generateDate();
        agenda.addDate(returnedDate);
        System.out.println("Date was added!");
    }

    // MODIFIES: course
    // EFFECTS: removes a date from course
    protected void removeDate(Agenda agenda) {
        Date returnedDate = generateDate();
        for (Date d : agenda.getDates()) {
            if (d.getDate()[0] == returnedDate.getDate()[0]
                    && d.getDate()[1] == returnedDate.getDate()[1]
                    && d.getDate()[2] == returnedDate.getDate()[2]
                    && d.getDateType() == returnedDate.getDateType()) {
                agenda.getDates().remove(d);
                System.out.println("Date was removed!");
                break;
            }
        }
    }

    // EFFECTS: creates a date corresponding to user's inputs
    private Date generateDate() {
        System.out.println("Enter the year: ");
        int year = input.nextInt();
        System.out.println("Enter the month: ");
        int month = input.nextInt();
        System.out.println("Enter the day: ");
        int day = input.nextInt();
        System.out.println("Select the date type\n1 -> EXAM\n2 -> ASSIGNMENT\n3 -> MEETING\n4 -> OTHER");
        int dateType = input.nextInt();
        DateType type = null;
        switch (dateType) {
            case 1:
                type = DateType.EXAM;
                break;
            case 2:
                type = DateType.ASSIGNMENT;
                break;
            case 3:
                type = DateType.MEETING;
                break;
            case 4:
                type = DateType.OTHER;
        }
        return new Date(year, month, day, type);
    }
}
