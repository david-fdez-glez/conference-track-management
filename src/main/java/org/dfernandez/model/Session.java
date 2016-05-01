package org.dfernandez.model;


import org.dfernandez.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private List<Talk> talks;
    private int remainingDuration;
    private int startTime;
    private Session networkingEvent;

    public Session(int duration, int startTime) {
        this.remainingDuration = duration;
        this.startTime = startTime;
        talks = new ArrayList<>();
    }

    public int getStartTime() {
        return this.startTime;
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


    public  void addNetworkingEvent(Session session) {
        this.networkingEvent = session;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int nextTalkStartTime = startTime;

        for(Talk talk: talks) {
            sb.append(TimeUtil.getScheduledTime(nextTalkStartTime) + " " + talk + "\n");
            nextTalkStartTime += talk.getDurationInMinutes();
        }

        if(networkingEvent != null) {
            int networkingEventStartTime = networkingEvent.getStartTime();
            if(nextTalkStartTime > networkingEventStartTime) {
                networkingEventStartTime = nextTalkStartTime;
            }
            sb.append(TimeUtil.getScheduledTime(networkingEventStartTime) + " " + networkingEvent.talks.get(0) + "\n");
        }

        return sb.toString();
    }
}
