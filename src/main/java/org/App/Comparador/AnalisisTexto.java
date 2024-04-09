package org.App.Comparador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalisisTexto extends JPanel {

    private JTextArea textArea;
    private JLabel label;

    public AnalisisTexto() {

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton analyzeButton = new JButton("Analizar");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido = textArea.getText();
                String[] palabras = contenido.split("\\s+");
                int cantidadPalabras = palabras.length;
                JOptionPane.showMessageDialog(AnalisisTexto.this, "Cantidad de palabras: " + cantidadPalabras, "Analisis de Texto", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        label = new JLabel("Cantidad de palabras: 0");
        add(label, BorderLayout.SOUTH);
        add(analyzeButton, BorderLayout.NORTH);
    }
}
