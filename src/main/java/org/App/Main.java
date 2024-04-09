package org.App;

import org.App.EditorTextoInteractivo.*;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public class MainFrame extends JFrame {
        public MainFrame() {
            setTitle("Editor de texto y lista de documentos");
            setSize(800, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CreacionAlmacenamiento almacenamiento = new CreacionAlmacenamiento();
            NavegacionListado navegacion = new NavegacionListado();

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, almacenamiento, navegacion);
            splitPane.setResizeWeight(0.5);
            add(splitPane, "Center");
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new Main().new MainFrame();
            mainFrame.setVisible(true);
        });

    }

}