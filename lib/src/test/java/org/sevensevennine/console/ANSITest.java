package org.sevensevennine.console;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ANSITest {
  @Test void testColoredWithValidParameters() {
        String result = ANSI.colored("Test", "green", "bold");
        
        assertTrue(result.startsWith("\033["));
        assertTrue(result.contains("Test"));
        assertTrue(result.endsWith("\033[0m"));
    }

    @Test void testColoredWithInvalidColor() {
        String result = ANSI.colored("Test", "invalid", "bold");
        assertEquals("Test", result);
    }

    @Test void testColoredWithInvalidStyle() {
        String result = ANSI.colored("Test", "green", "invalid");
        assertEquals("Test", result);
    }
}
