package baseball.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @DisplayName("NumberGenerator - 한 자리 수 생성 테스트")
    @Test
    void generateSingleTest() {
        //given:
        NumberGenerator numberGenerator = new NumberGenerator(1, 9);

        //when:
        List<Integer> numberList = Arrays.asList(
                numberGenerator.generate(),
                numberGenerator.generate(),
                numberGenerator.generate());

        //then:
        assertThat(numberList)
                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @DisplayName("NumberGenerator - 세 자리 수 생성 테스트")
    @Test
    void generateTrebleFigureTest() {
        //given:
        NumberGenerator numberGenerator = new NumberGenerator(100, 103);

        //when:
        List<Integer> numberList = Arrays.asList(
                numberGenerator.generate(),
                numberGenerator.generate(),
                numberGenerator.generate());

        //then:
        assertThat(numberList)
                .containsAnyOf(100, 101, 102, 103);
    }
}
