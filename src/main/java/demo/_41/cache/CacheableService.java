package demo._41.cache;

import javax.cache.annotation.CacheRemove;
import javax.cache.annotation.CacheResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by nlabrot on 01/09/15.
 */
@Service
public class CacheableService {

    private static final Logger LOG = LoggerFactory.getLogger(CacheableService.class);

    @CacheResult(cacheName = "heavyComputation")
    public String heavyComputation(){
        LOG.info("heavyComputation");
        return "ok";
    }

    @CacheRemove(cacheName = "heavyComputation")
    public void updateDataset(){
        LOG.info("updateDataset");
    }

}
