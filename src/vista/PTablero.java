package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PTablero extends JPanel implements MouseListener {

    Fprincipal principal;
    int n = 4;

    public PTablero(Fprincipal principal) {
        this.principal = principal;
        repaint();
        this.addMouseListener(this);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color c = new Color(255, 255, 0);
        g2d.setColor(c);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(new Color(0, 0, 0));
        
        Image image = Toolkit.getDefaultToolkit().getImage("data/luz.png");
        int widht = image.getWidth(this);
        int height = image.getHeight(this);

        boolean[][] casillas = principal.tablero.darTablero();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                g2d.drawRect((this.getWidth() / n) * i, (this.getHeight() / n) * j, this.getWidth() / n,
                        this.getHeight() / n);
                if (!casillas[i][j]) {
                    g2d.setColor(Color.LIGHT_GRAY);
                    g2d.fillRect((this.getWidth() / n) * i, (this.getHeight() / n) * j, this.getWidth() / n,
                            this.getHeight() / n);
                }
                g2d.setColor(new Color(0, 0, 0));
                g2d.drawImage(image, (this.getWidth() / n) * i + ((this.getWidth() / n) - (widht)) / 2,
                        (this.getHeight() / n) * j + ((this.getHeight() / n) - (height)) / 2, this);
            }

        }
    }

    public void actualizarTamanio(int tamanionuevo) {
        this.n = tamanionuevo;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        if(principal.name!=null){
            principal.jugarq(casilla[0], casilla[1]);
            repaint();
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre para poder jugar");
        }
        
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = n;
        int altoPanelTablero = this.getHeight();
        int anchoPanelTablero = this.getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}
