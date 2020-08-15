package network;

import lombok.SneakyThrows;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class utils {
    @SneakyThrows
    static synchronized public String getRedirect(String url)  {
        Thread.sleep(30);
        HttpURLConnection con = (HttpURLConnection)(new URL( url ).openConnection());
        con.setInstanceFollowRedirects( false );
        con.connect();
        int responseCode = con.getResponseCode();
        return  con.getHeaderField( "Location" );
    }
}
