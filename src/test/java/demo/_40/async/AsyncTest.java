package demo._40.async;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import demo.AbstractTest;

/**
 * Created by nlabrot on 17/09/15.
 */
public class AsyncTest extends AbstractTest {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncTest.class);

    AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory());

    @Test
    public void testAsyncRestTemplate() throws Exception {

        ListenableFuture<ResponseEntity<Map>> entity = asyncRestTemplate.getForEntity("http://localhost:8090/ws/rest/{msg}", Map.class, "world");

        entity.addCallback(e -> {
            LOG.info("Success {}" , e.getBody());

        }, e -> {
            LOG.error("Failure {}" , e);
        });

        LOG.info("Thread is available for other tasks");

        //Need to wait for the result otherwise the JVM exit
        entity.get();
    }
}
