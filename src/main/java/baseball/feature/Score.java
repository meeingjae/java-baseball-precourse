package baseball.feature;

public class Score {

    private Answer answer;
    private int strikeCount;
    private int ballCount;
    private boolean isWrongAnswer = true;

    public Score(Answer answer) {
        this.answer = answer;
    }

    public boolean getIsWrongAnswer() {
        return this.isWrongAnswer;
    }

    public void calculateScore(String input) {
        for (int i = 0; i < input.length(); i++) {
            calculateScore(input, i);
        }
        printScore();
    }

    private void calculateScore(String input, int num) {
        int inputNum = Integer.parseInt(String.valueOf(input.charAt(num)));
        plusStrikeCount(inputNum, num);
        plusBallCount(inputNum, num);
    }

    private void plusStrikeCount(int inputNum, int num) {
        if (answer.getAnswer().get(num).equals(inputNum)) {
            strikeCount++;
        }
    }

    private void plusBallCount(int inputNum, int num) {
        if (!(answer.getAnswer().get(num).equals(inputNum))
                && answer.getAnswer().containsValue(inputNum)) {
            ballCount++;
        }
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
