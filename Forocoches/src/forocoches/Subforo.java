/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forocoches;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Subforo implements Serializable {
    ArrayList<Entrada> entradas=new ArrayList<>();
    private final String nombre;
    private final Profesor creadorSubforo;
    public Subforo(String nombre, Profesor profesor){
        this.nombre=nombre;
        creadorSubforo=profesor;
    }
    public boolean crearEntrada(Entrada e){
        if ((BuscarEntrada(e.nombre))!=null){
            return false;
        } 
        else {
            return entradas.add(e);
        }
    }
    public String getNombre() {
        return nombre;
    }
    
    private Entrada BuscarEntrada(String nombre){
        int i=0;
        while (i<entradas.size()){
            if (entradas.get(i).nombre.equals(nombre)){
                return entradas.get(i);           
            }
        i++;
        }
        return null;
    }
   
    
    
}
