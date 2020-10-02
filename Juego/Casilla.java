/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author agus
 */
public class Casilla {
    
    private boolean estoyVivo;
    private boolean tengoQueActualizar;

    public Casilla() {
    
        this.estoyVivo=false;
        this.tengoQueActualizar=false;
        
    }

    public void setEstoyVivo(boolean estoyVivo) {
        this.estoyVivo = estoyVivo;
    }

    public void setTengoQueActualizar(boolean tengoQueActualizar) {
        this.tengoQueActualizar = tengoQueActualizar;
    }

    public boolean getEstoyVivo() {
        return estoyVivo;
    }

    public boolean getTengoQueActualizar() {
        return tengoQueActualizar;
    }
    
    
    
    
    
    
}
