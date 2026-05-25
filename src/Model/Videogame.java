package Model;

public class Videogame {
    private int id;
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

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Genero getGenero(){
        return genero;
    }

    public double getPrecio(){
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

}