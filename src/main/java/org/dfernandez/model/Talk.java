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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Talk talk = (Talk) obj;

        if (talkLength != talk.talkLength) return false;
        if (duration != talk.duration) return false;
        if(!name.equals(talk.getName()))  return false;
        return true;

    }

    @Override
    public String toString() {
        return name + " " + duration + " " + talkLength;
    }

}
