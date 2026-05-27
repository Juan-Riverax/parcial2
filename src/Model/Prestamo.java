package Model;

import java.sql.Timestamp;

public class Prestamo {
    private int id;
    private int id_videogame;
    private String persona_alq;
    private Timestamp fecha;

    public Prestamo(){

    }

    public Prestamo (int id, int id_videogame, String persona_alq){
        this.id=id;
        this.id_videogame=id_videogame;
        this.persona_alq=persona_alq;
        this.fecha = new Timestamp(System.currentTimeMillis());
    }

    public Prestamo (int id_videogame, String persona_alq){
        this.id_videogame=id_videogame;
        this.persona_alq=persona_alq;
        this.fecha = new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public Prestamo (int id, String persona_alq, Timestamp fecha, int id_videogame){
        this.id=id;
        this.id_videogame=id_videogame;
        this.persona_alq=persona_alq;
        this.fecha = fecha;
    }

    public int getIdVideogame() {

        return id_videogame;
    }

    public String getPersonaAlq() {
        return persona_alq;
    }

    public Timestamp getFechaPrestamo() {
        return fecha;
    }



    public void setPersona_alq(String persona_alq) {
        this.persona_alq = persona_alq;
    }
    @Override
    public String toString(){
        return "|   "+id+"  |   "+fecha+"    |   "+persona_alq+"  |   "+id_videogame+"  |";
    }
}
