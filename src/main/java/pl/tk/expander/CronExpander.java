package pl.tk.expander;

import static pl.tk.utils.CronExpanderUtils.COMMA_PATTERN;
import static pl.tk.utils.CronExpanderUtils.DASH_PATTERN;
import static pl.tk.utils.CronExpanderUtils.SLASH_PATTERN;

import java.util.ArrayList;
import java.util.List;

public interface CronExpander {
  List<Integer> getPossibleValues();

  int getMaxValue();

  default List<Integer> expand(String cron) {
    if (cron.equals("*")) return new ArrayList<>(getPossibleValues());

    var dashMatcher = DASH_PATTERN.matcher(cron);
    if (dashMatcher.find()) {
      return range(Integer.parseInt(dashMatcher.group(1)), Integer.parseInt(dashMatcher.group(2)));
    }

    var commaMatcher = COMMA_PATTERN.matcher(cron);
    if (commaMatcher.find()) {
      return collect(cron);
    }

    var slashMatcher = SLASH_PATTERN.matcher(cron);
    if (slashMatcher.find()) {
      var startValue = slashMatcher.group(1);
      var currentValues =
          (startValue.equals("*") || startValue.contains("-"))
              ? expand(startValue)
              : range(Integer.parseInt(startValue), getMaxValue());
      var interval = Integer.parseInt(slashMatcher.group(2));
      return collectWithInterval(currentValues, interval);
    }

    return List.of(Integer.parseInt(cron));
  }

  default List<Integer> range(int min, int max) {
    var result = new ArrayList<Integer>(max - min + 1);
    for (int i = min; i <= max; i++) {
      result.add(i);
    }

    return result;
  }

  default List<Integer> collect(String cron) {
    var values = cron.split(",");
    var result = new ArrayList<Integer>(values.length);

    for (String v : values) {
      result.add(Integer.parseInt(v));
    }

    return result;
  }

  default List<Integer> collectWithInterval(List<Integer> currentValues, int interval) {
    var result = new ArrayList<Integer>();

    for (int i = 0; i < currentValues.size(); i += interval) {
      result.add(currentValues.get(i));
    }

    return result;
  }
}
