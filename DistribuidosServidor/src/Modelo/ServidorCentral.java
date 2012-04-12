/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Owner
 */
public class ServidorCentral {
    
    public static List<String> listaNodos;
    public static List<hiloServidor> listaHilos = new ArrayList<hiloServidor>();
   
   
    
    public ServidorCentral(List listaNodos, List listaHilos) {
        ServidorCentral.listaNodos = listaNodos;
        ServidorCentral.listaHilos = listaHilos;
    }

    public List getListaNodos() {
        return listaNodos;
    }

    public void setListaNodos(List listaNodos) {
        ServidorCentral.listaNodos = listaNodos;
    }

    public static List<hiloServidor> getListaHilos() {
        return listaHilos;
    }

    public static void setListaHilos(List<hiloServidor> listaHilos) {
        ServidorCentral.listaHilos = listaHilos;
    }
    
    
   
    
    
    
    public static void levantarServidorCentral(int puerto)
    {
        List<String> listaNodos = new ArrayList<String>();
        //List<hiloServidor> listaHilos = new ArrayList<hiloServidor>();
       
       
        try
        {            
            ServerSocket servicio = new ServerSocket(puerto);
            Socket socketServicio = null;
            
            System.out.println("Servidor Central");
            boolean prueba = true;
            int puertoRedireccion = 10000;
            while(prueba) 
            {                
                socketServicio = servicio.accept();
                PrintWriter salida = new PrintWriter(socketServicio.getOutputStream(), true);//creo que hago un buffer donde almacenare lo que saldra
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));//defino un buffer para guardar
                                        
                //aki m kedo guindao hasta q alguien se conecte y me mande algodon
                String llego = entrada.readLine();//meto en un string lo que llegue
                String infoNodo = llego;
                System.out.println("Recibo: "+infoNodo);
                
                                
                listaNodos.add(infoNodo+" "+puertoRedireccion);                
                
                hiloServidor elHilo = new hiloServidor(puertoRedireccion);
                elHilo.setMensaje("nada");
                listaHilos.add(elHilo);
                
                elHilo.start(); 
                
                salida.println(+puertoRedireccion);
                puertoRedireccion++;

                //salida.close();
                //entrada.close();
                //socketServicio.close();
                
                
                Iterator iter = listaNodos.iterator();                
                System.out.println("ahora imprimire la lista");
                int k=0;
                
                while (iter.hasNext())
                {
                    System.out.println(iter.next());
                    k++;
                }
                System.out.println("ya imprimi la lista de nodos: k= "+k);
                
                if (k >= 3)
                {
                    //mandarDatosANodos(listaNodos);
                    Iterator iterListaHilos = listaHilos.iterator();
                    while (iterListaHilos.hasNext())
                    {
                        hiloServidor a = (hiloServidor) iterListaHilos.next();
                        
                        System.out.println("el mensaje seteado de: "+a.puerto+" es "+a.getMensaje());
                        a.setMensaje("YA HAY 3 NODOS");
                    }
                    //elHilo.setMensaje("ya hay 3 nodos daddy");
                }       
                
                
             
                
               

                if(llego.equals("cierrate")) 
                {
                    break;
                }
            }            
            servicio.close();
            System.out.println("Me apague");
        }catch (IOException ex) 
        {
            System.out.println("Algo se daño:");
            ex.printStackTrace();
        }
          
        
    }
    
    public static void levantarPuertoRedireccionado(int puerto)
    {
        try
        {         
            
            ServerSocket servicio = new ServerSocket(puerto);
            Socket socketServicio = null;
            int pete = 0;
            
            boolean prueba = true;
            while(prueba) 
            {           
                
                
                Iterator iterListaHilos2 = listaHilos.iterator();
                while (iterListaHilos2.hasNext())
                {
                    hiloServidor a2 = (hiloServidor) iterListaHilos2.next();
                    if (a2.puerto == puerto)
                        System.out.println("el puerto es: "+puerto+" su mensaje es: "+a2.getMensaje());
                        
                   
                    }
                
                
               
                
                pete++;
                System.out.println("CHEQUEANDO MENSAJE SETEADO A CADA NODO DE LISTANODO: ");

                socketServicio = servicio.accept();
                PrintWriter salida = new PrintWriter(socketServicio.getOutputStream(), true);//creo que hago un buffer donde almacenare lo que saldra
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));//defino un buffer para guardar
                                        
                System.out.println("esperando que se m conecten al puerto nuevo: "+puerto);
                String llego = entrada.readLine();//meto en un string lo que llegue
                String infoNodo = llego+" "+puerto;
                System.out.println("Recibo: "+infoNodo);
                salida.println("mensaje confirmacion");
                System.out.println("listo ya alguien se conecto a mi puerto redireccionado: "+puerto);
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
               
                //salida.close();
                //entrada.close();
                //socketServicio.close();

                if(llego.equals("cierrate")) 
                {
                    break;
                }

            }

            
            servicio.close();
            System.out.println("Me apague");
        }catch (IOException ex) 
        {
            System.out.println("Algo se daño:");
            ex.printStackTrace();
        }
    }
    
    
    
    public static void mandarDatosANodos(List lista) throws IOException
    {
        System.out.println("pruebitax");
        Iterator iter = lista.iterator();
        System.out.println("ahora imprimire la lista");
        while (iter.hasNext())
        {
            System.out.println(iter.next());                
        }
        System.out.println("ya imprimir la lista");  
        
                
                
    }
}
