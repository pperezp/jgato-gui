/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jgato.server.modelo;

import java.io.Serializable;
import javax.swing.JLabel;
import jgato.modelo.Ficha;

/**
 *
 * @author pperezp
 */
public class Jugada implements Serializable{
    private int posicion;
    private Ficha ficha;

    public Jugada(int posicion, Ficha ficha) {
        this.posicion = posicion;
        this.ficha = ficha;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }


    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
    
}
