/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forocoches;

/**
 *
 * @author Eduardo
 */
public class Demostrador{    
    public static void main(String[] args){

        Sistema s= new Sistema();
        
        s=s.cargar();
        
        inicializarSistemaPruebas(s);
        
    }
    
    static private void inicializarSistemaPruebas(Sistema s){
        Subforo ptSubforo;
        Entrada ptEntrada;
        Encuesta ptEncuesta;
        Comentario ptComentario;
        Usuario ptUsuario0;
        Usuario ptUsuario1;
        Usuario ptUsuario2;
        
        {//creacion de usuarios
        ptUsuario0=s.crearAdministrador("admin", "admin", "admin", "admin", "admin");
        ptUsuario1=s.crearProfesor("profe", "profe", "profe", "profe", "profe");
        ptUsuario2=s.crearAlumno("al", "al", "al", "al", "al");
        }
        
        
        
        //creacion de subforos
        ptSubforo=s.crearSubforo("el mejor subforo", (Profesor) ptUsuario1);
        
        {//creacion de entradas
        ptEntrada=s.crearEntrada(ptSubforo,ptUsuario1,"una entrada ejemplar 2", "");
        ptEntrada=s.crearEntrada(ptSubforo,ptUsuario2,"una entrada ejemplar", "");
        s.validarEntrada((Administrador) ptUsuario0, ptEntrada);
        //Completar la entrada
        ptEntrada.introducirTexto("mi vida", "mi vida es muy dura1");
        ptEntrada.introducirTexto("mi vida", "mi vida es muy dura2");
        ptEntrada.introducirTexto("mi vida", "mi vida es muy dura3");
        ptEncuesta=ptEntrada.introducirEncuesta("Una encuesta cualquiera",
                "Dame tu opinion del cambio climatico");
        }
        
        //respuestas a la encuesta (anonimas)
        
        {//valoracion de entrada
        ptEntrada.valorar(false);
        ptEntrada.valorar(false);
        ptEntrada.valorar(false);
        ptEntrada.valorar(false);
        }
        
        {//creacion de comentarios de entrada
        ptComentario=ptEntrada.comentar("es muy bonito1");
        //valoracion de comentarios
        ptComentario.valorar(true);
        ptComentario.valorar(true);
        }
        
        {//cracion de comentarios de comentarios
        ptComentario=ptComentario.comentar("cierto es muy bonito1");
        ptComentario=ptComentario.comentar("cierto es muy bonito2");
        ptComentario=ptComentario.comentar("cierto es muy bonito3");
        }

        
        s.guardar();
    }
   
}
