package API;

import org.apache.log4j.Logger;
import parsers.generators.generator;
import parsers.validators.validator;

import java.net.Socket;

public class youtubeAPI extends API {
    youtubeAPI(Socket socket, String params, Logger logger, parsers.generators.generator generator, parsers.validators.validator validator) {
        super(socket, params, logger, generator, validator);
    }
}
