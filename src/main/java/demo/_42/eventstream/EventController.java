package demo._42.eventstream;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * Created by nlabrot on 17/09/15.
 */
@Controller
public class EventController {

    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);


    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @RequestMapping(value = "/ws/event")
    @ResponseBody
    public ResponseEntity<ResponseBodyEmitter> handle() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        executorService.execute(() -> {
            try {
                for (int i = 0 ; i<10 ;i++) {
                    emitter.send("event: datetime\n");
                    emitter.send("data: " + LocalDateTime.now().toString() + "\n\n");
                    Thread.sleep(1000);
                }

                emitter.complete();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        });

        return ResponseEntity.ok().contentType(MediaType.parseMediaType("text/event-stream")).body(emitter);
    }

    @RequestMapping("/event")
    public String eventPage() {
        return "event";
    }

}
