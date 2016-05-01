package org.dfernandez.util;


import org.dfernandez.model.Talk;
import org.dfernandez.model.TalkLength;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesUtil {

    // Pattern Talk Line
    public static final Pattern TALK_LINE_PATTERN = Pattern.compile(
            "^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");
    /**
     * I'm assuming the purpose for this test is not to validate the IO Operations
     * This is why I'm not doing anything when I catch the errors
     * @param path
     * @return
     */
    public static List<String> readAllLines(String path) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException exception) {
            // TODO Catch Error
        }
        return lines;
    }

    /**
     * Parse string line, and try convert to Talk
     * @param line
     * @return Talk object or null
     */
    public static Talk parseInputLine(String line) {
        if(line.length() == 0) {
            return null;
        }
        Matcher matcher = TALK_LINE_PATTERN.matcher(line);

        if (matcher.find() == false) {
            return null;
        }

        // Match the name
        String name = matcher.group(1);
        // Match unit
        String durationString = matcher.group(2);
        // Check if there is no duration, because lightning could has no duration assigned
        if(durationString == null) {
             durationString = "1";
        }
        int duration = Integer.parseInt(durationString);
        // Match Unit
        TalkLength talkLength;
        if(matcher.group(3).equalsIgnoreCase("min")) {
            talkLength = TalkLength.MINUTES;
        } else {
            talkLength = TalkLength.LIGHTENING;
        }

        Talk talk = new Talk(name, duration, talkLength);
        if(talk.getDurationInMinutes() > Constants.MAX_TALK_DURATION) {
            System.out.println(" Event "+ name + "with duration " + talk.getDurationInMinutes() +
                    " which more than the maximum: " +Constants.MAX_TALK_DURATION + " allowed for a Talk");
            return null;
        }

        return talk;
    }

}
