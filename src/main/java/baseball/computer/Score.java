package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

public class Score {

    private final int MIN = 1;
    private final int MAX = 9;

    private final int score;

    public Score() {
        this.score = Randoms.pickNumberInRange(MIN, MAX);
    }
}
