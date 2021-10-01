package model;

import java.util.List;

public interface Calendar {
    void addDate(Date date);

    void removeDate(Date date);

    List<int[]> getDates();

    void addReminder(String reminder);

    void removeReminder(int index);

    List<String> getReminders();

}
