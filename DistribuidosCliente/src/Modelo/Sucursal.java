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
import java.util.List;

/**
 *
 * @author Owner
 */
public class Sucursal {

    public String ipSucursal;
    public String ipServidor;
    public String ipSucursalSiguiente;
    public String ipSucursalAnterior;   
    public int puertoEntradaSiguiente;
    public int puertoEntradaAnterior;
    public int puertoServidor;
    public int cantidadTotalPaquetes; //puede ser tambien, paquetes entrada y paquetes salida
    public List listaPaquetesPorEnviar;
    public List listarPaquetesRecibidos;

    public Sucursal(String ipSucursal, String ipServidor, String ipSucursalSiguiente, String ipSucursalAnterior, int puertoEntradaSiguiente, int puertoEntradaAnterior, int puertoServidor, int cantidadTotalPaquetes, List listaPaquetesPorEnviar, List listarPaquetesRecibidos) {
        this.ipSucursal = ipSucursal;
        this.ipServidor = ipServidor;
        this.ipSucursalSiguiente = ipSucursalSiguiente;
        this.ipSucursalAnterior = ipSucursalAnterior;
        this.puertoEntradaSiguiente = puertoEntradaSiguiente;
        this.puertoEntradaAnterior = puertoEntradaAnterior;
        this.puertoServidor = puertoServidor;
        this.cantidadTotalPaquetes = cantidadTotalPaquetes;
        this.listaPaquetesPorEnviar = listaPaquetesPorEnviar;
        this.listarPaquetesRecibidos = listarPaquetesRecibidos;
    }

    public int getCantidadTotalPaquetes() {
        return cantidadTotalPaquetes;
    }

    public void setCantidadTotalPaquetes(int cantidadTotalPaquetes) {
        this.cantidadTotalPaquetes = cantidadTotalPaquetes;
    }

    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public String getIpSucursal() {
        return ipSucursal;
    }

    public void setIpSucursal(String ipSucursal) {
        this.ipSucursal = ipSucursal;
    }

    public String getIpSucursalAnterior() {
        return ipSucursalAnterior;
    }

    public void setIpSucursalAnterior(String ipSucursalAnterior) {
        this.ipSucursalAnterior = ipSucursalAnterior;
    }

    public String getIpSucursalSiguiente() {
        return ipSucursalSiguiente;
    }

    public void setIpSucursalSiguiente(String ipSucursalSiguiente) {
        this.ipSucursalSiguiente = ipSucursalSiguiente;
    }

    public List getListaPaquetesPorEnviar() {
        return listaPaquetesPorEnviar;
    }

    public void setListaPaquetesPorEnviar(List listaPaquetesPorEnviar) {
        this.listaPaquetesPorEnviar = listaPaquetesPorEnviar;
    }

    public List getListarPaquetesRecibidos() {
        return listarPaquetesRecibidos;
    }

    public void setListarPaquetesRecibidos(List listarPaquetesRecibidos) {
        this.listarPaquetesRecibidos = listarPaquetesRecibidos;
    }

    public int getPuertoEntradaAnterior() {
        return puertoEntradaAnterior;
    }

    public void setPuertoEntradaAnterior(int puertoEntradaAnterior) {
        this.puertoEntradaAnterior = puertoEntradaAnterior;
    }

    public int getPuertoEntradaSiguiente() {
        return puertoEntradaSiguiente;
    }

    public void setPuertoEntradaSiguiente(int puertoEntradaSiguiente) {
        this.puertoEntradaSiguiente = puertoEntradaSiguiente;
    }

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public void setPuertoServidor(int puertoServidor) {
        this.puertoServidor = puertoServidor;
    }
    
    
    
    
    
    
    



    //procedimientos para la conexion bro
    
    
    //procedimiento para levantar un puerto como servidor dentro de mi cliente
    public static void comoServidor(int puerto)
    {
        try 
        {
            // TODO code application logic here
            ServerSocket servicio = new ServerSocket(puerto);
            Socket socketServicio = null;
            
            System.out.println("Cliente Escuchando");
            //esperamos conexion
            boolean prueba = true;
            while(prueba) 
            {                
                socketServicio = servicio.accept();
                PrintWriter salida = new PrintWriter(socketServicio.getOutputStream(), true);//creo que hago un buffer donde almacenare lo que saldra
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));//defino un buffer para guardar
                                                                                                                    //lo que llegue. entrada

                //Object. aki m kedo guindao hasta q m manden algo
                String llego = entrada.readLine();//meto en un string lo que llegue
                System.out.println("lo que este cabezon mando fue: "+llego);
                
                salida.println("bueno ahora que dices, no te estoy mintiendo");

                
                String llego2 = entrada.readLine();
                System.out.println("2do mensaje es: "+llego2);
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
        } catch (IOException ex) 
        {
            System.out.println("Algo se daño:");
            ex.printStackTrace();
        }   
        
        
    }
    
    
    //parte en que mi cliente se conecta- cliente hace de cliente
    public static void comoCliente(String ip, int puerto)
    {        
        try 
        {            
            Socket cliente = new Socket(ip,puerto); //crea socket con ip y puerto
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            String nombreMaquinaCliente = address.getHostName();          
            String ipCliente = address.getHostAddress();
                
               

            salida.println("Cliente conectando, nombre: "+nombreMaquinaCliente+" direccionIP: "+ipCliente);
            System.out.println(" resp:" + entrada.readLine());
            
            //salida.close();
            //entrada.close();
            //cliente.close();

        } catch (Exception e) 
        {
            System.out.println("Problemas al enviar el mensaje");
            //e.printStackTrace();
        }        
        
        
    }
    
    public static void comoClienteDelServidorCentral(String ip, int puerto)
    {        
        try 
        {            
            Socket cliente = new Socket(ip,puerto); //crea socket con ip y puerto
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            String nombreMaquinaCliente = address.getHostName();          
            String ipCliente = address.getHostAddress();
                
               

            salida.println("Cliente conectando, nombre: "+nombreMaquinaCliente+" direccionIP: "+ipCliente);
            String puertoNuevo = entrada.readLine();
            System.out.println(" resp:" + puertoNuevo);
            int puertoNuevoEntero=Integer.parseInt(puertoNuevo);
            
            salida.close();
            entrada.close();
            cliente.close();
            
            Socket cliente2 = new Socket(ip,puertoNuevoEntero); //crea socket con ip y puerto
            PrintWriter salida2 = new PrintWriter(cliente2.getOutputStream(), true);
            BufferedReader entrada2 = new BufferedReader(new InputStreamReader(cliente2.getInputStream()));
            
            salida2.println("nuevaConexion papi: "+address);
            System.out.println(entrada2.readLine());
            
            

        } catch (Exception e) 
        {
            System.out.println("Problemas al enviar el mensaje");
            e.printStackTrace();
        }        
        
        
    }
       
    
//    public static void main(String[] args) 
//    {
//        
//        hilo elHilo = new hilo(5000);      
//        elHilo.start();               
//        System.out.println("Yo sigo a lo mio");
//        comoCliente("localhost",5010);       
//        
//    }
}