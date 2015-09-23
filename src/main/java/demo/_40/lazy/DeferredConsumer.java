package demo._40.lazy;

import org.springframework.stereotype.Service;

import demo._40.metaannotation.LazyAutowired;

/**
 * Created by nlabrot on 01/09/15.
 */
@Service
public class DeferredConsumer {

    /**
     * Spring Proxify lazy service instance
     */
    @LazyAutowired
    private MyLazyService deferredService;

    public MyLazyService getDeferredService() {
        return deferredService;
    }
}
