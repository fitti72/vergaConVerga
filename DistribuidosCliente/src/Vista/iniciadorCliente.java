/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.controladorCliente;

/**
 *
 * @author Owner
 */
public class iniciadorCliente 
{
    
    public static void main(String[] args) 
    {
        
        interfazCliente vista = new interfazCliente();        
        controladorCliente controlador = new controladorCliente(vista);
        controlador.iniciar_vista();
        vista.setVisible(true);
    }
    
}
