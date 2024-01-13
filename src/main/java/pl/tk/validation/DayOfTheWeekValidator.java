package pl.tk.validation;

import java.util.regex.Pattern;
import pl.tk.exception.CronValidationException;

class DayOfTheWeekValidator implements Validator {
  private static final String REGEX =
      "^(\\*|[0-6]|-?[1-6])(?:-(\\*|[0-6]|-?[1-6]))?(/[1-9][0-9]*)?(,(\\*|[0-6]|-?[1-6])(?:-(\\*|[0-6]|-?[1-6]))?(/[1-9][0-9]*)?)*$";
  private static final Pattern PATTERN = Pattern.compile(REGEX);

  @Override
  public void validate(String minute) {
    var matcher = PATTERN.matcher(minute);
    if (!matcher.matches()) {
      throw new CronValidationException("Invalid day part");
    }
  }
}
