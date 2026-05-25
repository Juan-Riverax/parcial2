package Model;

import java.sql.Timestamp;

public class Prestamo {
    private int id;
    private Videogame videogame;
    private String cliente;
    private Timestamp fechaPrestamo;

    public Prestamo (int id, Videogame videogame, String cliente){
        this.id=id;
        this.videogame=videogame;
        this.cliente=cliente;
        this.fechaPrestamo=fechaPrestamo;
    }

    public Prestamo (Videogame videogame, String cliente){
        this.videogame=videogame;
        this.cliente=cliente;
    }

    public int getId() {
        return id;
    }

    public Videogame getVideogame() {
        return videogame;
    }

    public String getCliente() {
        return cliente;
    }

    public Timestamp getFechaPrestamo() {
        return fechaPrestamo;
    }
    @Override
    public String toString(){
        return "|   "+id+"  |   "+videogame+"    |   "+cliente+"  |   "+fechaPrestamo+"  |";
    }
}
