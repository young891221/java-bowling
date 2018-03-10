package bowling.domain;

import static java.util.Optional.of;

public class BowlingUser {
    private static String name;

    public BowlingUser(String name) {
        this.name = of(name).filter(BowlingUser::isThreeLength).map(String::toUpperCase).orElseThrow(() -> new IllegalArgumentException("이름은 3글자만 허용됩니다."));
    }

    public static BowlingUser registed(String name) {
        return new BowlingUser(name);
    }

    private static boolean isThreeLength(String name) {
        return name.length() == 3;
    }

    public static String getName() {
        return name;
    }
}
