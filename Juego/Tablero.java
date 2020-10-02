/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author agus
 */
public class Tablero {
    
    private final Casilla [][] matrix;
    private final CyclicBarrier contador;
    private final int i;
    private final int j;
    
    
   

    public Tablero(int i, int j) {
        this.matrix = new Casilla [i][j];
        this.contador = new CyclicBarrier(i-1,null);
        this.i=i;
        this.j=j;
    }

    public Casilla[][] getMatrix() {
        return matrix;
    }
    
    public void ejecutarTurno(int i) throws InterruptedException, BrokenBarrierException{
        for(int aux=0;aux<j;aux++){
            
            verificar(i,aux);}
        contador.await();        
        for(int aux=0;aux<j-1;aux++)
            actualizar(matrix[i][aux]);
        contador.await();    
        if(i==1)
            System.out.println(this.toString());
                    
    }

    private void verificar(int i, int j) {        
       
       int cantidadVivas=0;
       try { 
           //Cuento la cantidad de celulas vivas alrededor
           for(int aux =j;aux<j+3;aux++){
               
               if(matrix[i-1][aux-1].getEstoyVivo())
                   cantidadVivas++;
                
           }
           
           
           for(int aux =j;aux<j+3;aux++){
              
               if(matrix[i+1][aux-1].getEstoyVivo())
                   cantidadVivas++;}
               
           
           if(matrix[i][j-1].getEstoyVivo())
               cantidadVivas++;
           
           if(matrix[i][j+1].getEstoyVivo())
               cantidadVivas++;
           
           //Primer caso para celula muerta en este turno 
           if(!matrix[i][j].getEstoyVivo()){
               if(cantidadVivas==3)
                   matrix[i][j].setTengoQueActualizar(true);
           }
           //Caso que para celula viva en este turno
      
           
           else{
               matrix[i][j].setTengoQueActualizar(true); //Primero la mato siempre
               if(cantidadVivas == 2 || cantidadVivas == 3)
                       matrix[i][j].setTengoQueActualizar(false); //Luego la revivo si cumple la regla
           }
           
     }    
       catch (Exception e){
           System.out.println("FUERA DE RANGO PARA "+i+" "+j);
     
           
       }
       
    }

    private void actualizar(Casilla casilla) {
        
           if(casilla.getTengoQueActualizar()){
               boolean aux = casilla.getEstoyVivo();
                   casilla.setEstoyVivo(!aux);
               casilla.setTengoQueActualizar(false);
           }
           
    }

    @Override
    public String toString() {
        String cadena ="";
        
       for (int auxi=0;auxi<i;auxi++){
           for (int auxj=0;auxj<j;auxj++){
              // cadena+=" "+auxi+" ; "+auxj+" :";
            // cadena+= " "+matrix[auxi][auxj].getEstoyVivo()+" ";
               if( matrix[auxi][auxj].getEstoyVivo())
                  cadena+= " 1 ";
              else cadena+= " 0 ";
           }
           cadena += "\n";
       }
        return cadena;
    }
    
 
    
    
}
