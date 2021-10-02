package model;

import java.util.ArrayList;
import java.util.List;

public class Club implements Agenda {
    private String name;
    private List<Date> dates;
    private List<String> reminders;

    // EFFECTS: creates a club with given name that has 0 dates and reminders by default
    public Club(String name) {
        this.name = name;
        dates = new ArrayList<>();
        reminders = new ArrayList<>();
    }

    // getter
    public String getClubName() {
        return name;
    }

    @Override
    public void addDate(Date date) {

    }

    @Override
    public void removeDate(Date date) {

    }

    @Override
    public List<Date> getDates() {
        return null;
    }

    @Override
    public void addReminder(String reminder) {

    }

    @Override
    public void removeReminder(int index) {

    }

    @Override
    public List<String> getReminders() {
        return null;
    }
}
