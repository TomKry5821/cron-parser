package pl.tk.expander;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DayOfTheMonthExpanderTest {
  DayOfTheMonthExpander expander = new DayOfTheMonthExpander();

  @Test
  void shouldExpandAllDays() {
    var expectedSize = 31;
    var cron = "*";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
  }

  @Test
  void shouldExpandRangeDays() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1-6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandCommaDays() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1,2,3,4,5,6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashDaysWithAllValues() {
    var expectedContent = List.of(1, 7, 13, 19, 25, 31);
    var expectedSize = 6;
    var cron = "*/6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashDays() {
    var expectedContent = List.of(0, 5, 10, 15, 20);
    var expectedSize = 5;
    var cron = "0-20/5";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }
}
