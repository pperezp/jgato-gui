/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgato.server.modelo;

import java.io.Serializable;

/**
 *
 * @author pperezp
 */
public class Mensaje implements Serializable{
    private String mensaje;
    private String emisor;

    public Mensaje(String mensaje, String emisor) {
        this.mensaje = mensaje;
        this.emisor = emisor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    
    
}
