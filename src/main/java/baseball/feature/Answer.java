package baseball.feature;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

/**
 * 정답
 */
public class Answer {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int DEFAULT = 3;

    private final HashMap<Integer, Integer> answer;

    public Answer() {
        this(DEFAULT);
    }

    public Answer(Integer number) {
        answer = new HashMap<>();
        for (int i = 0; i < number; i++) {
            this.answer.put(i, makeNumber());
        }
    }

    public HashMap<Integer, Integer> getAnswer() {
        return this.answer;
    }

    private int makeNumber() {
        int value = Randoms.pickNumberInRange(MIN, MAX);
        if (this.answer.containsValue(value)) {
            return makeNumber();
        }
        return value;
    }
}
