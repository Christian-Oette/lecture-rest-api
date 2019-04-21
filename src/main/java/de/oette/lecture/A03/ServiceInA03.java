package de.oette.lecture.A03;

import de.oette.lecture.common.LessonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceInA03 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInA03.class);

    @EventListener(classes = ApplicationReadyEvent.class)
    public void init() {
        LessonUtils.logStart("A03");
    }
}
