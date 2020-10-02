/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agus
 */
public class Hilo implements Runnable {
    
    private Tablero tablero;
    private boolean seguir;
    private int columna;

    public Hilo(Tablero tablero,int i) {
        this.tablero = tablero;
        this.seguir=true;
        this.columna=i;
    }

    @Override
    public void run() {
        
        while (seguir){
            try {
                tablero.ejecutarTurno(columna);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BrokenBarrierException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setSeguir(boolean seguir) {
        this.seguir = seguir;
    }
    
    
    
    
}
