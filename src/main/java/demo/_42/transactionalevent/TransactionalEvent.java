package demo._42.transactionalevent;

/**
 * Created by nlabrot on 15/09/15.
 */
public class TransactionalEvent {

    private final int value;

    public TransactionalEvent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
