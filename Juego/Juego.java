/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author agus
 */
public class Juego {
    private Tablero tablero;
    private TableroVisual tableroVisual;
    private boolean enEjecucion;
    private Hilo[] hilos;

    public Juego() {
    }

    public Juego(Tablero tablero) {
        this.tablero = tablero;
        this.hilos= new Hilo[10];
        this.enEjecucion=false;
       
    }
    
    
   public   void iniciarMain() {
        JButton iniciar = new JButton("Iniciar");
        JButton detener = new JButton("Detener");
        JButton reiniciar = new JButton("Reiniciar");
        
       
        JFrame ventana = new JFrame("Chiaroto || Prandi || Moreno || Vicario");
        ventana.setSize(390, 520);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
	ventana.setResizable(false);
        
        
        tableroVisual = new TableroVisual(tablero);
        for (int auxi=1;auxi<9;auxi++){
           for (int auxj=1;auxj<9;auxj++){
               
               ventana.add(tableroVisual.getTableroVisual()[auxi][auxj].getBoton());
           }
       }   
        
        
        
        //Texto movimiento
        TextoMovimiento n = new TextoMovimiento(ventana);
        Thread texto= new Thread(n);
        texto.start();
        
        //Icono
        ImageIcon logo= new ImageIcon(this.getClass().getResource("/imagenes/Logo2.png"));
        ventana.setIconImage(logo.getImage());
        
        
        
        
        //Barra de menu
       
        JMenu menuArchivo= new JMenu("Archivo");
        menuArchivo.setFont(new Font(Font.SANS_SERIF,0,15));
	menuArchivo.setMnemonic('A');   
        JMenuBar barra= new JMenuBar();
        barra.add(menuArchivo);
    
        
    
        ventana.setJMenuBar(barra);
        
        //Para cerrar con la X
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        //Botones
        
         iniciar.setBounds(30,350,90,45);
         ventana.add(iniciar);
         iniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    if(!enEjecucion){
                        enEjecucion=true;
                        for(int aux=1;aux<10;aux++){
                        
                         Hilo hilo =new Hilo(tablero,aux);
                         Thread t = new Thread(hilo);
                         hilos[aux]=hilo;
                          t.start();
                    }}
                    Thread tab= new Thread(tableroVisual);
                    tab.start();
               }      
            });
         
         
         detener.setBounds(140,350,90,45);
         ventana.add(detener);
         detener.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                    if(enEjecucion){
                        enEjecucion=false;
                        for(int aux=1;aux<10;aux++){
                     try{   
                           
                         hilos[aux].setSeguir(false); }
                         
                          catch(Exception ee){
                          System.out.println("EL AUX QUE FALLA "+aux);}
       }}
               }
               
            }

 
        ); 
        
       
       reiniciar.setBounds(250,350,90,45);
      
       ventana.add(reiniciar);
       reiniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                        enEjecucion=false;
                        for(int aux=1;aux<10;aux++){
                     try{                        
                         hilos[aux].setSeguir(false);                                 
                     } 
                     catch(Exception ee){
                          System.out.println("EL AUX QUE FALLA "+aux);}
       }
           tableroVisual.reiniciar();
               }               
            }

 
        ); 
               
       
       
       
   }}
     
    
    
