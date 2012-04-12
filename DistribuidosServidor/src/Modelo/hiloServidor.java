/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Owner
 */
public class hiloServidor extends Thread{

    int puerto;
    public String mensaje;
    
    public hiloServidor(int puerto) 
    {
       this.puerto = puerto;
       
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

   
    
    
    public void run()
    {      
        ServidorCentral.levantarPuertoRedireccionado(puerto);
        //ServidorCentral.levantarServidorCentral(puerto);        
    }

    
        
    
    
}
