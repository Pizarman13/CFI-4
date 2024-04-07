package org.App.EditorTextoInteractivo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class NavegacionListado extends JPanel {

    private JList<String> list;
    private DefaultListModel<String> listModel;
    private CreacionAlmacenamiento creacionAlmacenamiento;

    public NavegacionListado(CreacionAlmacenamiento creacionAlmacenamiento) {

        this.creacionAlmacenamiento = creacionAlmacenamiento;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


    }
}
