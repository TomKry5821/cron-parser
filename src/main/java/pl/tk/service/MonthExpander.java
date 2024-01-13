package pl.tk.service;

import java.util.List;

public class MonthExpander implements CronExpander {

  private static final List<Integer> POSSIBLE_VALUES =
      List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

  @Override
  public List<Integer> getPossibleValues() {
    return POSSIBLE_VALUES;
  }

  @Override
  public int getMaxValue() {
    return 11;
  }
}
