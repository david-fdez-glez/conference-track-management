package org.dfernandez;

import org.dfernandez.util.Constants;
import org.dfernandez.util.TimeUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TimeUtilTest {

    @Before
    public void init() {}

    @Test
    public void testNineAM() {
        assertTrue("09:00 AM".equals(TimeUtil.getScheduledTime(Constants.MORNING_SESSION_START_TIME)));
    }

    @Test
    public void testNoonTime() {
        assertTrue("12:00 PM".equals(TimeUtil.getScheduledTime(Constants.LUNCH_SESSION_START_TIME)));
    }

    @Test
    public void testFourThirtyPM() {
        assertTrue("04:30 PM".equals(TimeUtil.getScheduledTime(16*60 +30)));
    }

    public void testTenFiveAM() {
        assertTrue("10:05 AM".equals(TimeUtil.getScheduledTime(10*60 +5)));
    }
}