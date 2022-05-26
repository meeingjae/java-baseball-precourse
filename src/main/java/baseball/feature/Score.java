package baseball.feature;

/**
 * 점수
 */
public class Score {

    private final Answer answer;
    private int strikeCount;
    private int ballCount;
    private boolean isWrongAnswer = true;

    /**
     * @param answer 정답
     */
    public Score(Answer answer) {
        this.answer = answer;
    }

    /**
     * @return 오답 여부 반환
     */
    public boolean getIsWrongAnswer() {
        return this.isWrongAnswer;
    }

    /**
     * @return 스트라이크 카운트 반환
     */
    public int getStrikeCount() {
        return this.strikeCount;
    }

    /**
     * @return 볼 카운트 반환
     */
    public int getBallCount() {
        return this.ballCount;
    }

    /**
     * @param input 사용자 입력
     */
    public void calculateScore(String input) {
        for (int i = 0; i < input.length(); i++) {
            calculateScore(input, i);
        }
        printScore();
    }

    /**
     * 점수 초기화
     */
    public void resetScore() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    private void calculateScore(String input, int num) {
        int inputNum = Integer.parseInt(String.valueOf(input.charAt(num)));
        plusStrikeCount(inputNum, num);
        plusBallCount(inputNum, num);
    }

    private void plusStrikeCount(int inputNum, int num) {
        if (isStrike(inputNum, num)) {
            strikeCount++;
        }
    }

    private void plusBallCount(int inputNum, int num) {
        if (isBall(inputNum, num)) {
            ballCount++;
        }
    }

    private boolean isStrike(int inputNum, int num) {
        return answer.getAnswer().get(num).equals(inputNum);
    }

    private boolean isBall(int inputNum, int num) {
        return !(answer.getAnswer().get(num).equals(inputNum))
                && answer.getAnswer().containsValue(inputNum);
    }

    private void printScore() {
        isCorrect();
        isNothing();
        isBallAndStrike();
        isBall();
        isStrike();
    }

    private void isCorrect() {
        if (strikeCount == answer.getAnswer().size()) {
            System.out.println(strikeCount + "스트라이크");
            System.out.println(answer.getAnswer().size() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        }
    }

    private void isBall() {
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
    }

    private void isStrike() {
        if (!(strikeCount == answer.getAnswer().size())
                && ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }
}
