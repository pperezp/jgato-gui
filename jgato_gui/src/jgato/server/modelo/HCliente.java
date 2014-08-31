/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgato.server.modelo;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jgato.modelo.Ficha;
import jgato.modelo.Jugador;
import jgato.server.Server;

/**
 *
 * @author pperezp
 */
public class HCliente extends Thread{
    private Socket client;
    private ObjectInputStream input;
    private ObjectOutputStream out;
    

    public HCliente(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        while(true){
            try {
                input = new ObjectInputStream(client.getInputStream());
                Object o = input.readObject();
                
                if(o instanceof Jugador){
                    System.out.println("LLego jugador");
                    Jugador j = (Jugador)o;
                    
                    if(j.getId() == 1){
                        System.out.println("Es primer jugador");
                        Server.primerJugador = j;
                    }else{//segundo jugador
                        System.out.println("Es segundo, se enviará");
                        enviarObjeto(j);
                    }
                }else if(o instanceof PeticionFicha){
                    System.out.println("Peticion llegada");
                    RespuestaFicha rf = new RespuestaFicha((Server.primerJugador.getFicha() == Ficha.O?Ficha.X:Ficha.O));
                    System.out.println("Ficha Segundo jugador: "+rf.getFicha());
                    enviarObjetoAMi(rf);
                    enviarObjetoAMi(Server.primerJugador);
                }else{
                    enviarObjeto(o);
                }
                
                
            } catch(EOFException ex){
                
            } catch (IOException ex) {
                Logger.getLogger(HCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HCliente.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }

    private void enviarObjeto(Object o) throws IOException {
        for(HCliente cliente : Server.clientes){
            if(cliente.getId() != this.getId()){
                out = new ObjectOutputStream(cliente.client.getOutputStream());
                out.writeObject(o);
            }else{
                System.out.println("Mismo ID");
            }
        }
    }
    
    private void enviarObjetoAMi(Object o) throws IOException {
        out = new ObjectOutputStream(client.getOutputStream());
        out.writeObject(o);
    }

}
