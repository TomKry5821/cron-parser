package pl.tk.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tk.exception.CronValidationException;

class DayOfTheMonthValidatorTest {
  DayOfTheMonthValidator validator = new DayOfTheMonthValidator();

  @ParameterizedTest
  @ValueSource(
      strings = {
        "61",
        "100",
        "222",
        "12-70",
        "12,23,90",
        "156/33",
        "32/23",
        "()",
        "A",
        ":",
        "12/G",
        "#5$",
        "1,2,4.5"
      })
  void shouldThrowCronValidationException(String day) {

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(day));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "1",
        "21",
        "31",
        "12-27",
        "12,23,28",
        "12/5",
        "20/8",
        "12,25-28,31",
        "*/15",
        "1,2,4,5-6"
      })
  void shouldNotThrowCronValidationException(String day) {

    Assertions.assertDoesNotThrow(() -> validator.validate(day));
  }
}
