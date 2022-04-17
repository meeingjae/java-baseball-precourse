package baseball.feature;

import baseball.handler.CustomHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 야구 게임
 * TODO: 다른 종류의 게임 구현 시 추상화 필요
 */
public class Game {

    private static final int NUMBER_OF_DIGIT = 3;
    private static final String RESTART = "1";
    private static final String END = "2";

    private boolean isContinue = true;
    private Answer answer;

    /**
     * @return 게임 재시작 여부
     */
    public boolean getIsContinue() {
        return this.isContinue;
    }

    /**
     * 게임 시작
     */
    public void startGame() {
        startGame(NUMBER_OF_DIGIT);
    }

    /**
     * 특정 자리 수를 받아 게임 시작
     *
     * @param number 게임 자리 수
     */
    public void startGame(int number) {
        answer = new Answer(number); // 난수 생성
        boolean isWrongAnswer = true;
        while (isWrongAnswer) {
            isWrongAnswer = progress(answer); // 게임 진행
        }
    }

    /**
     * 게임 재시작 및 종료
     */
    public void gameEndCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        if (input.equals(END) || !input.equals(RESTART)) { // 게임 재시작 여부 판단
            isContinue = false;
        }
    }

    /**
     * 게임 초기화
     */
    public void resetGame() {
        this.answer = null;
    }

    private boolean progress(Answer answer) {
        String input = input();
        CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT); // 유효성 검사
        Score score = new Score(answer);
        score.calculateScore(input); // 점수 계산
        score.resetScore();
        return score.getIsWrongAnswer();
    }

    private String input() {
        System.out.println("please input 3 digit of number");
        return Console.readLine();  // 사용자 입력
    }
}
