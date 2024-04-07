package org.App.EditorTextoInteractivo;

import javax.swing.*;

public class CreacionAlmacenamiento extends JPanel {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public CreacionAlmacenamiento() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, "Center");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem newItem = new JMenuItem("Nuevo");
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");
        JMenuItem saveAsItem = new JMenuItem("Guardar como");
        JMenuItem exitItem = new JMenuItem("Salir");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        add(menuBar, "First");

        fileChooser = new JFileChooser();

        newItem.addActionListener(e -> {
            textArea.setText("");
        });

        openItem.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                textArea.setText("");
                textArea.append("Abrir archivo: " + fileChooser.getSelectedFile().getAbsolutePath() + "\n");
            }
        });

        saveItem.addActionListener(e -> {
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                textArea.append("Guardar archivo: " + fileChooser.getSelectedFile().getAbsolutePath() + "\n");
            }
        });

        saveAsItem.addActionListener(e -> {
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                textArea.append("Guardar como archivo: " + fileChooser.getSelectedFile().getAbsolutePath() + "\n");
            }
        });

        exitItem.addActionListener(e -> {
            System.exit(0);
        });

    }

}