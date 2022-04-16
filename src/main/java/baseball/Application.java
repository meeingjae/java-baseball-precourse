package baseball;

import baseball.feature.Game;

public class Application {

    public static void main(String[] args) {
        Game baseBallGame = new Game();
        while (baseBallGame.getIsContinue()) {
            baseBallGame.startGame();
            baseBallGame.gameEndCheck();
        }
    }
}
