package pl.tk.validation;

import java.util.regex.Pattern;
import pl.tk.exception.CronValidationException;

class DayOfTheMonthValidator implements Validator {
  private static final String REGEX =
      "^(\\*|[1-9]|1[0-9]|2[0-9]|3[01])(-[1-9]|-1[0-9]|-2[0-9]|-3[01])?(/[1-9][0-9]*)?(,(\\*|[1-9]|1[0-9]|2[0-9]|3[01])(-[1-9]|-1[0-9]|-2[0-9]|-3[01])?(/[1-9][0-9]*)?)*$";
  private static final Pattern PATTERN = Pattern.compile(REGEX);

  @Override
  public void validate(String minute) {
    var matcher = PATTERN.matcher(minute);
    if (!matcher.matches()) {
      throw new CronValidationException("Invalid month day part");
    }
  }
}
