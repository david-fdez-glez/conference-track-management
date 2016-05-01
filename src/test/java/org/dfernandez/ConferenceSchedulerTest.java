package org.dfernandez;

import org.dfernandez.model.Conference;
import org.dfernandez.service.ConferenceScheduler;
import org.dfernandez.util.FilesUtil;
import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConferenceSchedulerTest {

    static final String INPUT_FILE_TALKS_SESSION_MORNING = "src/test/resources/input_file_talks_session_morning";
    List<String> lines;

    Conference conference;
    @Before
    public void init() {

    }



    @Test
    public void testConferenceScheduleSessionMorning() {
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS_SESSION_MORNING);
        conference = new ConferenceScheduler().schedule(lines);

        System.out.println(" epa " + conference.toString());
    }
}
