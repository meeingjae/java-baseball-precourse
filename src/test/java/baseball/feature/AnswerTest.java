package baseball.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @DisplayName("Answer 클래스 중복 데이터 생성 테스트")
    @Test
    void answerDuplicationTest() {
        //given:
        Map<Integer, Integer> map = new Answer().getAnswer();
        //when:
        Set<Integer> set = new HashSet<>(map.values());
        //then:
        assertThat(set)
                .hasSize(3);
    }

    @DisplayName("Answer 클래스 난수 생성 테스트")
    @Test
    void numberOfAnswerTest() {
        //given:
        Map<Integer, Integer> map = new Answer(5).getAnswer();
        //when:
        Set<Integer> set = new HashSet<>(map.values());
        //then:
        assertThat(set)
                .hasSize(5);
    }
}
