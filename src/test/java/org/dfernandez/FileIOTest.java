package org.dfernandez;


import org.dfernandez.util.FilesUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.*;

public class FileIOTest {

    static final String INPUT_FILE_TALKS = "src/test/resources/input_file_talks";
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

        List<String> lines = FilesUtil.readAllLines(INPUT_FILE_TALKS);

        assertEquals(lines.size(),19);
    }

    @Test
    public void testReadTalksValues() {

    }
}
