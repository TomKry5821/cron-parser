package pl.tk.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MonthExpanderTest {
  MonthExpander expander = new MonthExpander();

  @Test
  void shouldExpandAllMonths() {
    var expectedSize = 12;
    var cron = "*";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
  }

  @Test
  void shouldExpandRangeMonths() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1-6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandCommaMonths() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1,2,3,4,5,6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashMonthsWithAllValues() {
    var expectedContent = List.of(0, 4, 8);
    var expectedSize = 3;
    var cron = "*/4";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashMonths() {
    var expectedContent = List.of(0, 5, 10);
    var expectedSize = 3;
    var cron = "0-12/5";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }
}
