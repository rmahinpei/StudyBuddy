package model;

import java.util.ArrayList;
import java.util.List;

public class Club extends Agenda {
    private List<String> reminders;

    // EFFECTS: creates a club with given name that has 0 dates and reminders by default
    public Club(String name) {
        super(name);
        reminders = new ArrayList<>();
    }

    // getter
    public List<String> getReminders() {
        return reminders;
    }

    // EFFECTS: adds reminder to reminders
    public void addReminder(String reminder) {
        reminders.add(reminder);
    }

    // REQUIRES: 1 <= index <= reminders.size()
    // EFFECTS: remove reminder at position (starting from 1)
    public void removeReminder(int index) {
        reminders.remove(index - 1);
    }

}
