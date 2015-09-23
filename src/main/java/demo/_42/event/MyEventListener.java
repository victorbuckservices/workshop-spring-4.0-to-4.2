package demo._42.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by nlabrot on 15/09/15.
 */
@Service
public class MyEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(MyEventListener.class);

    private List<AnEvent> allEvents = new ArrayList<>();
    private List<AnEvent> evenEvents = new ArrayList<>();

    @EventListener
    public void processAllEvent(AnEvent event) {
        allEvents.add(event);
    }


    @EventListener(condition = "#event.value % 2 == 0")
    public void processEvenEvent(AnEvent event) {
        evenEvents.add(event);
    }


    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void handleContextStart() {
        LOG.info("Context Started of refreshed!!!!!!!!!!!!");
    }

    public List<AnEvent> getAllEvents() {
        return allEvents;
    }

    public List<AnEvent> getEvenEvents() {
        return evenEvents;
    }
}
