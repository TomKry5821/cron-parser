package pl.tk.validation;

import pl.tk.exception.InvalidCronSyntaxException;

public class CronValidator implements Validator {

  private final ValidatorPool validatorPool;

  public CronValidator() {
    this.validatorPool = new ValidatorPool();
  }

  @Override
  public void validate(String cron) {
    var splitCron = cron.split(" ");
    if (splitCron.length != 5) throw new InvalidCronSyntaxException();

    validateMinute(splitCron[0]);
    validateHour(splitCron[1]);
    validateDayOfTheMonth(splitCron[2]);
    validateMonth(splitCron[3]);
    validateDayOfTheWeek(splitCron[4]);
  }

  private void validateMinute(String minuteCron) {
    validatorPool.minuteValidator().validate(minuteCron);
  }

  private void validateHour(String hourCron) {
    validatorPool.hourValidator().validate(hourCron);
  }

  private void validateDayOfTheMonth(String dayOfTheMonthCron) {
    validatorPool.dayOfTheMonthValidator().validate(dayOfTheMonthCron);
  }

  private void validateMonth(String monthCron) {
    validatorPool.monthValidator().validate(monthCron);
  }

  private void validateDayOfTheWeek(String dayOfTheWeekCron) {
    validatorPool.dayOfTheWeekValidator().validate(dayOfTheWeekCron);
  }
}
