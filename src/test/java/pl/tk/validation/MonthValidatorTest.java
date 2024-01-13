package pl.tk.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.tk.exception.CronValidationException;

class MonthValidatorTest {
  MonthValidator validator = new MonthValidator();

  @ParameterizedTest
  @ValueSource(
      strings = {
        "61",
        "100",
        "222",
        "10-70",
        "12,23,90",
        "14/33",
        "32/23",
        "()",
        "A",
        ":",
        "12/G",
        "#5$",
        "1,2,4.5"
      })
  void shouldThrowCronValidationException(String month) {

    Assertions.assertThrows(CronValidationException.class, () -> validator.validate(month));
  }

  @ParameterizedTest
  @ValueSource(
      strings = {"1", "6", "11", "6-9", "1,2,4", "6/2", "2/4", "1,2-5,9", "8/3", "1,2,4,5-9"})
  void shouldNotThrowCronValidationException(String month) {

    Assertions.assertDoesNotThrow(() -> validator.validate(month));
  }
}
