package pl.tk.expander;

import java.util.List;
import pl.tk.model.Cron;

public class ExpandedCron extends Cron {
  ExpanderPool pool = new ExpanderPool();

  private List<Integer> expandedMinutes;
  private List<Integer> expandedHours;
  private List<Integer> expandedDayOfTheMonth;
  private List<Integer> expandedMonth;
  private List<Integer> expandedDayOfTheWeek;

  public ExpandedCron(
      String minutes, String hours, String dayOfTheMonth, String month, String dayOfTheWeek) {
    super(minutes, hours, dayOfTheMonth, month, dayOfTheWeek);
    expand();
  }

  private void expand() {
    expandMinutes();
    expandHours();
    expandDayOfTheMonth();
    expandMonth();
    expandDayOfTheWeek();
  }

  private void expandMinutes() {
    this.expandedMinutes = pool.minuteExpander().expand(minutes);
  }

  private void expandHours() {
    this.expandedHours = pool.hourExpander().expand(hours);
  }

  private void expandDayOfTheMonth() {
    this.expandedDayOfTheMonth = pool.dayOfTheMonthExpander().expand(dayOfTheMonth);
  }

  private void expandMonth() {
    this.expandedMonth = pool.monthExpander().expand(month);
  }

  private void expandDayOfTheWeek() {
    this.expandedDayOfTheWeek = pool.dayOfTheWeekExpander().expand(dayOfTheWeek);
  }

  @Override
  public String toString() {
    return String.format(
        """
                  minutes          %s
                  hours            %s
                  day of the month %s
                  month            %s
                  day of the week  %s
        """,
        expandedMinutes, expandedHours, expandedDayOfTheMonth, expandedMonth, expandedDayOfTheWeek);
  }
}
