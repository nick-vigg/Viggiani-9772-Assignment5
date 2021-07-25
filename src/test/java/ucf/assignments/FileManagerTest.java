package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    //Test cases not required for promptOpenFile() and promptSaveFile() as
    //FileChooser requires user input from GUI

    @Test
    void readFromFile() {
        //given
        FileManager fileManager = new FileManager();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("12         |  1234567890 |  poop       |");
        expected.add("22         |  0987654321 |  shit       |");
        expected.add("34         |  1324657890 |  nothing    |");
        //then
        assertEquals(expected, fileManager.readFromFile("C:\\Users\\19172\\IdeaProjects\\BookExample1\\Viggiani-cop3330-Assignment5\\src\\main\\resources\\readFromFileTest"));
    }
}