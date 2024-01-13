package pl.tk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest {

  @ParameterizedTest
  @ValueSource(
      strings = {
        "* * * * *",
        "1 1 1 1 1",
        "1-30 1-22 3-5 1-4 1-5",
        "1,2,3 1,2,3 3,4,5 1,5,6 2,3",
        "*/10 */8 */5 */3 */2",
        "1/15 1-12 4,5,6 12 *"
      })
  void shouldNotThrowException(String cron) {
    Assertions.assertDoesNotThrow(() -> Main.main(new String[] {cron}));
  }
}
