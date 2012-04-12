/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Owner
 */
public class controladorCliente implements ActionListener
{
    
    private interfazCliente vista;
  

    public controladorCliente(interfazCliente vista) {
        this.vista = vista;         
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        
    }

    
    
    public void iniciar_vista(){
        vista.setTitle( "Sucursal- Distribuidos" );
        vista.setLocationRelativeTo(null);
        Sucursal.comoClienteDelServidorCentral("localhost",5000);
     }
    
    public void actionPerformed(ActionEvent e) {
       
            
        if (e.getActionCommand() == "Montar Servidor")
        {
            String puertoServidor = vista.jTextField1.getText();
            hiloCliente elHilo = new hiloCliente(Integer.parseInt(puertoServidor));       
            elHilo.start(); 
        }
        if (e.getActionCommand() == "Conectarme")
        {
            String ipConectar;
            int puertoConectar;
            puertoConectar=Integer.parseInt(vista.jTextField2.getText());
            ipConectar=vista.jTextField3.getText();        
            Sucursal.comoCliente(ipConectar,puertoConectar);
        }
        
        
        
        
        
        
        
     }
    
    
}
