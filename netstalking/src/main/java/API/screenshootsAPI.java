package API;

import org.apache.log4j.Logger;
import parsers.generators.imgurGenerator;
import parsers.generators.screenshootsGenerator;
import parsers.validators.imgurValidator;
import parsers.validators.screenshootsValidator;

import java.net.Socket;

public class screenshootsAPI extends API {
    static private Logger logger = Logger.getLogger(screenshootsAPI.class);
    public screenshootsAPI(Socket socket, String params) {
        super(socket,params,logger,new screenshootsGenerator(),new screenshootsValidator());
    }
}
