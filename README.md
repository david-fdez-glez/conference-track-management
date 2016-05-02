Problem Two: Conference Track Management
************************************************************************************************************************

You are planning a big programming conference and have received many proposals which have passed the initial screen
process but you're having trouble fitting them into the time constraints of the day -- there are so many possibilities!
So you write a program to do it for you.
The conference has multiple tracks each of which has a morning and afternoon session.
Each session contains multiple talks.
Morning sessions begin at 9am and must finish by 12 noon, for lunch.
Afternoon sessions begin at 1pm and must finish in time for the networking event.
The networking event can start no earlier than 4:00 and no later than 5:00.
No talk title has numbers in it.
All talk lengths are either in minutes (not hours) or lightning (5 minutes).
Presenters will be very punctual; there needs to be no gap between sessions.

Note that depending on how you choose to complete this problem, your solution may give a different ordering or
combination of talks into tracks. This is acceptable; you don’t need to exactly duplicate the sample output given here.

************************************************************************************************************************


####### How to Build

cd /path/to/project

mvn clean install

####### How to run test

cd /path/to/project

mvn test


####### How to run project

cd /path/to/project

java -jar target/conference-track-1.0-SNAPSHOT.jar path_to_file_test_input


#### or  (system will use a default file)

java -jar target/conference-track-1.0-SNAPSHOT.jar




################ DESIGN


######## MODEL

#### TALK
Represents an individual event, which has a name, startTime and duration

#### Session
Each session has multiple talks. It has a startTime, and different duration: morning,lunch and afternoon.
Afternoon session also has a networking event

#### Track
Each track has a morning, lunch and  afternoon session.

#### Conference
Each Conference has multiple tracks.


######## UTIL

#### Constants
Useful constants

#### FilesUtil
Helper to read and parse Files

#### TimeUtil
Helper to translate startTime to String (9*60 => 09:00 AM)


######## Service

#### ConferenceScheduler
(*) ConferenceScheduler provides a method called schedule(), which will create a Conference Object,which represents
a scheduled conference with tracks, sessions and talks

(*) Example of use:
/*
// path: pathToFile
 Writing Fast Tests Against Enterprise Rails 60min
 Overdoing it in Python 45min
 Rails for Python Developers lightning
// END FILE
*/
List<String> lines = FilesUtil.readAllLines(path);
Conference conference = new ConferenceScheduler().schedule(lines);













