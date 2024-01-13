package pl.tk.expander;

import java.util.Map;

public class ExpanderPool {

  private static final Map<String, CronExpander> pool =
      Map.of(
          "minute", new MinuteExpander(),
          "hour", new HourExpander(),
          "dayOfTheMonth", new DayOfTheMonthExpander(),
          "month", new MonthExpander(),
          "dayOfTheWeek", new DayOfTheWeekExpander());

  public MinuteExpander minuteExpander() {
    return (MinuteExpander) pool.get("minute");
  }

  public HourExpander hourExpander() {
    return (HourExpander) pool.get("hour");
  }

  public DayOfTheMonthExpander dayOfTheMonthExpander() {
    return (DayOfTheMonthExpander) pool.get("dayOfTheMonth");
  }

  public MonthExpander monthExpander() {
    return (MonthExpander) pool.get("month");
  }

  public DayOfTheWeekExpander dayOfTheWeekExpander() {
    return (DayOfTheWeekExpander) pool.get("dayOfTheWeek");
  }
}
