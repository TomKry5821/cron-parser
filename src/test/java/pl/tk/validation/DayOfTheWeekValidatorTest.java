package pl.tk.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tk.exception.CronValidationException;

class DayOfTheWeekValidatorTest {
  DayOfTheWeekValidator validator = new DayOfTheWeekValidator();

  @ParameterizedTest
  @ValueSource(
      strings = {
        "61",
        "100",
        "222",
        "10-70",
        "12,23,90",
        "12/33",
        "32/23",
        "()",
        "A",
        ":",
        "6 /G",
        "#5$",
        "1,2,4.5"
      })
  void shouldThrowCronValidationException(String month) {

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(month));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {"1", "5", "6", "2-5", "1,2,4", "3/5", "2/4", "1,2-4,5", "1/3", "1,2,4,5-6"})
  void shouldNotThrowCronValidationException(String day) {

    Assertions.assertDoesNotThrow(() -> validator.validate(day));
  }
}
