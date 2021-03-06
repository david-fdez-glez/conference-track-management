package org.dfernandez;


import org.dfernandez.model.Conference;
import org.dfernandez.service.ConferenceSchedulerService;
import org.dfernandez.service.ConferenceSchedulerServiceImpl;
import org.dfernandez.util.FilesUtil;

import java.util.List;

public class ConferenceManagerMain {


    public static void main( String[] args )
    {
        ConferenceSchedulerService conferenceSchedulerService = new ConferenceSchedulerServiceImpl();

        String path = "src/main/resources/input_file_talks";

        if( args.length > 0) {
            path = args[0];
        } else {
            System.out.println(" You didn't provide a file path, the system will use " + path + "\n") ;
        }

        List<String> lines = FilesUtil.readAllLines(path);
        Conference conference = conferenceSchedulerService.schedule(lines);

        System.out.println(conference);
        System.out.println();
    }
}
