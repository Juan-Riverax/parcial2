package Model;

import java.sql.Timestamp;

public class Prestamo {
    private int id;
    private int id_videogame;
    private String cliente;
    private Timestamp fechaPrestamo;

    public Prestamo(){

    }

    public Prestamo (int id, int id_videogame, String cliente){
        this.id=id;
        this.id_videogame=Videogame.getId();
        this.cliente=cliente;
        this.fechaPrestamo=fechaPrestamo;
    }

    public Prestamo (int id_videogame, String cliente){
        this.id_videogame=Videogame.getId();
        this.cliente=cliente;
    }

    public int getId() {
        return id;
    }

    public int getVideogame() {
        return id_videogame;
    }

    public String getCliente() {
        return cliente;
    }

    public Timestamp getFechaPrestamo() {
        return fechaPrestamo;
    }

    public int getId_videogame(){
        return id_videogame;
    }
    @Override
    public String toString(){
        return "|   "+id+"  |   "+id_videogame+"    |   "+cliente+"  |   "+fechaPrestamo+"  |";
    }
}
