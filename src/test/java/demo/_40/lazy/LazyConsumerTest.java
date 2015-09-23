package demo._40.lazy;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;
import demo.AbstractTest;
import demo._40.metaannotation.LazyAutowired;

/**
 * Created by nlabrot on 01/09/15.
 */
public class LazyConsumerTest extends AbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(MyLazyService.class);

    @LazyAutowired
    private MyLazyService lazyService;


    @Test
    public void sleepTest() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        //foo() calls force the init of the bean
        lazyService.foo();
        Assert.assertTrue(stopwatch.stop().elapsed(TimeUnit.SECONDS) >= 2);
    }

}
