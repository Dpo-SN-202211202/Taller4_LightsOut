package vista;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;


import javax.swing.*;


import uniandes.dpoo.taller4.modelo.*;

public class Fprincipal extends JFrame implements WindowListener {
	private Pabajo pAbajo;
    private PDerecha pDerecha;
    private Parriba pArriba;
    private PTablero pTablero;
    Tablero tablero = new Tablero(4);
    Top10 top10=new Top10();
    int tamanio=4;
    int dificultad=1;
    String name;


	
	public Fprincipal() {
		this.setTitle("Lights Out");
		this.setSize(800,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.addWindowListener(this);
		

        this.pDerecha = new PDerecha(this);
        this.pAbajo = new Pabajo();
        this.pArriba = new Parriba(this);
        this.pTablero = new PTablero(this);
        this.top10.cargarRecords(new File("./data/top10.csv"));
		
		this.add(this.pDerecha, BorderLayout.EAST);
		this.add(this.pTablero, BorderLayout.CENTER);
		this.add(this.pAbajo, BorderLayout.SOUTH);
        this.add(this.pArriba, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Fprincipal(); 
	}

    public void nuevoJuego() {
        pTablero.actualizarTamanio(tamanio);
        tablero = new Tablero(tamanio);
        tablero.desordenar(dificultad);
        pTablero.repaint();
        cambiarJugador();
    }

    public void reiniciarJuego() {
        tablero.reiniciar();
        tablero.desordenar(dificultad);
        pTablero.repaint();
    }

    public void mostrarTop() {
        new Top(top10.darRegistros());
    }

    public void cambiarJugador() {
        String name=JOptionPane.showInputDialog("Ingrese su nombre");
        pAbajo.cambiarJugador(name);
        this.name=name;
    }

    public void jugarq(int i, int j) {
        tablero.jugar(j, i);
        pTablero.repaint();
        pAbajo.cambiarJugadas(tablero);
        if (tablero.tableroIluminado()) {
            int puntaje = tablero.calcularPuntaje();
            if (top10.esTop10(puntaje)){
                JOptionPane.showMessageDialog(null, "Ganaste, Haz entrado al top 10 con "+puntaje+" puntos");
                top10.agregarRegistro(this.name, puntaje);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ganaste, pero no entraste al top 10");}
        }
    }

    public void cambiarTablero(int n) {
        this.tamanio=n;
        pTablero.actualizarTamanio(n);
        tablero = new Tablero(tamanio);
        pAbajo.cambiarJugadas(tablero);
    }
    public void cambiarDificultad(int n) {
        this.dificultad=n;
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
    
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
 }

    @Override
    public void windowClosing(WindowEvent arg0) {
        // TODO Auto-generated method stub
        try {
            top10.salvarRecords(new File("./data/top10.csv"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } }

    @Override
    public void windowDeactivated(WindowEvent arg0) {

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {

    }

    @Override
    public void windowIconified(WindowEvent arg0) {
     
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
    }

    
   
}
