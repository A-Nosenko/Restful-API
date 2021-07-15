package my.rest.model;

/**
 * Thread safe singleton with double checking locking.
 */
public class Container {

    private static volatile Container INSTANCE;

    private Container() {

    }

    public static Container getInstance() {
        if (INSTANCE == null) {
            synchronized (Container.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Container();
                }
            }
        }

        return INSTANCE;
    }
}
