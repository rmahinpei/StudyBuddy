package model;

import java.util.List;

public class Club extends Agenda {
    //private List<String> reminders;

    // EFFECTS: creates a club with given name that has 0 dates and reminders by default
    public Club(String name) {
        super(name);
    }

    // getter
    //public List<String> getReminders() {
    //    return reminders;
    //}

    // REMINDERS NOT TESTED!!!
    // EFFECTS: prefixed reminder by a number representing its position in reminders
    //          and then adds reminder to reminders
    //public void addReminder(String reminder) {
    //    reminder = reminders.size() + 1 + ") " + reminder;
    //    reminders.add(reminder);
    //}

    // EFFECTS: remove reminder at position of index (zero-indexed)
    //public void removeReminder(int index) {
    //    reminders.remove(index);
    //}

    // EFFECTS: prints out all reminders
    //public void printReminders() {
    //    for (String s : reminders) {
    //        System.out.println(s);
    //    }
    //}

}
