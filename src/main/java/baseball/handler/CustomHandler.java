package baseball.handler;

import java.util.HashSet;
import java.util.Set;

/**
 * Custom Exception Handler
 */
public class CustomHandler {

    /**
     * 사용자 입력 값 유효성 검사
     *
     * @param input         사용자 입력 값
     * @param numberOfDigit 사용자 입력 갯수
     */
    public static void invalidCheck(String input, int numberOfDigit) {
        inputFormatCheck(input);
        duplicationCheck(input);
        numberOfInputCheck(input, numberOfDigit);
    }

    /**
     * 사용자 입력 값에 숫자가 아닌 값이 포함 된 경우
     *
     * @param input 사용자 입력 값
     */
    private static void inputFormatCheck(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("please enter a number");
        }
    }

    /**
     * 중복 값을 입력한 경우
     *
     * @param input 사용자 입력 값
     */
    private static void duplicationCheck(String input) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            characters.add(input.charAt(i));
        }
        if (characters.size() < input.length()) {
            throw new IllegalArgumentException("please enter different numbers");
        }
    }

    /**
     * 입력해야 하는 값보다 더 많은 값을 입력한 경우
     *
     * @param input         사용자 입력 값
     * @param numberOfDigit 사용자 입력 갯수
     */
    private static void numberOfInputCheck(String input, int numberOfDigit) {
        if (input.length() != numberOfDigit) {
            throw new IllegalArgumentException("please enter " + numberOfDigit + " number");
        }
    }
}
