package org.App;

import org.App.EditorTextoInteractivo.*;
import org.App.Comparador.*;
import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Crear una instancia de CreacionAlmacenamiento
            CreacionAlmacenamiento creacionAlmacenamiento = new CreacionAlmacenamiento();

            // Crear una instancia de NavegacionListado
            NavegacionListado navegacionListado = new NavegacionListado();

            // Crear un JFrame para contener ambas clases
            JFrame frame = new JFrame("Editor de Texto Interactivo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Agregar CreacionAlmacenamiento y NavegacionListado al JFrame
            frame.getContentPane().add(creacionAlmacenamiento, BorderLayout.WEST);
            frame.getContentPane().add(navegacionListado, BorderLayout.EAST);

            // Configurar el JFrame y mostrarlo
            frame.pack();
            frame.setSize(800, 400); // Tamaño arbitrario
            frame.setLocationRelativeTo(null); // Centrar en la pantalla
            frame.setVisible(true);
            frame.add(creacionAlmacenamiento, BorderLayout.CENTER);

            // Crear una instancia de ComparadorTexto
            ComparadorTexto comparadorTexto = new ComparadorTexto();

            // Crear una instancia de AnalisisTexto
            AnalisisTexto analisisTexto = new AnalisisTexto();

            // Crear un JFrame para contener ambas clases
            JFrame frame2 = new JFrame("Comparador y Analisis de Texto");
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Agregar ComparadorTexto y AnalisisTexto al JFrame
            frame2.getContentPane().add(comparadorTexto, BorderLayout.WEST);
            frame2.getContentPane().add(analisisTexto, BorderLayout.EAST);

            // Configurar el JFrame y mostrarlo
            frame2.pack();
            frame2.setSize(800, 400); // Tamaño arbitrario
            frame2.setLocationRelativeTo(null); // Centrar en la pantalla
            frame2.setVisible(true);
            frame2.add(comparadorTexto, BorderLayout.CENTER);

            
        });
    }

    }

