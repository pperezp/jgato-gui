package jgato.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Red {
    public static String getIpPublica() throws MalformedURLException, IOException{
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
        return in.readLine();
    }
    
    public static String getIpLocal() throws UnknownHostException {
        InetAddress direccion = InetAddress.getLocalHost();
        return  direccion.toString();//ip como String
    }
}
