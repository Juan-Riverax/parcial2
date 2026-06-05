package GUI;

import Model.Genero;
import Model.Videogame;
import Operations.VideogameDAO;
import Operations.archivoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class VideogamesUI {
    private JPanel panel1;
    private JLabel lbTitulo;
    private JLabel lbNombre;
    private JLabel lbGenero;
    private JTextField txtfldNombre;
    private JComboBox<Genero> cmbbxGenero;
    private JButton btnMostrarTodos;
    private JButton btnBuscarNombre;
    private JButton btnBuscarGenero;
    private JButton btnAgregarJuego;
    private JButton btnExportar;
    private JTable tblVideojuegos;
    private JButton btnId;
    private JTextField txtfldID;
    private List<Videogame> ultimaconsulta;

    private void llenarcombo(){
        for(Genero g: Genero.values()){
            cmbbxGenero.addItem(g);
        }
    }

    private void cargarTabla(List<Videogame> lista){
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Genero");
        modelo.addColumn("Precio");
        modelo.addColumn("Unidades");
        modelo.addColumn("ID_Desarrollador");

        for (Videogame v:lista){
            modelo.addRow(new Object[]{v.getId(),v.getName(),v.getGeneroS(),v.getPrecio(),v.getUnidades(),v.getId_desarrollador()});
        }
        tblVideojuegos.setModel(modelo);
    }

    private void cargarTabla(Videogame videogame){
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Genero");
        modelo.addColumn("Precio");
        modelo.addColumn("Unidades");
        modelo.addColumn("ID_Desarrollador");

            modelo.addRow(new Object[]{videogame.getId(),videogame.getName(),videogame.getGeneroS(),videogame.getPrecio(),videogame.getUnidades(),videogame.getId_desarrollador()});
        tblVideojuegos.setModel(modelo);
    }

    public VideogamesUI(){
        llenarcombo();
        btnMostrarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ultimaconsulta=VideogameDAO.getAllVideogames();
                cargarTabla(ultimaconsulta);
            }
        });
        btnBuscarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String nombre = txtfldNombre.getText();

            ultimaconsulta= VideogameDAO.getByName(nombre);
            cargarTabla(ultimaconsulta);
            }
        });
        btnBuscarGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Genero ge = (Genero) cmbbxGenero.getSelectedItem();
            ultimaconsulta= VideogameDAO.getByGenre(ge);
            cargarTabla(ultimaconsulta);
            }
        });
        btnAgregarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String nombre = JOptionPane.showInputDialog("Nombre del juego:");
            Genero genero = (Genero) JOptionPane.showInputDialog(null, "Seleccione el género", "Género", JOptionPane.QUESTION_MESSAGE, null, Genero.values(), Genero.values()[0]);
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del juego:"));
            int unidades = Integer.parseInt(JOptionPane.showInputDialog("Unidades del juego:"));
            String[] desarrolladores = {"1 - FromSoftware", "2 - Nintendo", "3 - Rockstar Games", "4 - Mojang", "5 - CD Projekt Red", "6 - Ubisoft", "7 - Valve", "8 - Capcom", "9 - Square Enix", "10 - Bethesda", "11 - Epic Games", "12 - Blizzard Entertainment", "13 - SEGA", "14 - Bandai Namco", "15 - Electronic Arts", "16 - Konami", "17 - Respawn Entertainment", "18 - Naughty Dog", "19 - Santa Monica Studio", "20 - Insomniac Games"};

            String seleccionado = (String) JOptionPane.showInputDialog(panel1, "Seleccione el desarrollador:", "Desarrolladores", JOptionPane.QUESTION_MESSAGE, null, desarrolladores, desarrolladores[0]);

                if (seleccionado == null) {
                    return;
                }

                int idDesarrollador = Integer.parseInt(seleccionado.split(" - ")[0]);

            Videogame v = new Videogame(nombre,genero,precio,unidades,idDesarrollador);

                System.out.println(idDesarrollador);
                VideogameDAO.insertVideogame(v);
                ultimaconsulta = VideogameDAO.getAllVideogames();
                cargarTabla(ultimaconsulta);
                JOptionPane.showMessageDialog(panel1, "Juego agregado correctamente");
            }
        });
        btnExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ultimaconsulta == null || ultimaconsulta.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "No hay datos para exportar.");
                    return;
                }

                try {
                    archivoDAO archivo = new archivoDAO("videojuegos.txt");
                    archivo.openFile();
                    archivo.writeVideogames(ultimaconsulta);
                    archivo.closeFile();
                    JOptionPane.showMessageDialog(panel1, "Archivo exportado correctamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel1, "Error al exportar: " + ex.getMessage());
                }
            }
        });


        btnId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtfldID.getText());

                Videogame v = VideogameDAO.getById(id);

                cargarTabla(v);

                ultimaconsulta = List.of(v);
            }
        });
    }
    public JPanel getPanel(){
        return panel1;
    }
}

