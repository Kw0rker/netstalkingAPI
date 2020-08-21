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
            int iteration=Math.abs(Integer.parseInt(params));
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
                out.write(" use number as second param");
                logger.info("bad param parsed: "+params);
            }
        }
        socket.close();
        logger.info("request completed");
    }
    private   void respond() throws RuntimeException{
        String link=generator.generate();
        try {
            link=validator.validate(link);
            logger.debug("link generated successfully: "+link);
            out.write(link+"\n");
            out.flush();
        }
        catch (RuntimeException e){
            logger.debug("generated  invalid link: "+link);
            throw new RuntimeException("invalid link:+ ");
        }
    }
}
