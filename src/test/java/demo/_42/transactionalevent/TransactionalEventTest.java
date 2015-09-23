package demo._42.transactionalevent;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import demo.AbstractTest;

/**
 * Created by nlabrot on 15/09/15.
 */
public class TransactionalEventTest extends AbstractTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private TransactionEventListener transactionEventListener;

    @Test
    @Transactional
    @Commit
    public void testTransactionalEvent() throws Exception {
        publisher.publishEvent(new TransactionalEvent(1));

        Assert.assertEquals(0 , transactionEventListener.getAllEvents().size());

        TestTransaction.end();

        Assert.assertEquals(2 , transactionEventListener.getAllEvents().size());
    }
}
