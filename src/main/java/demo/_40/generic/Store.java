package demo._40.generic;

/**
 * Created by nlabrot on 14/09/15.
 */
public class Store<T> {

    private final Class<T> type;

    public Store(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }
}
