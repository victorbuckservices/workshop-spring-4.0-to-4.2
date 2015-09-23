package demo._41.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import demo.AbstractTest;

/**
 * Created by nlabrot on 01/09/15.
 */
public class CacheTest extends AbstractTest {

    @Autowired
    private CacheableService cachedService;

    @Test
    public void testCache() throws Exception {

        cachedService.heavyComputation();
        cachedService.heavyComputation();
        cachedService.updateDataset();
        cachedService.heavyComputation();
        cachedService.heavyComputation();
    }
}
