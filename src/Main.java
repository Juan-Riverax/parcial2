import GUI.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Para que se vea con el look & feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear ventana
        JFrame frame = new JFrame("Gestión de Videojuegos");
        frame.setContentPane(new VideogamesUI().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta al tamaño preferido de los componentes
        frame.setLocationRelativeTo(null); // Centrar en pantalla
        frame.setVisible(true);
    }
}

