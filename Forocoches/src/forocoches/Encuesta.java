/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forocoches;

import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Encuesta extends EntradaGenerica{
    ArrayList<String> respuestas=new ArrayList();

    public Encuesta(String nombre, String texto) {
        this.nombre=nombre;
        this.texto=texto;
    }
    
    public void introducirRespuesta(String r){
        respuestas.add(r);
    }
}
