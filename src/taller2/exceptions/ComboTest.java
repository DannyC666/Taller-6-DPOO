package taller2.exceptions;

import org.junit.jupiter.api.Test;
import taller2.modelo.Combo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComboTest {
    @Test
    public void testGetNombre() throws IOException {
        // Crear un objeto Combo para la prueba
        String nombreCombo = "Combo 1";
        double descuento = 0.1;
        List<String> productosCombo = new ArrayList<>();
        productosCombo.add("Producto 1");
        productosCombo.add("Producto 2");
        Combo combo = new Combo(nombreCombo, descuento, productosCombo);

        //Se crea el texto generado

        String resultado = "Nombre del producto: "+combo.getNombre()  + " | Precio: $" + combo.getPrecio();
        String textoEsperado = "Nombre del producto: "+ "Combo 1" + " | Precio: $" + 0;

        // Verificar que el resultado del método getNombre() coincide con el nombreCombo proporcionado

        assertEquals(textoEsperado, resultado);
    }
}
