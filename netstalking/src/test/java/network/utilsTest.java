package network;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class utilsTest {

    @Test
    void getRedirect() {
        assertEquals(utils.getRedirect("https://i.imgur.com/29yO1.jpg"),"https://i.imgur.com/removed.png"); //check for handling imgur redirect img not found
        assertNull(utils.getRedirect("https://i.imgur.com/YO5X2.jpg")); //check for good imgur links
    }
    @Test
    void getHtmlStream() {
        utils.getHtmlStream("https://youtu.be/PFz6mzV-EWw").forEach(System.out::println);
    }
}