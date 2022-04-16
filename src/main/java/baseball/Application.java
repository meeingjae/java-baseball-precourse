package baseball;

import baseball.feature.Answer;
import baseball.handler.CustomHandler;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int NUMBER_OF_DIGIT = 3;
    private static boolean isContinue = true;
    private static final String RESTART = "1";
    private static final String END = "2";

    public static void main(String[] args) {
        while (isContinue) {
            startGame();
            gameEndCheck();
        }
    }

    private static void startGame() {
        Answer answer = new Answer(NUMBER_OF_DIGIT);
        boolean isWrongAnswer = true;
        while (isWrongAnswer) {
            String input = input();
            CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT);
            answer.calculateScore(input);
            isWrongAnswer = answer.getIsWrongAnswer();
        }
    }

    private static void gameEndCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        if (input.equals(END) || !input.equals(RESTART)) {
            isContinue = false;
        }
    }

    private static String input() {
        System.out.println("please input 3 digit of number");
        return Console.readLine();
    }
}
