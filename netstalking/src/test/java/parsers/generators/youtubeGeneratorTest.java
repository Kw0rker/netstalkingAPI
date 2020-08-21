package parsers.generators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class youtubeGeneratorTest {

    @Test
    void generate() {
        youtubeGenerator generator=new youtubeGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }
    }
}