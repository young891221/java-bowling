package bowling.domain;

import java.util.stream.IntStream;

import bowling.domain.frame.Frame;
import bowling.domain.frame.Frames;

import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_SCORE;
import static bowling.utils.StringUtils.BEGIN_FORMAT;
import static bowling.utils.StringUtils.DEFAULT_ING_FORMAT;
import static bowling.utils.StringUtils.EMPTY_FRAME;

public class Game {
    private Frames frames;
    private BowlingUser bowlingUser;

    public Game(BowlingUser bowlingUser) {
        this.bowlingUser = bowlingUser;
        frames = new Frames();
    }

    public static Game generate(BowlingUser bowlingUser) {
        return new Game(bowlingUser);
    }

    public String reflectView(Frame frame) {
        frames.addFrame(frame);
        return createView(frames.scoreView());
    }

    public String reflectFinalView(Frame frame) {
        frames.addFrame(frame);
        return initName() + frames.scoreView();
    }

    public String createView(String scoreView) {
        return initName() + scoreView + rightEmpty(frames.size());
    }

    public String rightEmpty(int ingLength) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(MIN_SCORE, MAX_SCORE-ingLength).forEach(i -> builder.append(String.format(DEFAULT_ING_FORMAT, EMPTY_FRAME)));
        return builder.toString();
    }

    private String initName() {
        return String.format(BEGIN_FORMAT, bowlingUser.getName());
    }

}
