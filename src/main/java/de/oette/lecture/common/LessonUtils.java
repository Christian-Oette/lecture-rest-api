package de.oette.lecture.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LessonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LessonUtils.class);

    public static void logStart(String lesson) {
        LOGGER.info("\n\n\n ------------------- \n Lesson {} active \n ------------------- \n\n\n", lesson);
    }
}
