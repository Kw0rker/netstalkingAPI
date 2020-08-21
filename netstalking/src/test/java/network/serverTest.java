package network;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class serverTest {
    @Test
    public void checkConfection() throws IOException {
        server s=new server(8099);
       /*// Thread.sleep(1000);
        //Socket socket=new Socket("localhost",8099);
        DataInputStream inputStream=new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("imgur 10");
        for (int i = 0; i < 10; i++) {
            System.out.println(inputStream.readUTF());
        }*/
    }

}