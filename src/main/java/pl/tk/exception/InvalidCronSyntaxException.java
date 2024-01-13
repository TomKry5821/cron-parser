package pl.tk.exception;

public class InvalidCronSyntaxException extends CronValidationException {

  private static final String MESSAGE = "Provided cron has incorrect syntax";

  public InvalidCronSyntaxException() {
    super(MESSAGE);
  }
}
