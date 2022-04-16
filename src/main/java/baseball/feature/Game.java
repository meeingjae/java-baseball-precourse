package baseball.feature;

import baseball.handler.CustomHandler;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final int NUMBER_OF_DIGIT = 3; // 세 자릿수 게임 (변경 가능)
    private static final String RESTART = "1";
    private static final String END = "2";

    private boolean isContinue = true;

    public boolean getIsContinue() {
        return this.isContinue;
    }

    public void startGame() {
        Answer answer = new Answer(NUMBER_OF_DIGIT); // 난수 생성
        boolean isWrongAnswer = true;
        while (isWrongAnswer) {
            String input = input(); // 사용자 입력
            CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT); // 유효성 검사
            Score score = new Score(answer);
            score.calculateScore(input); // 점수 계산
            isWrongAnswer = score.getIsWrongAnswer(); // 반복 여부 판단
        }
    }

    public void gameEndCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        if (input.equals(END) || !input.equals(RESTART)) { // 게임 재시작 여부 판단
            isContinue = false;
        }
    }

    private String input() {
        System.out.println("please input 3 digit of number");
        return Console.readLine();  // 사용자 입력
    }
}
