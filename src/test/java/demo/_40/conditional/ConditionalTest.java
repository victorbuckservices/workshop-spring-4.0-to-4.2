package demo._40.conditional;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import demo.AbstractTest;

/**
 * Created by nlabrot on 01/09/15.
 */
public class ConditionalTest extends AbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionalTest.class);

    @Autowired
    private MyOsDependantInterface myOsDependantInterface;

    @Test
    public void testConditional() throws Exception {
        LOG.info(myOsDependantInterface.getClass().getCanonicalName());
        Assert.assertEquals(MyOsDependantInterface.Linux.class , myOsDependantInterface.getClass());
    }
}
