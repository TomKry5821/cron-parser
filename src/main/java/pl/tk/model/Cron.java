package pl.tk.model;

public class Cron {
  protected final String minutes;
  protected final String hours;
  protected final String dayOfTheMonth;
  protected final String month;
  protected final String dayOfTheWeek;

  public Cron(
      String minutes, String hours, String dayOfTheMonth, String month, String dayOfTheWeek) {
    this.minutes = minutes;
    this.hours = hours;
    this.dayOfTheMonth = dayOfTheMonth;
    this.month = month;
    this.dayOfTheWeek = dayOfTheWeek;
  }
}
