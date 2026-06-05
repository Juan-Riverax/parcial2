package Model;

public class Videogame { //clase vidiojuego
    private int id;
    private String name;
    private String genero;
    private Genero generoG;
    private double precio;
    private int unidades;
    private int id_desarrollador;

    public Videogame (int id,String name, String genero,double precio, int unidades, int id_desarrollador) {
        this.id=id;
        this.name=name;
        this.generoG=Genero.valueOf(genero);
        this.precio=precio;
        this.unidades=unidades;
        this.id_desarrollador=id_desarrollador;
    }

    public Videogame (String name, Genero generoG,double precio, int unidades, int id_desarrollador) {
        this.name=name;
        this.generoG=generoG;
        this.precio=precio;
        this.unidades=unidades;
        this.id_desarrollador=id_desarrollador;
    }

    public int getId() {return id;}
    public String getName(){
        return name;
    }
    public String getGeneroS(){
        return String.valueOf(genero);
    }
    public double getPrecio(){
        return precio;
    }
    public int getUnidades() {
        return unidades;
    }
    public int getId_desarrollador() {
        return id_desarrollador;
    }

    @Override
    public String toString(){
        return "|   "+id+"  |   "+name+"    |   "+generoG+"  |   "+precio+"  |   "+unidades+"    |   "+id_desarrollador+"    |";
}
}