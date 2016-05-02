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

    /**
     * Add a talk to the session
     * @param talk
     * @return true if the talk was added to the Session
     */
    public boolean addTalk(Talk talk) {
        if(remainingDuration >= talk.getDurationInMinutes()) {
            talks.add(talk);
            remainingDuration -= talk.getDurationInMinutes();
            return true;
        }
        return false;
    }

    /**
     * Check if there is enough time for talk
     * @param talk
     * @return
     */
    public boolean hasRoom(Talk talk) {
        return remainingDuration >= talk.getDurationInMinutes();
    }

    /**
     * Add networking Event to the session
     * @param session
     */
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