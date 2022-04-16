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
        //TODO : Refactoring
        Map<Integer, Integer> answer = new Answer(NUMBER_OF_DIGIT).getAnswer();
        boolean isWrongAnswer = true;

        while (isWrongAnswer){
            System.out.println("please input 3 digit of number");
            String input = Console.readLine();

            CustomHandler.invalidCheck(input, NUMBER_OF_DIGIT);

            int ballCount = 0;
            int strikeCount = 0;

            for (int i = 0; i < input.length(); i++) {
                int value = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (answer.get(i).equals(value)) {
                    strikeCount++;
                } else if (answer.containsValue(value)) {
                    ballCount++;
                }
            }

            if (strikeCount == answer.size()) {
                System.out.println(strikeCount+"스트라이크");
                System.out.println(answer.size()+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isWrongAnswer = false;
            } else if (ballCount + strikeCount == 0) {
                System.out.println("낫싱");
            } else if (ballCount != 0 && strikeCount != 0) {
                System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
            } else if (ballCount != 0 && strikeCount == 0) {
                System.out.println(ballCount+"볼");
            } else if (ballCount == 0 && strikeCount != 0) {
                System.out.println(strikeCount+"스트라이크");
            }
        }
    }

    private static void gameEndCheck() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        if (input.equals(END) || !input.equals(RESTART)) {
            isContinue = false;
        }
    }
}
