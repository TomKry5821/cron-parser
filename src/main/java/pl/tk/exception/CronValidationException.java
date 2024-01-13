package pl.tk.exception;

public class CronValidationException extends RuntimeException {

  public CronValidationException(String message) {
    super(message);
  }
}
