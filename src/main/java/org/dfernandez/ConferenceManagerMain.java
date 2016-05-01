package org.dfernandez;


import org.dfernandez.model.Conference;
import org.dfernandez.service.ConferenceScheduler;
import org.dfernandez.util.FilesUtil;

import java.util.List;

public class ConferenceManagerMain
{
    public static void main( String[] args )
    {
        String path = "src/main/resources/input_file_talks";

        if( args.length > 0) {
            path = args[0];
        } else {
            System.out.println(" You didn't provide a file path, the system will use " + path + "\n") ;
        }

        List<String> lines = FilesUtil.readAllLines(path);
        Conference conference = new ConferenceScheduler().schedule(lines);

        System.out.println(conference);
        System.out.println();
    }
}
