package bowling.domain;

import java.util.HashMap;
import java.util.Map;

import static bowling.utils.BowlingUtils.FIRST_SCORE;
import static bowling.utils.BowlingUtils.SECOND_SCORE;

public class FrameElement {
    private Map<String, Score> scoreMap = new HashMap<>();

    public FrameElement(Score score) {
        scoreMap.put(FIRST_SCORE, score);
    }

    public static FrameElement generate(Score score) {
        return new FrameElement(score);
    }

    public boolean canNextRound(Score secondScore) {
        return scoreMap.get(FIRST_SCORE).checkNextScore(secondScore);
    }

    public FrameElement inScore(Score secondScore) {
        scoreMap.put(SECOND_SCORE, secondScore);
        return this;
    }

    public Integer getFirstScore() {
        return scoreMap.get(FIRST_SCORE).get();
    }

    public Integer getSecondScore() {
        return scoreMap.get(SECOND_SCORE).get();
    }
}