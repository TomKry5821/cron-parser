package pl.tk.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tk.exception.CronValidationException;

class MinuteValidatorTest {

  MinuteValidator validator = new MinuteValidator();

  @ParameterizedTest
  @ValueSource(
      strings = {
        "?",
        "A",
        ":",
        "12/G",
        "#5?",
        "1,2,4.5",
        "61",
        "100",
        "222",
        "12-70",
        "12,50,90",
        "80/67"
      })
  void shouldThrowCronValidationException(String minute) {

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(minute));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {
        "1",
        "12",
        "55",
        "23-51",
        "1,2,43",
        "15/20",
        "2/4",
        "1,2-45,50",
        "34/3",
        "1,2,4,5-16"
      })
  void shouldNotThrowCronValidationException(String minute) {

    Assertions.assertDoesNotThrow(() -> validator.validate(minute));
  }
}
