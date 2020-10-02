/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import javax.swing.ImageIcon;




/**
 *
 * @author tati
 */
public class Imagenes {

   
    private final ImageIcon imgPrincipal;

    public Imagenes() {

        //Imagen del icono
        this.imgPrincipal= new ImageIcon(this.getClass().getResource("/Imagenes/logo.gif"));
 
     
        
    }

    public ImageIcon getImgPrincipal() {
        return imgPrincipal;
    }
    
    
     
    
}
