package parsers.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class screenshootsValidatorTest {

    @Test
    void validate() {
        String link="https://prnt.sc/usni89";
        screenshootsValidator validator=new screenshootsValidator();
        assertEquals(validator.validate(link),""); //bad link
        assertEquals("https://prnt.sc/62crfd",validator.validate("https://prnt.sc/62crfd")); //good link
    }
}