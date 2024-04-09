package org.App.EditorTextoInteractivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;

public class CreacionAlmacenamiento extends JPanel {

    private JTextArea textArea;

    public CreacionAlmacenamiento() {
        textArea = new JTextArea();
        JButton openButton = new JButton("Abrir");
        JButton saveButton = new JButton("Guardar");
        JButton newButton = new JButton("Nuevo");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(saveButton);
        buttonPanel.add(openButton);
        buttonPanel.add(newButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Guardar archivo");
                int userSelection = fileChooser.showSaveDialog(CreacionAlmacenamiento.this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file != null) {
                        try {
                            FileWriter fileWriter = new FileWriter(file);
                            fileWriter.write(textArea.getText());
                            fileWriter.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Abrir archivo");
                int userSelection = fileChooser.showOpenDialog(CreacionAlmacenamiento.this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    if (file != null) {
                        try {
                            textArea.setText("");
                            textArea.append(new String(Files.readAllBytes(file.toPath())));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });



        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(CreacionAlmacenamiento.this, "Do you want to save the current file?");
                if (option == JOptionPane.YES_OPTION) {
                    saveButton.doClick();
                }
                textArea.setText("");
            }
        });

    }

    public void abrirArchivos(File file) {
        try {
            textArea.setText("");
            textArea.append(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}