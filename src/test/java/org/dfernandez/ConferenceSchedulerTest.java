package org.dfernandez;

import org.dfernandez.model.Conference;
import org.dfernandez.service.ConferenceSchedulerService;
import org.dfernandez.service.ConferenceSchedulerServiceImpl;
import org.dfernandez.util.FilesUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConferenceSchedulerTest {

    static final String INPUT_FILE_TALKS_SESSION_MORNING = "src/test/resources/input_file_talks_session_morning";
    static final String INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED = "src/test/resources/input_file_talks_session_morning_expected";
    static final String INPUT_FILE_TALKS_SESSION_TRACK_ONE = "src/test/resources/input_file_talks_session_track_one";
    static final String INPUT_FILE_TALKS_SESSION_TRACK_ONE_EXPECTED = "src/test/resources/input_file_talks_session_track_one_expected";
    static final String INPUT_FILE_TALKS = "src/test/resources/input_file_talks";
    static final String INPUT_FILE_TALKS_EXPECTED = "src/test/resources/input_file_talks_expected";

    ConferenceSchedulerService conferenceSchedulerService;

    List<String> lines;

    Conference conference;

    @Before
    public void init() {
       conferenceSchedulerService = new ConferenceSchedulerServiceImpl();
    }


    @Test
    public void testConferenceScheduleSessionMorning() throws IOException {
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS_SESSION_MORNING);
        conference = conferenceSchedulerService.schedule(lines);
        assertThat(conference.toString(), equalTo(FilesUtil.readFile(INPUT_FILE_TALKS_SESSION_MORNING_EXPECTED, Charset.defaultCharset())));
    }

    @Test
    public void testConferenceScheduleSessionTrackOne() throws IOException {
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS_SESSION_TRACK_ONE);
        conference = conferenceSchedulerService.schedule(lines);
        assertThat(conference.toString(), equalTo(FilesUtil.readFile(INPUT_FILE_TALKS_SESSION_TRACK_ONE_EXPECTED, Charset.defaultCharset())));
    }

    @Test
    public void testConferenceScheduleSessionTrackTwo() throws IOException {
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS);
        conference = conferenceSchedulerService.schedule(lines);
        assertThat(conference.toString(), equalTo(FilesUtil.readFile(INPUT_FILE_TALKS_EXPECTED, Charset.defaultCharset())));
    }


}
