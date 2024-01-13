package pl.tk;

import pl.tk.exception.CronValidationException;
import pl.tk.expander.ExpandedCron;
import pl.tk.validation.CronValidator;

public class Main {
  public static void main(String[] args) {
    String cron = args[0];
    try {
      validateCron(cron);
    } catch (CronValidationException e) {
      System.err.printf("Something went wrong, message: %s", e.getMessage());
      return;
    }

    System.out.println(expandCron(cron));
  }

  private static void validateCron(String cron) {
    var validator = new CronValidator();
    validator.validate(cron);
  }

  private static ExpandedCron expandCron(String cron) {
    var splitCron = cron.split(" ");
    return new ExpandedCron(splitCron[0], splitCron[1], splitCron[2], splitCron[3], splitCron[4]);
  }
}
