package org.dfernandez.util;


import java.util.Arrays;
import java.util.Collections;

public final class Constants {

    private Constants(){}

    public final static int MORNING_SESSION_DURATION = 180;
    public final static int LUNCH_SESSION_DURATION = 60;
    public final static int AFTERNOON_SESSION_DURATION = 240;


    public final static int MORNING_SESSION_START_TIME = 9*60; // 9am
    public final static int LUNCH_SESSION_START_TIME = MORNING_SESSION_START_TIME + MORNING_SESSION_DURATION;
    public final static int AFTERNOON_SESSION_START_TIME = LUNCH_SESSION_START_TIME + LUNCH_SESSION_DURATION;

    public final static int MAX_TALK_DURATION  = Collections.max(Arrays.asList(MORNING_SESSION_DURATION,LUNCH_SESSION_DURATION, AFTERNOON_SESSION_DURATION));

    public final static String LUNCH_TALK_NAME = "Lunch";
    public final static String NETWORKING_EVENT_NAME = "Networking Event";
    public final static int NETWORKING_EVENT_DURATION = 60;


    public final static int NETWORKING_EVENT_MIN_START_TIME = 16*60; // 4pm
}
