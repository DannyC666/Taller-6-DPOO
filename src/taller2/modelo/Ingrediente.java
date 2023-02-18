package taller2.modelo;

public class Ingrediente {
    // Atributos
    private String nombre;
    private int costoAdicional;

    // Constructer
    public Ingrediente (String nombre, int costoAdicional){
        this.nombre = nombre;
        this.costoAdicional = costoAdicional;
    }
    //metodos
    public String getNombre(){
        return this.nombre;
    }
    public int costoAdicional(){
        return this.costoAdicional;
    }


}
