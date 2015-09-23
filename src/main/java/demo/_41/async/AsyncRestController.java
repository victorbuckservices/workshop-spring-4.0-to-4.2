package demo._41.async;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo._41.service.AsyncService;

/**
 * Created by nlabrot on 01/09/15.
 */
@RestController
public class AsyncRestController {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncRestController.class);

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/ws/async/{id}")
    public ListenableFuture<Map> index(@PathVariable("id") String id) throws InterruptedException {
        LOG.info("start");
        ListenableFuture<Map> future = asyncService.execute(id);
        LOG.info("end");
        return future;

    }
}
