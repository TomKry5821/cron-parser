package pl.tk.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.tk.exception.CronValidationException;
import pl.tk.exception.InvalidCronSyntaxException;

class CronValidatorTest {

  CronValidator validator = new CronValidator();

  @Test
  void shouldNotThrowCronValidationException() {
    String cron = "* * * * *";

    validator.validate(cron);

    Assertions.assertDoesNotThrow(() -> new CronValidationException(""));
  }

  @Test
  void shouldThrowInvalidCronSyntaxException() {
    String cron = "* * * * * *";

    Assertions.assertThrows(InvalidCronSyntaxException.class, () -> validator.validate(cron));
  }

  @Test
  void shouldThrowInvalidSpecialCharacterException() {
    String cron = "Z * * * *";

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(cron));
  }

  @Test
  void shouldThrowInvalidMinuteRangeException() {
    String cron = "128 * * * *";

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(cron));
  }

  @Test
  void shouldThrowInvalidHourRangeException() {
    String cron = "5 30 * * *";

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(cron));
  }

  @Test
  void shouldThrowInvalidMonthDayRangeException() {
    String cron = "5 22 45 * *";

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(cron));
  }

  @Test
  void shouldThrowInvalidMonthRangeException() {
    String cron = "5 22 17 14 *";

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(cron));
  }

  @Test
  void shouldThrowInvalidWeekDayRangeException() {
    String cron = "5 22 17 11 8";

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(cron));
  }
}
