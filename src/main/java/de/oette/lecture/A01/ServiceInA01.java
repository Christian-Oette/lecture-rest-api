package de.oette.lecture.A01;

import de.oette.lecture.common.LessonUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceInA01 {

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        LessonUtils.logStart("A01");
    }
}
