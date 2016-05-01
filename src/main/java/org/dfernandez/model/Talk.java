package org.dfernandez.model;


public class Talk {

    private String name;
    private int duration;
    private TalkLength talkLength;

    public Talk(String name, int duration, TalkLength talkLength) {
        this.name = name;
        this.duration = duration;
        this.talkLength = talkLength;
    }

    public int getDurationInMinutes() {
        return talkLength.getDuration(duration);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + duration + " " + talkLength;
    }

}
