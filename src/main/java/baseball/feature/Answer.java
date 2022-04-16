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
    private int strikeCount;
    private int ballCount;
    private boolean isWrongAnswer = true;

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

    public boolean getIsWrongAnswer() {
        return this.isWrongAnswer;
    }

    private int makeNumber() {
        int value = Randoms.pickNumberInRange(MIN, MAX);
        if (this.answer.containsValue(value)) {
            return makeNumber();
        }
        return value;
    }

    public void calculateScore(String input) {
        for (int i = 0; i < input.length(); i++) {
            int value = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (answer.get(i).equals(value)) {
                strikeCount++;
            } else if (answer.containsValue(value)) {
                ballCount++;
            }
        }
        printScore();
    }

    private void printScore() {
        isCorrect();
        isNothing();
        isBallAndStrike();
        isBall();
        isStrike();
    }

    private void isCorrect() {
        if (strikeCount == answer.size()) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println(answer.size() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isWrongAnswer = false;
        }
    }

    private void isNothing() {
        if (ballCount + strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    private void isBallAndStrike() {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            resetScore();
        }
    }

    private void isBall() {
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
            resetScore();
        }
    }

    private void isStrike() {
        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
            resetScore();
        }
    }

    private void resetScore() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }
}
