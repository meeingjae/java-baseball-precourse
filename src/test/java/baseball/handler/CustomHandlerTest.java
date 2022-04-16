package baseball.handler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomHandlerTest {

    final int NUMBER_OF_DIGIT = 3;
    Exception exception = new Exception();

    @DisplayName("CustomHandler - 사용자 입력 값에 숫자가 아닌 값이 포함 된 경우")
    @Test
    void inputFormatCheckTest() {
        //given:
        String input = "12a";

        //when:
        try {
            CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        //then:
        assertThat(exception)
                .hasMessage("please enter a number");
    }

    @DisplayName("CustomHandler - 중복 값을 입력한 경우")
    @Test
    void duplicationCheckTest() {
        //given:
        String input = "122";

        //when:
        try {
            CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        //then:
        assertThat(exception)
                .hasMessage("please enter different numbers");
    }

    @DisplayName("CustomHandler - 입력해야 하는 값보다 더 많은 값을 입력한 경우")
    @Test
    void numberOfInputCheckTest() {
        //given:
        String input = "12345";

        //when:
        try {
            CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        //then:
        assertThat(exception)
                .hasMessage("please enter 3 number");
    }
}
