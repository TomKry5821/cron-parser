package pl.tk.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class HourExpanderTest {

  HourExpander expander = new HourExpander();

  @Test
  void shouldExpandAllHours() {
    var expectedSize = 24;
    var cron = "*";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
  }

  @Test
  void shouldExpandRangeHours() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1-6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandCommaHours() {
    var expectedContent = List.of(1, 2, 3, 4, 5, 6);
    var expectedSize = 6;
    var cron = "1,2,3,4,5,6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashHoursWithAllValues() {
    var expectedContent = List.of(0, 6, 12, 18);
    var expectedSize = 4;
    var cron = "*/6";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }

  @Test
  void shouldExpandSlashHours() {
    var expectedContent = List.of(0, 5, 10, 15, 20);
    var expectedSize = 5;
    var cron = "0-20/5";

    var result = expander.expand(cron);

    Assertions.assertEquals(result.size(), expectedSize);
    Assertions.assertEquals(result, expectedContent);
  }
}
