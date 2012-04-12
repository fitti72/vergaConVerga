/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.controladorServidor;

/**
 *
 * @author Owner
 */
public class iniciadorServidor {
    public static void main(String[] args) 
    {
        
        interfazServidor vista = new interfazServidor();        
        controladorServidor controlador = new controladorServidor(vista);
        controlador.iniciar_vista();
        vista.setVisible(true);
    }
    
}
