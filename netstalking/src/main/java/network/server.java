package network;

import API.imgurAPI;
import API.screenshootsAPI;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class server {
    static private Logger logger;
    static public HashMap<String,Socket> ipMap=new HashMap<>();
    server(int port){
        String log4jConfigFile = System.getProperty("user.dir")
                + File.separator + "log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
        logger = Logger.getLogger(server.class);

        try {
            ServerSocket socket=new ServerSocket(port);
            logger.info("socket created on address" +socket.getLocalSocketAddress().toString());
            while (true){

                Socket client=socket.accept();
                logger.info("socket received with ip:"+client.getLocalSocketAddress());
                new Thread(()->{
                    try {
                        BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));

                        while (true){
                            if (client.isClosed())break;
                            String request=reader.readLine();
                            logger.info("request received :"+request);
                            String[] args=request.split(" ");
                            switch (args[0]){
                                case "imgur":
                                    new imgurAPI(client,args[1]);
                                    break;
                                case "lightshot":
                                    new screenshootsAPI(client,args[1]);
                                    break;

                            }
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e) {
                        logger.error(e);
                        e.printStackTrace();
                    }
                }).start();
                Thread.sleep(100);
                ipMap.put(client.getInetAddress().toString(),client);
            }
        } catch (IOException | InterruptedException e) {
            logger.error(e);
        }
    }

    public static void main(String[] args) {
        new server(8099);
    }

}
