package API;

import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import parsers.generators.generator;
import parsers.validators.validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class API {
    Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private generator generator;
    private validator validator;
    private Logger logger;
    @SneakyThrows
    API(Socket socket,String params, Logger logger,generator generator,validator validator){
        this.socket=socket;
        this.logger=logger;
        this.generator=generator;
        this.validator=validator;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            int iteration=Integer.parseInt(params);
            for (int i = 0; i < iteration; i++) {
                try {
                    respond();
                }
                catch (RuntimeException r){
                    i--;//coz we need params number of valid links
                }
            }
        }
        catch (NumberFormatException e){
            if (params.equals("stream")){
                while (socket.isConnected()){
                    try {
                        respond();
                    }
                    catch (RuntimeException r){}//coz stream no need for any magik
                }
            }
            else {
                logger.info("bad param parsed: "+params);
            }
        }

    }
    private   void respond() throws RuntimeException{
        try {
            out.write(validator.validate(generator.generate()));
        }
        catch (RuntimeException e){
            logger.info("generated  invalid link");
            throw new RuntimeException("invalid link");
        }
    }
}
