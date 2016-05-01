package org.dfernandez.util;


import java.util.Arrays;
import java.util.Collections;

public final class Constants {

    private Constants(){}

    public final static int SLOT_MORNING_DURATION = 180;
    public final static int SLOT_LUNCH_DURATION = 60;
    public final static int SLOT_AFTERNOON_DURATION = 240;

    public final static int NETWORK_TALK_DURATION = 60;

    public final static int MAX_TALK_DURATION  = Collections.max(Arrays.asList(SLOT_MORNING_DURATION,SLOT_LUNCH_DURATION, SLOT_AFTERNOON_DURATION));

}
