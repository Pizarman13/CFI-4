package org.App.EditorTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;



public class NavegacionListado extends JPanel {

    private JList<String> documentList;
    private DefaultListModel<String> listModel;
    private CreacionAlmacenamiento almacenamiento;
    private static final String DOCUMENTS_PATH = "usuario/diego/documents";


    public NavegacionListado() {

        setLayout(new BorderLayout());
        this.almacenamiento = almacenamiento;

        listModel = new DefaultListModel<>();
        documentList = new JList<>(listModel);
        documentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        documentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String fileName = documentList.getSelectedValue();
                    File file = new File(DOCUMENTS_PATH + "/" + fileName);
                    almacenamiento.abrirArchivos(file);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(documentList);
        add(scrollPane, BorderLayout.CENTER);

        // cargar documentos
        cargarDocumentos();
    }

    public void cargarDocumentos() {
        File directory = new File(DOCUMENTS_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    listModel.addElement(file.getName());
                }
            }
        }
    }

}
