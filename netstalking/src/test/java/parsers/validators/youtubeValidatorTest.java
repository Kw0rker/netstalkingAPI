package parsers.validators;

import org.junit.jupiter.api.Test;
import parsers.generators.youtubeGenerator;

import static org.junit.jupiter.api.Assertions.*;

class youtubeValidatorTest {

    @Test
    void validate() {
        youtubeValidator validator=new youtubeValidator();
        youtubeGenerator generator=new youtubeGenerator();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(validator.validate(generator.generate()));
            }
            catch (RuntimeException e){i--;}
        }
    }
}