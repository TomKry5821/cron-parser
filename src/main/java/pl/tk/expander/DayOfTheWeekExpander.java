package pl.tk.expander;

import java.util.List;

class DayOfTheWeekExpander implements CronExpander {

  private static final List<Integer> POSSIBLE_VALUES = List.of(0, 1, 2, 3, 4, 5, 6);

  @Override
  public List<Integer> getPossibleValues() {
    return POSSIBLE_VALUES;
  }

  @Override
  public int getMaxValue() {
    return 6;
  }
}
