package taller2.modelo;

import taller2.exceptions.IngredienteRepetidoException;

import java.io.IOException;
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
        //funcionalidad empleada en pedido
    }

    // Metodos de la interfaz

    @Override
    public int getPrecio() throws IOException {
        int precio = 0;
        CargaMenu productos = new CargaMenu("data/menu.txt");
        productos.cargarDatos("data/menu.txt");
        Map<String, Integer> mapaMenu= productos.getMapaMenu();

        for (String elemento : this.productosCombo) {
            if (mapaMenu.containsKey(elemento)) {
                int valor = mapaMenu.get(elemento);
                precio += mapaMenu.get(elemento);
            }
        }

            return precio;
    }
    @Override
    public String getNombre() {
        return this.nombreCombo;
    }

    public String generarTextoFactura() throws IOException {

        String comboFactura = "Nombre del producto: "+this.nombreCombo  + " | Precio: $" + getPrecio();


        return comboFactura;
    }
}






