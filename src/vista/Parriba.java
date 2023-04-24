package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Parriba extends JPanel implements ActionListener{
    private JLabel tamano;
    private JComboBox<String> tTamano;
    private JLabel dificultad;
    private JRadioButton facil;
    private JRadioButton medio;
    private JRadioButton dificil;
    private Fprincipal principal;

    public Parriba(Fprincipal principal) {
        this.principal = principal;
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(0,150,255));

		this.tamano = new JLabel("Size:");
        tamano.setBackground(new Color(0,150,255));
        tamano.setFont(new Font("Helvetica", 1, 20));
        tamano.setForeground(Color.WHITE);
		this.add(this.tamano);

        String[] elementos = {"4x4","5x5", "6x6", "7x7", "8x8", "9x9"};
        tTamano = new JComboBox<>(elementos);
        tTamano.addActionListener(this);
        this.add(this.tTamano);

        JLabel spacer = new JLabel("");
        spacer.setPreferredSize(new Dimension(30, 0));
        this.add(spacer);

        this.dificultad = new JLabel("Dificultad:");
        dificultad.setBackground(new Color(0,150,255));
        dificultad.setFont(new Font("Helvetica", 1, 20));
        dificultad.setForeground(Color.WHITE);
		this.add(this.dificultad);

        this.facil = new JRadioButton("Easy");
        facil.setBackground(new Color(0,150,255));
        facil.setFont(new Font("Helvetica", 0, 16));
        facil.setForeground(Color.WHITE);
        facil.setSelected(true);
        facil.addActionListener(this);
        this.add(this.facil);

        this.medio = new JRadioButton("Medium");
        medio.setBackground(new Color(0,150,255));
        medio.setFont(new Font("Helvetica", 0, 16));
        medio.setForeground(Color.WHITE);
        medio.addActionListener(this);
        this.add(this.medio);

        this.dificil = new JRadioButton("Hard");
        dificil.setBackground(new Color(0,150,255));
        dificil.setFont(new Font("Helvetica", 0, 16));
        dificil.setForeground(Color.WHITE);
        dificil.addActionListener(this);
        this.add(this.dificil);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(facil);
        grupo.add(medio);
        grupo.add(dificil);


        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = (String) tTamano.getSelectedItem();
        principal.cambiarTablero(Character.getNumericValue(selected.charAt(0)));

        if(facil.isSelected()){
            principal.cambiarDificultad(3);
            medio.setSelected(false);
            dificil.setSelected(false);
        }
        else if(medio.isSelected()){
            principal.cambiarDificultad(5);
            facil.setSelected(false);
            dificil.setSelected(false);
        }
        else if(dificil.isSelected()){
            principal.cambiarDificultad(9);
            facil.setSelected(false);
            medio.setSelected(false);
        }

           
        
    }
    
}
