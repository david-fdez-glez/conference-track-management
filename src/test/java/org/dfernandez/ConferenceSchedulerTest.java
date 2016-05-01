package org.dfernandez;

import org.dfernandez.model.Conference;
import org.dfernandez.service.ConferenceScheduler;
import org.dfernandez.util.FilesUtil;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConferenceSchedulerTest {

    static final String INPUT_FILE_TALKS_SESSION_MORNING = "src/test/resources/input_file_talks_session_morning";
    static final String INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED = "src/test/resources/input_file_talks_session_morning_expected";

    List<String> lines;

    Conference conference;
    @Before
    public void init() {

    }



    @Test
    public void testConferenceScheduleSessionMorning() throws IOException{
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS_SESSION_MORNING);
        conference = new ConferenceScheduler().schedule(lines);
        System.out.println("START FilesUTIL");
        System.out.println(FilesUtil.readFile(INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED, Charset.defaultCharset()));
        System.out.println("START conference");
        System.out.println(conference.toString());
        System.out.println("FINISH");

        //assertTrue(conference.toString().equals(FilesUtil.readFile(INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED, Charset.defaultCharset())));
        assertThat(conference.toString(), equalTo(FilesUtil.readFile(INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED, Charset.defaultCharset())));
        //assertEquals(conference.toString(),FilesUtil.readFile(INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED, Charset.defaultCharset()));
    }
}
