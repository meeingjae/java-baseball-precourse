package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5Test {

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE })
    void isOddTest(int number) {
        assertTrue(isOdd(number));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isBlinkTest(String str) {
        assertTrue(isBlink(str));
    }

    @ParameterizedTest
    @EnumSource(Sex.class)
    void enumTest(Sex sex) {
        String name = sex.name();
        assertTrue(name.equals("MALE") || name.equals("FEMALE"));
    }

    boolean isOdd(int number) {
        return number % 2 != 0;
    }

    boolean isBlink(String str) {
        return str == null || str.trim().isEmpty();
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
