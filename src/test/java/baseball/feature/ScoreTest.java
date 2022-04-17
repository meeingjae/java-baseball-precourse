package baseball.feature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    NumberGenerator numberGenerator = new NumberGenerator(1, 3);
    Answer answer = new Answer(numberGenerator);
    Score score;

    @BeforeEach
    void before() {
        answer.getAnswer().clear();
        answer.getAnswer().put(0, 1);
        answer.getAnswer().put(1, 2);
        answer.getAnswer().put(2, 3);
        score = new Score(answer);
    }

    @DisplayName("Score - 3스트라이크 테스트")
    @Test
    void fullStrikeTest() {
        //given:
        String input = "123";

        //when:
        score.calculateScore(input);

        //when:
        assertThat(score.getStrikeCount())
                .isEqualTo(3);
    }

    @DisplayName("Score - 3볼 테스트")
    @Test
    void ballTest() {
        //given:
        String input = "312";

        //when:
        score.calculateScore(input);

        //when:
        assertThat(score.getBallCount())
                .isEqualTo(3);
    }

    @DisplayName("Score - 2볼 1스트라이크 테스트")
    @Test
    void ballStrikeTest() {
        //given:
        String input = "132";

        //when:
        score.calculateScore(input);

        //when:
        assertThat(score.getBallCount())
                .isEqualTo(2);
        assertThat(score.getStrikeCount())
                .isEqualTo(1);
    }

    @DisplayName("Score - 낫싱 테스트")
    @Test
    void nothingTest() {
        //given:
        String input = "456";

        //when:
        score.calculateScore(input);

        //when:
        assertThat(score.getBallCount())
                .isEqualTo(0);
        assertThat(score.getStrikeCount())
                .isEqualTo(0);
    }
}
