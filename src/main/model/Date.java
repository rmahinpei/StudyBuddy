package model;

// Represents a date that has a year, a month, a day as well as a date type
public class Date {
    private int[] date;
    private DateType dateType;

    // REQUIRES: year is a valid year (>= 0 and having a max of 4 digits)
    //           month is between 1-12 inclusive,
    //           day is between 1-31
    // MODIFIES: this
    // EFFECTS: creates a date for the given year, month, day with the specified date type
    public Date(int year, int month, int day, DateType dateType) {
        date = new int[3];
        date[0] = year;
        date[1] = month;
        date[2] = day;
        this.dateType = dateType;
    }

    // GETTER
    public int[] getDate() {
        return date;
    }

    // GETTER
    public DateType getDateType() {
        return dateType;
    }

    // EFFECTS: returns date as a string with the format "dateType: year/month/day"
    public String dateToString() {
        return "" + dateType + ": " + date[0] + "/" + date[1] + "/" + date[2];
    }
}
