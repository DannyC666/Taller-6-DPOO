package taller2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Combo implements Producto{
    //Atributos
    private double descuento;
    private String nombreCombo;
    private List<ProductoMenu> itemsCombo;
    private List<String> productosCombo;


    //Costructor
    public Combo(String nombreCombo, double descuento, List<String> productosCombo){
        this.nombreCombo = nombreCombo;
        this.descuento = descuento;
        this.productosCombo = productosCombo;

    }
    //Metodos


    public void agregarItemACombo(Producto itemCombo){
        String nombreItem = itemCombo.getNombre();
        int precioitem = itemCombo.getPrecio();
        Map<String, Integer> preciosItem = new HashMap<>();;
        preciosItem.put(nombreItem,precioitem);


    }

    // Metodos de la interfaz

    @Override
    public int getPrecio() {

        return 0;
    }
    @Override
    public String getNombre() {
        return this.nombreCombo;
    }

    @Override
    public String generarTextoFactura() {
        return null;
    }
}






