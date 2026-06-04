package Operations;

import Model.Videogame;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class archivoDAO {

    private String fileName;
    private BufferedWriter writer;

    public archivoDAO(String fileName) {
        this.fileName = fileName;
    }

    public void openFile() throws IOException {
        writer = new BufferedWriter(new FileWriter(fileName));
    }

    public void writeToFile(String content) throws IOException {
        if (writer == null) {
            throw new IllegalStateException("File is not open. Call openFile() first.");
        }
        writer.write(content);
    }

    public void writeVideogames(List<Videogame> lista) throws IOException {
        if (writer == null) {
            throw new IllegalStateException("File is not open. Call openFile() first.");
        }
        // Cabecera
        writer.write("ID,Nombre,Género,Precio,Unidades,ID_Desarrollador\n");
        // Filas
        for (Videogame v : lista) {
            writer.write(v.getId() + "," +
                    v.getName() + "," +
                    v.getGeneroS() + "," +
                    v.getPrecio() + "," +
                    v.getUnidades() + "," +
                    v.getId_desarrollador() + "\n");
        }
    }

    public void closeFile() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}

