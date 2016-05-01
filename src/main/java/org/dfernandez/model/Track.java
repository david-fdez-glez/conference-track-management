package org.dfernandez.model;


import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<Session> sessions;

    public Track() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Session session: sessions) {
            sb.append(session);
        }
        return sb.toString();
    }
}
