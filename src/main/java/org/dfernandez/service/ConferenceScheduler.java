package org.dfernandez.service;

import org.dfernandez.model.*;
import org.dfernandez.util.Constants;
import org.dfernandez.util.FilesUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConferenceScheduler {

    public Conference schedule(List<String> lines) {
        Conference conference = new Conference();
        List<Talk> talks = new ArrayList<>();

        for(String line: lines) {
           line.trim();
           Talk talk = FilesUtil.parseInputLine(line);
           if(talk != null) {
               talks.add(talk);
           }
        }

        while(talks.size() != 0) {
            // Add Morning Session
            Session morningSession = new Session(Constants.MORNING_SESSION_DURATION, Constants.MORNING_SESSION_START_TIME);
            fillSessionWithTalks(morningSession,talks);
            // Add Lunch Session
            Session lunchSession = new Session(Constants.LUNCH_SESSION_DURATION, Constants.LUNCH_SESSION_START_TIME);
            lunchSession.addTalk(new Talk(Constants.LUNCH_TALK_NAME,Constants.LUNCH_SESSION_DURATION, TalkLength.MINUTES));
            // Add Afternoon Session
            Session afternoonSession = new Session(Constants.AFTERNOON_SESSION_DURATION, Constants.AFTERNOON_SESSION_START_TIME);
            fillSessionWithTalks(afternoonSession,talks);
            // Add Networking Event
            Session networkingSession = new Session(Constants.NETWORKING_EVENT_DURATION,Constants.NETWORKING_EVENT_MIN_START_TIME);
            Talk networkEventTalk = new Talk(Constants.NETWORKING_EVENT_NAME,Constants.NETWORKING_EVENT_DURATION,TalkLength.MINUTES);
            networkingSession.addTalk(networkEventTalk);
            afternoonSession.addNetworkingEvent(networkingSession);
            // Add sessions to Track
            Track track = new Track();
            track.addSession(morningSession);
            track.addSession(lunchSession);
            track.addSession(afternoonSession);
            // Add track to conference
            conference.addTrack(track);
        }
       return conference;
    }

    /**
     * Add talk to the session, and remove the talk from the List
     * @param session
     * @param talks
     */
    private static void fillSessionWithTalks(Session session, List<Talk> talks) {
        for (Iterator<Talk> iter = talks.iterator(); iter.hasNext(); ) {
            Talk talk = iter.next();
            // Check if there is space for the talk in the Session
            if(session.hasRoom(talk)) {
                session.addTalk(talk);
                iter.remove();
            }
        }
    }

}