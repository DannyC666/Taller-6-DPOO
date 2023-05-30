package taller2.modelo;

import java.io.IOException;

public interface  Producto {
    public int getPrecio() throws IOException;
    public String getNombre();
    public String generarTextoFactura() throws IOException;
}
