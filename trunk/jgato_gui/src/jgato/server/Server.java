/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgato.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jgato.modelo.Jugador;
import jgato.server.modelo.HCliente;

/**
 *
 * @author pperezp
 */
public class Server implements Runnable{
    private ServerSocket server;
    public static List<HCliente> clientes;
    public static Jugador primerJugador;
    
    public Server(){
        try {
            server = new ServerSocket(5000);
            clientes = new ArrayList<>();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Socket cli = server.accept();
                HCliente cliente = new HCliente(cli);
                clientes.add(cliente);
                cliente.start();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
