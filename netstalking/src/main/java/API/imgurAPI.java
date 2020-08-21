package API;

import network.server;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import parsers.generators.imgurGenerator;
import parsers.validators.imgurValidator;

import java.io.File;
import java.net.Socket;

public class imgurAPI extends API  {
    static private Logger logger = Logger.getLogger(imgurAPI.class);

    public imgurAPI(Socket socket, String params) {
        super(socket, params,logger,new imgurGenerator(),new imgurValidator());
    }

}
