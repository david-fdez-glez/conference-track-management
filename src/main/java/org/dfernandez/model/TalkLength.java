package org.dfernandez.model;


public enum TalkLength {
    MINUTES(1,"min"), LIGHTENING(5,"lightning");

    private int factor;
    private String label;

    private TalkLength(int factor, String label) {
        this.factor = factor;
        this.label = label;
    }

    public int getDuration(int duration) {
        return factor*duration;
    }


    @Override
    public String toString() {
        return label;
    }
}
