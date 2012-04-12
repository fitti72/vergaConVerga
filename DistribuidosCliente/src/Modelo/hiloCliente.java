/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Owner
 */
public class hiloCliente extends Thread{

    int puerto;
    
    public hiloCliente(int puerto) 
    {
       this.puerto = puerto;
    }  
    
    
    public void run()
    {
        Sucursal.comoServidor(puerto);
    }

    
        
    
    
}
