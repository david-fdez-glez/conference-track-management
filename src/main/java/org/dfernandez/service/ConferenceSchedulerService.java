package org.dfernandez.service;


import org.dfernandez.model.Conference;

import java.util.List;

public interface ConferenceSchedulerService {

    public Conference schedule(List<String> lines);

}
