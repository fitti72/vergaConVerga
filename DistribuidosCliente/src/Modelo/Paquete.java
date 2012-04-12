/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Owner
 */
public class Paquete {
    public String ipOrigen;
    public String ipDestino;
    public String mensaje;
    public boolean esParaEnviar;

    public Paquete(String ipOrigen, String ipDestino, String mensaje, boolean esParaEnviar) {
        this.ipOrigen = ipOrigen;
        this.ipDestino = ipDestino;
        this.mensaje = mensaje;
        this.esParaEnviar = esParaEnviar;
    }

    public boolean isEsParaEnviar() {
        return esParaEnviar;
    }

    public void setEsParaEnviar(boolean esParaEnviar) {
        this.esParaEnviar = esParaEnviar;
    }

    public String getIpDestino() {
        return ipDestino;
    }

    public void setIpDestino(String ipDestino) {
        this.ipDestino = ipDestino;
    }

    public String getIpOrigen() {
        return ipOrigen;
    }

    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}
