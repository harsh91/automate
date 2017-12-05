package utils;

/**
 * Created by nitika on 24/11/17.
 */
public class Context {
    protected Context() {
        // no instance creation
    }

    private static final Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }
}
