package org.App.EditorTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class NavegacionListado extends JPanel {

    private JList<String> documentList;
    private DefaultListModel<String> listModel;
    private JTextArea textArea;
    private JFileChooser fileChooser;


    public NavegacionListado() {

        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        documentList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(documentList);
        add(scrollPane, BorderLayout.WEST);

        textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);
        add(textScrollPane, BorderLayout.CENTER);

        fileChooser = new JFileChooser();

        JButton openButton = new JButton("Abrir");
        openButton.addActionListener(e -> {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                listModel.addElement(fileChooser.getSelectedFile().getName());
                textArea.setText("");
                textArea.append("Abrir archivo: " + fileChooser.getSelectedFile().getAbsolutePath() + "\n");
            }
        });

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> {
            int selectedIndex = documentList.getSelectedIndex();
            if (selectedIndex != -1) {
                int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar el archivo?", "Eliminar archivo", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(openButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.EAST);


    }

    private void cargarArchivo() {
        File archivo = new File(".");
        String[] archivos = archivo.list();
        listModel.clear();
        for (String nombreArchivo : archivos) {
            if (nombreArchivo.endsWith(".txt")) {
                listModel.addElement(nombreArchivo);
            }
        }
    }

    private void abrirArchivo(String nombreArchivo) {
        textArea.setText("");
        textArea.append("Abrir archivo: " + nombreArchivo + "\n");
    }

    private void eliminarArchivo(String nombreArchivo) {
        textArea.setText("");
        textArea.append("Eliminar archivo: " + nombreArchivo + "\n");
    }
    

}
