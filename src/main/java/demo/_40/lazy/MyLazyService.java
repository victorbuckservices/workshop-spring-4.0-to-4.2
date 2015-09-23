package demo._40.lazy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo._40.metaannotation.LazyService;

/**
 * Created by nlabrot on 01/09/15.
 */
@LazyService
public class MyLazyService {

    private static final Logger LOG = LoggerFactory.getLogger(MyLazyService.class);

    public MyLazyService() {
    }

    @PostConstruct
    public void init() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void foo(){
        LOG.info("foo");
    }
}
