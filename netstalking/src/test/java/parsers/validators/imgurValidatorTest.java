package parsers.validators;

import parsers.generators.imgurGenerator;

import static org.junit.jupiter.api.Assertions.*;

class imgurValidatorTest {

    @org.junit.jupiter.api.Test
    void validate() {
        imgurGenerator generator=new imgurGenerator();
        imgurValidator validator=new imgurValidator();
        for (int i = 0; i < 10; i++) {

            System.out.println(validator.validate(generator.generate()));
        }
    }
}