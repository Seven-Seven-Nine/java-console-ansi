package org.sevensevennine.console;

import java.util.Map;

/**
 * Возвращает модифицированный текст с ANSI-кодами стиля и цвета. 
 */
public class ANSI {
  private static String ANSIResetCode = "\033[0m";
  
  private static Map<String, String> ANSIColorCodes = Map.of(
    "black", "\033[30m",
    "red", "\033[31m",
    "green", "\033[32m",
    "yellow", "\033[33m",
    "blue", "\033[34m",
    "magenta", "\033[35m",
    "cyan", "\033[36m",
    "white", "\033[37m",
    "gray", "\033[90m"
  );

  private static Map<String, String> ANSIStyleCodes = Map.of(
    "normal", "",
    "bold", "\033[1m",
    "dim", "\033[2m",
    "italic", "\033[3m",
    "underline", "\033[4m"  
  );

  /**
   * Возвращает текст с ANSI-кодами цвета и стиля.
   * Доступные цвета: "black", "red", "green", "yellow", "blue", "magenta", "cyan", "white", "gray".
   * Доступные стили: "normal", "bold", "dim", "italic", "underline".
   * @param text Текст, к который будет модифицирован и возвращён обратно.
   * @param color Название цвета, который будет применён к тексту в формате ANSI-кода.
   * @param style Название стиля, который будет применён к тексту в формате ANSI-кода.
   * @return Модифицированный текст с ANSI-кодами цвета и стиля.
   */
  public static String colored(String text, String color, String style) {
    boolean checkingColorName = false;
    boolean checkingStyleName = false;

    if (ANSIColorCodes.containsKey(color)) checkingColorName = true;
    if (ANSIStyleCodes.containsKey(style)) checkingStyleName = true;

    if (checkingColorName && checkingStyleName) {
        return ANSIStyleCodes.get(style) + ANSIColorCodes.get(color) + text + ANSIResetCode;
      } else {
        if (checkingColorName) System.out.printf("Java ANSI: цвет \"%s\" недоступен для применения.", color);
        if (checkingStyleName) System.out.printf("Java ANSI: стиль \"%s\" недоступен для применения.", style);
        return text;
    }
  }
}
