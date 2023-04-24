package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PDerecha extends JPanel implements ActionListener{

    private JButton btNuevo;
    private JButton btReiniciar;
    private JButton btTop;
    private JButton cambiarJugador;
    private Fprincipal principal;

    public PDerecha(Fprincipal principal) {
        this.principal = principal;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(160, 0));
        
        this.setBackground(Color.LIGHT_GRAY);

        Component spacer = Box.createRigidArea(new Dimension(0, 250));
        this.add(spacer);
        
        this.btNuevo = new JButton("Nuevo");
        this.btNuevo.addActionListener(this);
        this.btNuevo.setBackground(new Color(0,150,255));
        this.btNuevo.setForeground(Color.WHITE);
        btNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.btNuevo);

        Component spacer2 = Box.createRigidArea(new Dimension(0, 20));
        this.add(spacer2);

        this.btReiniciar = new JButton("Reiniciar");
        this.btReiniciar.addActionListener(this);
        this.btReiniciar.setBackground(new Color(0,150,255));
        this.btReiniciar.setForeground(Color.WHITE);
        btReiniciar.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.btReiniciar);

        Component spacer3 = Box.createRigidArea(new Dimension(0, 20));
        this.add(spacer3);

        this.btTop = new JButton("Top");
        this.btTop.addActionListener(this);
        this.btTop.setBackground(new Color(0,150,255));
        this.btTop.setForeground(Color.WHITE);
        btTop.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.btTop);

        Component spacer4 = Box.createRigidArea(new Dimension(0, 20));
        this.add(spacer4);

        this.cambiarJugador = new JButton("Cambiar Jugador");
        this.cambiarJugador.addActionListener(this);
        this.cambiarJugador.setBackground(new Color(0,150,255));
        this.cambiarJugador.setForeground(Color.WHITE);
        cambiarJugador.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.cambiarJugador);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        String texto = boton.getText();

        if (texto=="Nuevo"){
            principal.nuevoJuego();
        }
        else if (texto=="Reiniciar"){
            principal.reiniciarJuego();
        }
        else if (texto=="Top"){
            principal.mostrarTop();
        }
        else if (texto=="Cambiar Jugador"){
            principal.cambiarJugador();
        }
        
    }
    
}
