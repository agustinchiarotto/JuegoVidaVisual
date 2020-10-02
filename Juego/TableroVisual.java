/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;

/**
 *
 * @author agus
 */
public class TableroVisual implements Runnable{
    
     private CasillaVisual[][] tableroVisual;
     private Tablero tablero;

    public TableroVisual(Tablero tablero) {
        this.tableroVisual= new CasillaVisual[10][10];
        this.tablero=tablero;
          //Creo el tablero visual
        for (int auxi=1;auxi<9;auxi++){
           for (int auxj=1;auxj<9;auxj++){
               Casilla cas = tablero.getMatrix()[auxi][auxj];
               
               tableroVisual[auxi][auxj]= new CasillaVisual(cas,auxi,auxj);
            
           }
       }   
    
    }

    public CasillaVisual[][] getTableroVisual() {
        return tableroVisual;
    }
    
    
     
   

    @Override
    public void run() {
       
         final int nsPorSegundo= 1000000000; //Equivalencia
       
        final double nsPorActualizacion=nsPorSegundo/4; //Cuantos NS tienen que pasar para que actualice n veces por segundo.
        
        long referenciaActualizacion= System.nanoTime(); //Cuantos Ns pasaron desde enero de 1970 hasta que hace esta linea
        
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
        
        
       for (int auxi=1;auxi<9;auxi++){
           for (int auxj=1;auxj<9;auxj++){               
               if(tableroVisual[auxi][auxj].getCasilla().getEstoyVivo()){
                   tableroVisual[auxi][auxj].getBoton().setBackground(Color.red);
               }
               else
                tableroVisual[auxi][auxj].getBoton().setBackground(Color.lightGray);    
      
           }
     
     
            }
       
     
}

public void reiniciar(){
  
    for (int auxi=1;auxi<9;auxi++){
           for (int auxj=1;auxj<9;auxj++){
                   tableroVisual[auxi][auxj].getBoton().setBackground(Color.lightGray);
                   tablero.getMatrix()[auxi][auxj].setEstoyVivo(false);
                   
                   
                   
                   
  
           }
    
}}

}