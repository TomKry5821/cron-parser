package pl.tk.expander;

import java.util.List;

class HourExpander implements CronExpander {

  private static final List<Integer> POSSIBLE_VALUES =
      List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);

  @Override
  public List<Integer> getPossibleValues() {
    return POSSIBLE_VALUES;
  }

  @Override
  public int getMaxValue() {
    return 23;
  }
}
