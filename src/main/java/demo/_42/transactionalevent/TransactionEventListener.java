package demo._42.transactionalevent;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import demo._42.event.MyEventListener;

/**
 * Created by nlabrot on 15/09/15.
 */
@Service
public class TransactionEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(MyEventListener.class);

    private List<TransactionalEvent> allEvents = new ArrayList<>();

    @TransactionalEventListener
    public void afterCommit(TransactionalEvent transactionalEvent){
        allEvents.add(transactionalEvent);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(TransactionalEvent transactionalEvent){
        allEvents.add(transactionalEvent);
    }

    public List<TransactionalEvent> getAllEvents() {
        return allEvents;
    }
}
