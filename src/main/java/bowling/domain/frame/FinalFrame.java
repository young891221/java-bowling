package bowling.domain.frame;

import bowling.domain.score.EntireScore;
import bowling.domain.score.Score;
import bowling.domain.score.ScoreType;

import static bowling.domain.ScoreMachine.convertScoreToString;

public class FinalFrame implements Frame {
    private EntireScore entireScore;
    private String result;

    private FinalFrame(Score score) {
        entireScore = entireScore.generate(score);
        result = convertScoreToString(entireScore);
    }

    public static FinalFrame generate(Score score) {
        return new FinalFrame(score);
    }

    @Override
    public boolean isEnd() {
        return entireScore.length() > 3 || (ScoreType.isDual(entireScore) && entireScore.beforeLastScore().get() != 10);
    }

    @Override
    public FinalFrame nextRound(Score nextScore) {
        result = convertScoreToString(entireScore.inScore(nextScore));
        return this;
    }

    @Override
    public String result() {
        return result;
    }

    @Override
    public EntireScore getElement() {
        return entireScore;
    }

}