package bowling.domain.score;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static java.util.Optional.of;

public class Score {
    private Integer score;

    private Score(int score) {
        this.score = of(score).filter(Score::isValidScore).orElseThrow(() -> new IllegalArgumentException("점수는 1~10사이만 허용됩니다."));
    }

    public static Score in(int score) {
        return new Score(score);
    }

    private static boolean isValidScore(Integer score) {
        return MIN_SCORE <= score && score <= MAX_SCORE;
    }

    public boolean validTotalScore(Score score) {
        int totalScore = this.score + score.get();
        return isValidScore(totalScore);
    }

    public Integer get() {
        return score;
    }
}
