package org.dfernandez.service;

import org.dfernandez.model.Conference;
import org.dfernandez.model.Talk;
import org.dfernandez.util.FilesUtil;

import java.util.ArrayList;
import java.util.List;

public class ConferenceScheduler {

    public Conference schedule(List<String> lines) {
       Conference conference = new Conference();
       List<Talk> talks = new ArrayList<>();

       for(String line: lines) {
           Talk talk = FilesUtil.parseInputLine(line);
           if(talk != null) {
               talks.add(talk);
           }
       }

       return conference;
    }
}
