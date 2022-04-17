package baseball.feature;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 난수 생성기
 */
public class NumberGenerator {

    private final int min;
    private final int max;

    /**
     * @param min 최소 값
     * @param max 최대 값
     */
    public NumberGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * @return 난수 생성
     */
    public int generate() {
        return Randoms.pickNumberInRange(min, max);
    }
}
