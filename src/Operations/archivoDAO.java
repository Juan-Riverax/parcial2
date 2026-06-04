package Operations;

import Model.Videogame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class archivoDAO {
    public static void exportar(List<Videogame> lista){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ReporteVideojuegos.txt"))){
            for(Videogame v : lista){
                bw.write(v.toString());
                bw.newLine();
            }
            System.out.println("Reporte exportado correctamente.");
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
