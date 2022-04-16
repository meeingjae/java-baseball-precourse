package baseball;

import baseball.feature.Answer;
import baseball.handler.CustomHandler;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

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
        Map<Integer, Integer> answer = new Answer(NUMBER_OF_DIGIT).getAnswer();

        System.out.println("please input 3 digit of number");
        String input = Console.readLine();

        CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT);
    }

    private static void gameEndCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals(END) || !input.equals(RESTART)) {
            isContinue = false;
        }
    }
}
