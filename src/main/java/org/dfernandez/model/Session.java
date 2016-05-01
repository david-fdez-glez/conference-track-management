package org.dfernandez.model;


import org.dfernandez.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private List<Talk> talks;
    private int remainingDuration;
    private int startTime;

    public Session(int duration, int startTime) {
        this.remainingDuration = duration;
        this.startTime = startTime;
        talks = new ArrayList<>();
    }

    public void addTalk(Talk talk) {
        if(remainingDuration < talk.getDurationInMinutes()) {
            // TODO CATCH ERROR
        }
        talks.add(talk);
        remainingDuration -=talk.getDurationInMinutes();
    }

    public boolean hasRoom(Talk talk) {
        return remainingDuration >= talk.getDurationInMinutes();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int talkStartTime = startTime;

        for(Talk talk: talks) {
            sb.append(TimeUtil.getScheduledTime(talkStartTime) + " " + talk + "\n");
            talkStartTime += talk.getDurationInMinutes();
        }

        return sb.toString();
    }
}
