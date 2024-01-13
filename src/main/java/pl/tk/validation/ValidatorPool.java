package pl.tk.validation;

import java.util.Map;

final class ValidatorPool {
  private final Map<String, Validator> pool =
      Map.of(
          "minute",
          new MinuteValidator(),
          "hour",
          new HourValidator(),
          "dayOfTheMonth",
          new DayOfTheMonthValidator(),
          "month",
          new MonthValidator(),
          "dayOfTheWeek",
          new DayOfTheWeekValidator());

  public ValidatorPool() {}

  public MinuteValidator minuteValidator() {
    return (MinuteValidator) pool.get("minute");
  }

  public HourValidator hourValidator() {
    return (HourValidator) pool.get("hour");
  }

  public DayOfTheMonthValidator dayOfTheMonthValidator() {
    return (DayOfTheMonthValidator) pool.get("dayOfTheMonth");
  }

  public MonthValidator monthValidator() {
    return (MonthValidator) pool.get("month");
  }

  public DayOfTheWeekValidator dayOfTheWeekValidator() {
    return (DayOfTheWeekValidator) pool.get("dayOfTheWeek");
  }
}
