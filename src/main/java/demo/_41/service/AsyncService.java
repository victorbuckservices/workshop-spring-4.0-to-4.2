package demo._41.service;

import java.util.Map;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.google.common.collect.ImmutableMap;

/**
 * Created by nlabrot on 02/09/15.
 */
@Service
public class AsyncService {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncService.class);

    AsyncListenableTaskExecutor executorService = new ConcurrentTaskExecutor(Executors.newFixedThreadPool(10));

    public ListenableFuture<Map> execute(String id) throws InterruptedException {
        return executorService.submitListenable(() -> {
            Thread.sleep(2000);
            return ImmutableMap.of("id" , id, "thread" , Thread.currentThread().toString());
        });
    }
}
