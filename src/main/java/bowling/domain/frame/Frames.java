package bowling.domain.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static bowling.utils.StringUtils.emptyBlockFormat;

public class Frames {
    private List<Frame> frames = new ArrayList<>();

    public String scoreView() {
        return frames.stream().map(f -> emptyBlockFormat(f.result())).collect(Collectors.joining());
    }

    public void addFrame(Frame frame) {
        if(frames.contains(frame)) { frames.remove(frame); }
        frames.add(frame);
    }

    public int size() {
        return frames.size();
    }
}
