package Model;

public class Videogame {
    private static int id;
    private String name;
    private Genero genero;
    private double precio;
    private int unidades;

    public Videogame (int id,String name, Genero genero,double precio, int unidades){
        this.id=id;
        this.name=name;
        this.genero=genero;
        this.precio=precio;
        this.unidades=unidades;
    }

    public Videogame (String name, Genero genero,double precio, int unidades){
        this.name=name;
        this.genero=genero;
        this.precio=precio;
        this.unidades=unidades;
    }

    public Videogame(int id, String name, String genero, double precio, int unidades) {
    }

    public static int getId(){
        return id;
    }

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
@Override
    public String toString(){
        return "|   "+id+"  |   "+name+"    |   "+genero+"  |   "+precio+"  |   "+unidades+"    |";
}
}