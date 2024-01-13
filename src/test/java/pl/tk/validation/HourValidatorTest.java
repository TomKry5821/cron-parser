package pl.tk.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tk.exception.CronValidationException;

class HourValidatorTest {
  HourValidator validator = new HourValidator();

  @ParameterizedTest
  @ValueSource(
      strings = {
        "61",
        "100",
        "222",
        "12-70",
        "12,23,90",
        "100/30",
        "?",
        "A",
        ":",
        "12/G",
        "#5?",
        "1,2,4.5"
      })
  void shouldThrowCronValidationException(String hour) {

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(hour));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {"1", "12", "21", "2-5", "1,2,23", "3/5", "2/4", "1,2-4,5", "1/3", "1,2,4,5-6"})
  void shouldNotThrowCronValidationException(String hour) {

    Assertions.assertDoesNotThrow(() -> validator.validate(hour));
  }
}
