package pl.tk.utils;

import java.util.regex.Pattern;

public class CronExpanderUtils {
  public static final String DASH_REGEX = "^(\\d{1,2})-(\\d{1,2})$";
  public static final Pattern DASH_PATTERN = Pattern.compile(DASH_REGEX);
  public static final String COMMA_REGEX = "^\\d{1,2}(?:,\\d{1,2})*$";
  public static final Pattern COMMA_PATTERN = Pattern.compile(COMMA_REGEX);
  public static final String SLASH_REGEX = "^(\\d{1,2}|\\*|\\d{1,2}-\\d{1,2})\\/(\\d{1,2})$";
  public static final Pattern SLASH_PATTERN = Pattern.compile(SLASH_REGEX);

  private CronExpanderUtils() {}
}
