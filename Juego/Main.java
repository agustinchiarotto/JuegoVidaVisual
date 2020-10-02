
package Juego;

public class Main {
    

    public static void main(String[] args) {    
      
       Tablero tablero = new Tablero(10,10);  
       int i=10,j=10;
       for (int auxi=0;auxi<i;auxi++){
           for (int auxj=0;auxj<j;auxj++){
               
               tablero.getMatrix()[auxi][auxj]=new Casilla();
              
           }
           
       }
       
        Juego juego = new Juego(tablero);
        juego.iniciarMain();
 
        
      
    }

    
        
        
        
        
       
        
        
        
    
}
