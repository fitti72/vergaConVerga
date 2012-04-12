/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ServidorCentral;
import Modelo.hiloServidor;
import Vista.interfazServidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Owner
 */
public class controladorServidor implements ActionListener{
    private interfazServidor vista;
    static int puertox = 5000;

    public controladorServidor(interfazServidor vista) {
        this.vista = vista;
        this.vista.jButton2.addActionListener(this);
    }

    
    public void iniciar_vista(){
        vista.setTitle( "Servidor Central- Distribuidos" );
        vista.setLocationRelativeTo(null);
              
        
     }
    
    
    
   
    public void actionPerformed(ActionEvent e) {
        
        //hiloServidor elHilo = new hiloServidor(puertox); 
        System.out.println("Servidor escuchando por el puerto: "+puertox);
        ServidorCentral.levantarServidorCentral(puertox); 
        //elHilo.start();      
            
            
        //ServidorCentral.levantarServidorCentral(5000);
    }
    
    
    
             
    
    
    
}
