package vista;

import java.awt.*;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Pabajo extends JPanel {

    private JLabel jugadas;
    private JLabel cjugadas;
    private JLabel jugador;
    private JLabel nombrejugador;
    


    public Pabajo() {
        this.setLayout(new GridLayout(1,4,10,0));
        this.setPreferredSize(new Dimension(this.getPreferredSize().width, 40));   

		this.jugadas = new JLabel("        Jugadas: ");
        jugadas.setFont(new Font("Helvetica", 1, 20));
		this.add(this.jugadas);

        this.cjugadas = new JLabel("0");
        cjugadas.setFont(new Font("Helvetica", 1, 20));
        this.add(this.cjugadas);

        this.jugador = new JLabel("        Jugador: ");
        jugador.setFont(new Font("Helvetica", 1, 20));
        this.add(this.jugador);

        this.nombrejugador = new JLabel();
        nombrejugador.setFont(new Font("Helvetica", 1, 20));
        this.add(this.nombrejugador);
    }


    public void cambiarJugador(String name) {
        this.nombrejugador.setText(name);
    }

    public void cambiarJugadas(Tablero tablero) {
        int jugadas=tablero.darJugadas();
        this.cjugadas.setText(Integer.toString(jugadas));
    }
    
}
