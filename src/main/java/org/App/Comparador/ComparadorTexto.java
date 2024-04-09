package org.App.Comparador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparadorTexto extends JPanel {
    private JTextArea textArea1, textArea2;

    public ComparadorTexto() {

        setLayout(new GridLayout(1, 3));

        textArea1 = new JTextArea();
        textArea2 = new JTextArea();


        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);

        JButton compareButton = new JButton("Comparar");
        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido1 = textArea1.getText();
                String contenido2 = textArea2.getText();

                if (contenido1.equals(contenido2)) {
                    JOptionPane.showMessageDialog(ComparadorTexto.this, "Los textos son iguales", "Comparador de Texto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ComparadorTexto.this, "Los textos son diferentes", "Comparador de Texto", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        add(scrollPane1);
        add(compareButton);
        add(scrollPane2);
    }


}
