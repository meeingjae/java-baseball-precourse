package baseball.missionutil;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

public class PickNumberInRangeTest {

    @DisplayName("pickNumberInRange - 난수 범위 테스트")
    @Test
    void pickNumberInRangeTest() {

        int number = pickNumberInRange(10, 20);

        assertThat(number)
                .isGreaterThan(10)
                .isLessThan(20);
    }

    @DisplayName("pickNumberInRange - 3개의 난수 생성 테스트")
    @Test
    void pickNumberInRangeListTest() {
        List<Integer> numberList = Arrays.asList(
                pickNumberInRange(1, 9)
                , pickNumberInRange(1, 9)
                , pickNumberInRange(1, 9));

        assertThat(numberList)
                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
