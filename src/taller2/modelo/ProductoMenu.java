package taller2.modelo;

public class ProductoMenu implements Producto {
    // Atributos
    private String nombre;
    private int precioBase;

    // Cosntructor
    public ProductoMenu(String nombre , int precioBase){
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    //metodos



    // Metodos de la interfaz
    @Override
    public int getPrecio() {
        return this.precioBase;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String generarTextoFactura() {
        String facturaMenu = "Nombre del producto: "+nombre+ " Precio: "+precioBase;
        return facturaMenu;
    }
}
