package org.dfernandez;


import org.dfernandez.model.Talk;
import org.dfernandez.model.TalkLength;
import org.dfernandez.util.FilesUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileIOTest {

    static final String INPUT_FILE_TALKS = "src/test/resources/input_file_talks";

    List<String> lines;
    Talk talk;
    @Before
    public void init() {
     }


    @Test
    public void testFileExists() {
        File file = new File(INPUT_FILE_TALKS);
        assertEquals(true, file.exists());
    }

    @Test
    public void testReadFileLines() {

       lines = FilesUtil.readAllLines(INPUT_FILE_TALKS);

        assertEquals(lines.size(),19);
    }

    @Test
    public void testReadTalkFirstLineValue() {
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS);
        talk  = new Talk("Writing Fast Tests Against Enterprise Rails",60, TalkLength.MINUTES);
        assertEquals(talk, FilesUtil.parseInputLine(lines.get(0)));
    }

    @Test
    public void testReadTalkSixLineValue() {
        lines = FilesUtil.readAllLines(INPUT_FILE_TALKS);
        talk  = new Talk("Rails for Python Developers",1, TalkLength.LIGHTENING);
        assertEquals(talk, FilesUtil.parseInputLine(lines.get(5)));

    }
}
