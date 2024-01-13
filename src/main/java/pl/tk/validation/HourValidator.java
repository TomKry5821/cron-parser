package pl.tk.validation;

import java.util.regex.Pattern;
import pl.tk.exception.CronValidationException;

class HourValidator implements Validator {
  private static final String REGEX =
      "^(\\*|(?:[01]?[0-9]|2[0-3])(?:-(?:[01]?[0-9]|2[0-3]))?)(/[1-9][0-9]*)?(,(\\*|(?:[01]?[0-9]|2[0-3])(?:-(?:[01]?[0-9]|2[0-3]))?)(/[1-9][0-9]*)?)*$";
  private static final Pattern PATTERN = Pattern.compile(REGEX);

  @Override
  public void validate(String minute) {
    var matcher = PATTERN.matcher(minute);
    if (!matcher.matches()) {
      throw new CronValidationException("Invalid hour part");
    }
  }
}
