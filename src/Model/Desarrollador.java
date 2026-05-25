package Model;

public class Desarrollador {
    private int id;
    private String name;
    private String pais;

    public Desarrollador (int id, String name, String pais){
        this.id=id;
        this.name=name;
        this.pais=pais;
    }

    public Desarrollador (String name, String pais){
        this.name=name;
        this.pais=pais;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPais() {
        return pais;
    }
    @Override
    public String toString(){
        return "|   "+id+"  |   "+name+"    |   "+pais+"  |";
    }
}
