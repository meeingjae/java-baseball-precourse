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

    private final HashMap<Integer, Integer> answer = new HashMap<>();
    private NumberGenerator numberGenerator = new NumberGenerator(MIN,MAX);

    /**
     * 정답의 기본 생성자 (기본 값=3)
     */
    public Answer() {
        this(DEFAULT);
    }

    /**
     * 특정 자릿수를 받아 정답 생성
     *
     * @param number 정답 자릿수
     */
    public Answer(int number) {
        makeAnswer(number);
    }

    /**
     * 기본 생성자 + 난수 생성기 주입
     *
     * @param numberGenerator 난수 생성기 주입
     */
    public Answer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        makeAnswer(DEFAULT);
    }

    /**
     * @return 정답
     */
    public HashMap<Integer, Integer> getAnswer() {
        return this.answer;
    }

    private void makeAnswer(int number) {
        for (int i = 0; i < number; i++) {
            this.answer.put(i, makeNumber());
        }
    }

    private int makeNumber() {
        int value = numberGenerator.generate(); // 난수 생성
        if (this.answer.containsValue(value)) {
            return makeNumber(); // 중복된 값이 생성 될 경우, 재생성
        }
        return value;
    }
}
