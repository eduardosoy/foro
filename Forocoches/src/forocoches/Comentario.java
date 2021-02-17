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
public class Comentario implements Serializable {
    private final String texto;
    private int valoraciones;
    private ArrayList<Comentario> comentarios=new ArrayList<>();
    

    public Comentario(String texto) {
        this.texto = texto;
        valoraciones=0;
    }

    public void valorar(boolean v) {
        if (v==true){
            valoraciones+=1;            
        }
        else{
            valoraciones-=1;
        }
    }
    public String getTexto() {
        return texto;
    }

    public int getValoraciones() {
        return valoraciones;
    }
    public Comentario comentar(String texto){
       Comentario c=new Comentario(texto);
       comentarios.add(c);
       return c;
    }
    


    
}
