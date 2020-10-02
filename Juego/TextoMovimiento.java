/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author agus
 */
public class TextoMovimiento implements Runnable{
    
    private JLabel label;
    private int inicio=700;
    private JFrame ventana;

    public TextoMovimiento(JFrame ventana) {
     this.label= new JLabel("Juego de la vida");
     this.ventana=ventana; 
    label.setBounds(400, 10, 700, 20);
    
    label.setFont(new Font(Font.SANS_SERIF,0,15));        
    this.ventana.add(label);
    }

    
    

    @Override
    public void run() {
        
        
        
        final int nsPorSegundo= 1000000000; //Equivalencia
       
        final double nsPorActualizacion=nsPorSegundo/20; //Cuantos NS tienen que pasar para que actualice 2 veces por segundo.
        
        long referenciaActualizacion= System.nanoTime(); //Cuantos Ns pasaron desde enero de 1970 hasta que hace esta linea
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido;
        double delta = 0; //Cantidad de tiempo que paso desde la ultima act.
       
       
         
        System.nanoTime();
        while(true){
            final long inicioBucle=System.nanoTime(); //momento que inicia el bucle
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion=inicioBucle;
            
            delta = delta + tiempoTranscurrido / nsPorActualizacion;
            
            while(delta >=1){
                actualizar();
                delta--;
            }
        
        
    }
    
    
    
    }

    private void actualizar() {
             
               label.setText("");
                inicio= inicio - 5;    
                if (inicio <= -200)
                    inicio = 400;
                
                label.setText(" Juego de la vida ");
                label.setBounds(inicio, 10, 700, 20);
                
            }
        
    
}
