package demo._40.lazy;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Stopwatch;
import demo.AbstractTest;

/**
 * Created by nlabrot on 01/09/15.
 */
public class LazyApiTest extends AbstractTest {

    @Test
    public void sleepTest(){
        Stopwatch stopwatch = Stopwatch.createStarted();
        applicationContext.getBean(LazyApi.class);
        Assert.assertTrue(stopwatch.stop().elapsed(TimeUnit.SECONDS) >= 2);
    }
}
