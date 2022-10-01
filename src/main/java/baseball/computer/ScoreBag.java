package baseball.computer;

import java.util.ArrayList;
import java.util.List;

public class ScoreBag {

    private final List<Score> scores;

    public ScoreBag() {
        scores = new ArrayList<>();
        int MAX_SIZE = 3;
        for (int i = 0; i < MAX_SIZE; i++) {
            this.scores.add(new Score());
        }
    }

    public ScoreBag(List<Score> scores) {
        this.scores = scores;
    }

    public static ScoreBag makeScoreBag(int[] inputs) {
        List<Score> scores = new ArrayList<>();
        for(int input : inputs) {
            scores.add(new Score(input));
        }
        return new ScoreBag(scores);
    }
}
