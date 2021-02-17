/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forocoches;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
/**
 * 
 * Esta clase será la encargada de almacenarlo todo de forma que jaja no se que escribir
 * asi que me dedicare simplemente a poner un monton de relleno sin sentido para
 * que cuando me dedique a revisar el codigo vea un monton de lineas bonitas simbolizando
 * que he codificado correctamente al poner mucha documentacion xd
 */
public final class Sistema implements Serializable{
    private ArrayList<Subforo> subforos=new ArrayList<>();
    private ArrayList<Usuario> usuarios=new ArrayList<>();
    private ArrayList<Entrada> noValidadas=new ArrayList<>();

    /**
     * Guardará el objeto de tipo sistema entrante en un fichero
     */
    public void guardar() {
        String Fichero="Datos.Obj";
        try{
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(Fichero));
            oos.writeObject(this);
        }
        catch(IOException e){
            System.out.println("No se pudo guardar el sistema. ERROR: "+e);
        }  
    }
    /**
     * 
     * @return un objeto que ha leido en el disco si existe en caso contrario
     * mantiene el objeto actual, es decir, mantiene el nuevo
     */
    public Sistema cargar() {
        String Fichero="Datos.Obj";
        Sistema aux;
        try{
            ObjectInputStream ois= new ObjectInputStream(new FileInputStream(Fichero));
            try{
                aux= (Sistema) ois.readObject();
                return aux;
            }
            catch(IOException | ClassNotFoundException e){
                System.out.println("No se pudo cargar el sistema. ERROR: "+e);
            }
        }
        catch(IOException e){
            System.out.println("No se pudo cargar el sistema. ERROR: "+e);
        }
        return this;
    }
    /**
     * 
     * @param nombreSubforo 
     * @param profesor profesor que se registra como creador del subforo
     * @return el subforo que ha creado y si no, un null
     */
    public Subforo crearSubforo(String nombreSubforo,Profesor profesor){
        if (buscarSubforo(nombreSubforo)!=null){
            return null;
        }
        else{
            Subforo sf=new Subforo(nombreSubforo,profesor);
            subforos.add(sf); 
            return sf; 
        }
    }
    /**
     * 
     * @param subforo es el subforo donde se va a crear la entrada
     * @param usuario es el usurio que se registrara como creador de entrada
     * @param nombreEntrada Será el nombre de la entrada que se crerá dentro
     * del subforo. Su "identificador"
     * @param txtEntrada
     * @return la entrada creada y si no, un null
     */
    public Entrada crearEntrada(Subforo subforo,Usuario usuario,
    String nombreEntrada,String txtEntrada){
        if (buscarSubforo(subforo.getNombre())!=null){
            if (usuario instanceof Alumno){
                Entrada e= new Entrada(nombreEntrada,txtEntrada,usuario,false);
                subforo.crearEntrada(e);
                //Entrada ptEntrada=e;
                noValidadas.add(e);
                return e;
            }
            else{
                Entrada e= new Entrada(nombreEntrada,txtEntrada,usuario,true);
                subforo.crearEntrada(e);
                return e;
            }
        }
        return null;
    }
    
    private Subforo buscarSubforo (String nombreSubforo){
        int i=0;
        while (i<subforos.size()){
            if (subforos.get(i).getNombre().equals(nombreSubforo)){
                return subforos.get(i);           
            }
        }
        return null;
    }
    public boolean validarEntrada(Administrador admin,Entrada e){
        if (!e.isValidada()){
            e.setValidada(true);
            noValidadas.remove(e);
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public Usuario crearAlumno(String s1,String s2,String s3, String s4, String s5){
        Usuario u=new Alumno(s1,s2,s3,s4,s5);  
        usuarios.add(u);
        return u;
    }
    public Usuario crearProfesor(String s1,String s2,String s3, String s4, String s5){
        Usuario u=new Profesor(s1,s2,s3,s4,s5);  
        usuarios.add(u);
        return u;
    }
    public Usuario crearAdministrador(String s1,String s2,String s3, String s4, String s5){
        Usuario u=new Administrador(s1,s2,s3,s4,s5);  
        usuarios.add(u);
        return u;
    }
    public Usuario iniciarSesion(String email, String password){
        int i=0;
        while (0<usuarios.size()){
            if (usuarios.get(i).getEmail().equals(email)){
                if (usuarios.get(i).getContrasenna().equals(password)){
                    return usuarios.get(i);
                }
                return null;
            }
        }
        i++;
        return null;
    }
    
    
}
