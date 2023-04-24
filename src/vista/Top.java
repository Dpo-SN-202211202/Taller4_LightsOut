package vista;

import java.awt.BorderLayout;
import java.awt.*;
import java.util.Collection;

import javax.swing.*;
import javax.swing.border.*;

import uniandes.dpoo.taller4.modelo.*;

public class Top extends JFrame {
    private JPanel title;
    private JPanel puntos;
    

    public Top(Collection<RegistroTop10> top10) {
        

        class CustomListCellRenderer extends DefaultListCellRenderer {
            private final Border CELL_BORDER = new CompoundBorder(
            new LineBorder(Color.BLACK),
            new EmptyBorder(5, 5, 5, 5)
            );

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    renderer.setBackground(Color.CYAN); // set selected cell background color
                } else {
                    renderer.setBackground(list.getBackground()); // set unselected cell background color
                }
                if (index==0){
                    renderer.setForeground(new Color(0, 150,0 ));
                }
                else if (index==1){
                    renderer.setForeground(Color.red);
                }
                else if (index==2){
                    renderer.setForeground(Color.blue);
                }
                else{
                    renderer.setForeground(Color.black);
                }
                renderer.setFont(new Font("Helvetica", 0, 24));
                ((JComponent) renderer).setBorder(CELL_BORDER);
                return renderer;
            }
        }

        this.setTitle("Top 10");
        this.setResizable(false);
        this.setSize(300, 401);
        this.setLayout(new BorderLayout());

        this.title = new JPanel();
        this.title.add(new JLabel("Position         Name        Points")).setForeground(Color.WHITE);
        this.title.setBackground(Color.BLUE);
        this.add(this.title, BorderLayout.NORTH);

        this.puntos = new JPanel(new BorderLayout());

        String[] elementos = new String[10];

        int pos = 1;
        for (RegistroTop10 i : top10) {
            String panelito = (pos + ".     " + i.darNombre() + "               " + i.darPuntos());
            elementos[pos - 1] = panelito;
            pos++;
        }

        JList<String> list = new JList<>(elementos);
        list.setCellRenderer(new CustomListCellRenderer());
        list.setLayoutOrientation(JList.VERTICAL);
        list.setAlignmentX(CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300)); // Establece el tamaño preferido del scrollPane

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFont(new Font("Helvetica", Font.PLAIN, 16)); // Establece la fuente y el tamaño del texto en la lista
        list.setBackground(new Color(240, 240, 240)); // Establece el color de fondo de la lista
        list.setForeground(new Color(30, 30, 30)); // Establece el color del texto en la lista

        this.puntos.add(scrollPane, BorderLayout.CENTER);
        this.add(this.puntos, BorderLayout.CENTER);
        this.setVisible(true);

    }

}
