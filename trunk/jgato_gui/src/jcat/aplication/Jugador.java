/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcat.aplication;

/**
 *
 * @author pperezp
 */
public class Jugador {
    private int id;
    private String nombre;
    private Ficha ficha;

    public Jugador(int id, String nombre, Ficha ficha) {
        this.id = id;
        this.nombre = nombre;
        this.ficha = ficha;
        System.out.println("Creado: "+nombre+" Ficha: "+ficha.name());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     
}
