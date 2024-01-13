package pl.tk.model;

public class Cron {
  private final String minutes;
  private final String hours;
  private final String dayOfTheMonth;
  private final String month;
  private final String dayOfTheWeek;

  public Cron(
      String minutes, String hours, String dayOfTheMonth, String month, String dayOfTheWeek) {
    this.minutes = minutes;
    this.hours = hours;
    this.dayOfTheMonth = dayOfTheMonth;
    this.month = month;
    this.dayOfTheWeek = dayOfTheWeek;
  }

  public String getMinutes() {
    return minutes;
  }

  public String getHours() {
    return hours;
  }

  public String getDayOfTheMonth() {
    return dayOfTheMonth;
  }

  public String getMonth() {
    return month;
  }

  public String getDayOfTheWeek() {
    return dayOfTheWeek;
  }
}
