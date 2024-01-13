package pl.tk.service;

import java.util.List;

public class DayOfTheMonthExpander implements CronExpander {

  private static final List<Integer> POSSIBLE_VALUES =
      List.of(
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
          26, 27, 28, 29, 30, 31);

  @Override
  public List<Integer> getPossibleValues() {
    return POSSIBLE_VALUES;
  }

  @Override
  public int getMaxValue() {
    return 31;
  }
}
