package demo._42.event;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import demo.AbstractTest;

/**
 * Created by nlabrot on 15/09/15.
 */
public class EventTest extends AbstractTest {

    @Autowired
    private MyEventListener myEventListener;

    @Autowired
    private ApplicationEventPublisher publisher;


    @Test
    public void testEvent() throws Exception {

        publisher.publishEvent(new AnEvent(1));
        publisher.publishEvent(new AnEvent(2));


        Assert.assertEquals(2, myEventListener.getAllEvents().size());
        Assert.assertEquals(1, myEventListener.getEvenEvents().size());
        Assert.assertTrue(myEventListener.getEvenEvents().get(0).getValue() % 2 == 0);

    }
}
