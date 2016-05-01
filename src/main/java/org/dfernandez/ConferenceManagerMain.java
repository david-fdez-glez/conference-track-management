package org.dfernandez;


public class ConferenceManagerMain
{
    public static void main( String[] args )
    {
        String path = "src/main/resources/input_file_talks";

        if( args.length > 0) {
            path = args[0];
        }
    }
}
