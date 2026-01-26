package org.sevensevennine.javaansi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JavaANSITest {
    @Test void testColoredWithValidParameters() {
        String result = JavaANSI.colored("Test", "green", "bold");
        
        assertTrue(result.startsWith("\033["));
        assertTrue(result.contains("Test"));
        assertTrue(result.endsWith("\033[0m"));
    }

    @Test void testColoredWithInvalidColor() {
        String result = JavaANSI.colored("Test", "invalid", "bold");
        assertEquals("Test", result);
    }

    @Test void testColoredWithInvalidStyle() {
        String result = JavaANSI.colored("Test", "green", "invalid");
        assertEquals("Test", result);
    }
}
