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
public class Entrada extends EntradaGenerica {
    private ArrayList<EntradaGenerica> entradas=new ArrayList<>();
    private ArrayList<Comentario> comentarios=new ArrayList<>();
    private final Usuario creadorEntrada;
    private int valoracion;
    private boolean validada;
    
    public Entrada(String nombre,String texto,Usuario creadorEntrada,boolean valida) {
        this.nombre=nombre;
        this.texto=texto;
        this.creadorEntrada=creadorEntrada;
        validada=valida;
        valoracion=0;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }
    
    public void introducirTexto(String titulo,String texto){
        TextoPlano txt=new TextoPlano(titulo,texto);
        entradas.add(txt);
    }
    public Encuesta introducirEncuesta(String titulo,String texto){
        Encuesta e=new Encuesta(titulo,texto);  
        entradas.add(e);
        return e;
    }
    public void RespuestaEncuesta(Encuesta e,String respuesta){
        e.introducirRespuesta(respuesta);
    }
    public void introducirEjercicio(String titulo,String enunciado, String solucion){
        Ejercicio ej=new Ejercicio(titulo,enunciado,solucion);
    }
    public void valorar(boolean v) {
        if (v==true){
            valoracion+=1;            
        }
        else{
            valoracion-=1;
        }
    }
    public Comentario comentar(String texto){
        Comentario c=new Comentario(texto);
        comentarios.add(c);
        return c;
    }
}


    
