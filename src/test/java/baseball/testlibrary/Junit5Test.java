package baseball.testlibrary;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5Test {

    @DisplayName("JUnit5 - Parameterized - Integer value test")
    @ParameterizedTest(name = "{displayName} - {index} : {0}")
    @ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE })
    void isOddTest(int number) {
        assertTrue(isOdd(number));
    }

    @DisplayName("JUnit5 - Parameterized - null and empty annotation test")
    @ParameterizedTest(name = "{displayName} - {index} : {0}")
    @NullAndEmptySource
    void isBlinkTest(String str) {
        assertTrue(isBlink(str));
    }

    @DisplayName("JUnit5 - Parameterized - enum test")
    @ParameterizedTest(name = "{displayName} - {index} : {0}")
    @EnumSource(Sex.class)
    void enumTest(Sex sex) {
        //given:
        String name;
        //when:
        name = sex.name();
        //then:
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
