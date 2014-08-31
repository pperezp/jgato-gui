/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgato.server.modelo;

import java.io.Serializable;
import jgato.modelo.Ficha;

/**
 *
 * @author pperezp
 */
public class RespuestaFicha implements Serializable{
    private final Ficha ficha;

    public RespuestaFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Ficha getFicha() {
        return ficha;
    }
    
    
}
