package pl.tk.expander;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class MinuteExpanderTest {
  MinuteExpander expander = new MinuteExpander();

  @Test
  void shouldExpandAllMinutes() {
    var expectedSize = 60;
    var cron = "*";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
  }

  @Test
  void shouldExpandRangeMinutes() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1-6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandCommaMinutes() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1,2,3,4,5,6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashMinutesWithAllValues() {
    var expectedContent = List.of(0, 15, 30, 45);
    var expectedSize = 4;
    var cron = "*/15";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashMinutes() {
    var expectedContent = List.of(0, 5, 10, 15, 20);
    var expectedSize = 5;
    var cron = "0-20/5";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }
}
