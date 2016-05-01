package org.dfernandez.model;


import java.util.ArrayList;
import java.util.List;

public class Conference {

    private List<Track> tracks;

    public Conference() {
        tracks = new ArrayList<>();
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Conference schedule:\n\n");

        for(int i=0; i< tracks.size(); i++) {
            sb.append(("Track " + (i +1) +":\n"));
            sb.append(tracks.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
