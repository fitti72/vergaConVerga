/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Owner
 */
public class Transporte {
    public Paquete paquete1;
    public Paquete paquete2;

    public Transporte(Paquete paquete1, Paquete paquete2) {
        this.paquete1 = paquete1;
        this.paquete2 = paquete2;
    }

    public Paquete getPaquete1() {
        return paquete1;
    }

    public void setPaquete1(Paquete paquete1) {
        this.paquete1 = paquete1;
    }

    public Paquete getPaquete2() {
        return paquete2;
    }

    public void setPaquete2(Paquete paquete2) {
        this.paquete2 = paquete2;
    }
    
    
    
}
