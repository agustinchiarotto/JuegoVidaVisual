/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


/**
 *
 * @author agus
 */
public class CasillaVisual {
    
  private  Casilla casilla;
  private int i,j;
  private   JButton boton;

    public CasillaVisual(final Casilla casilla, int i, int j) {
        this.casilla = casilla;
        this.i = i;
        this.j = j;
        this.boton = new JButton();  
        
        boton.setBounds(40+j*30, 20+i*30, 30, 30); //Primeros 2 parametros la pos. Ultimos 2 = tamaño
        boton.setBackground(Color.lightGray); //Color de Muerto
        
        
        
        
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               if(casilla.getEstoyVivo()) {
                casilla.setEstoyVivo(false);
                boton.setBackground(Color.lightGray);} //Color de Muerto
               else {
                   casilla.setEstoyVivo(true);
                   boton.setBackground(Color.red);
               }
               
            }

 
        });
        
        
    }

    public JButton getBoton() {
        return boton;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
    
    
    
    
    
}
