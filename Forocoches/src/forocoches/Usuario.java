/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forocoches;

import java.io.Serializable;

/**
 *
 * @author Eduardo
 */
public class Usuario implements Serializable{
    private final String nombre;
    private final String apellidos;
    private final String nick;
    private final String email;
    private final String contrasenna;
    private Penalizacion penalizacion; 

    public Usuario(String nombre, String apellidos, String nick, String email, String contrasenna) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nick = nick;
        this.email = email;
        this.contrasenna = contrasenna;
    }

     public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public Penalizacion getPenalizacion() {
        return penalizacion;
    }
     
}
