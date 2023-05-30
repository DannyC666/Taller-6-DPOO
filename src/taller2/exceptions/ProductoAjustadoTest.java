package taller2.exceptions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import taller2.modelo.Ingrediente;
import taller2.modelo.ProductoAjustado;
import taller2.modelo.ProductoMenu;

import java.util.ArrayList;

public class ProductoAjustadoTest {

    private static ProductoMenu productoBase;
    private static Ingrediente ingrediente1;
    private static Ingrediente ingrediente2;
    private static Ingrediente ingrediente3;

    @BeforeAll
    public static void setup() {
        ingrediente1 = new Ingrediente("Ingrediente 1", 2);
        ingrediente2 = new Ingrediente("Ingrediente 2", 3);
        ingrediente3 = new Ingrediente("Ingrediente 3", 4);
        productoBase = new ProductoMenu("Sopa", 10);
    }

    @Test
    public void testAgregarIngrediente() {
        // Crear un objeto y agregar ingredientes
        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);

        productoAjustado.agregarIngrediente(ingrediente1);
        productoAjustado.agregarIngrediente(ingrediente2);

        // Verificar que los ingredientes se agregaron correctamente
        Assertions.assertEquals(2, productoAjustado.getAgregados().size());
        Assertions.assertTrue(productoAjustado.getAgregados().contains(ingrediente1));
        Assertions.assertTrue(productoAjustado.getAgregados().contains(ingrediente2));
    }

    @Test
    public void testEliminarIngrediente() {
        // Crear un objeto y agregar ingredientes
        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);

        productoAjustado.eliminarIngrediente(ingrediente1);
        productoAjustado.eliminarIngrediente(ingrediente2);

        // Verificar que los ingredientes se agregaron correctamente
        Assertions.assertEquals(2, productoAjustado.getEliminados().size());
        Assertions.assertTrue(productoAjustado.getEliminados().contains(ingrediente1));
        Assertions.assertTrue(productoAjustado.getEliminados().contains(ingrediente2));
    }

    @Test
    public void testGetPrecio() {

        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);
        productoAjustado.agregarIngrediente(ingrediente1);
        productoAjustado.agregarIngrediente(ingrediente2);
        productoAjustado.agregarIngrediente(ingrediente3);

        int precio = productoAjustado.getPrecio();

        Assertions.assertEquals(9, precio);
    }

    @Test
    public void testGenerarTextoFactura() {
        // Crear un objeto y agregar/eliminar ingredientes
        ProductoAjustado productoAjustado = new ProductoAjustado(productoBase);
        productoAjustado.agregarIngrediente(ingrediente1);
        productoAjustado.agregarIngrediente(ingrediente2);
        productoAjustado.eliminarIngrediente(ingrediente2);

        // Generar el texto de la factura
        String textoFactura = productoAjustado.generarTextoFactura();

        // Verificar el texto de la factura esperado
        String ingredientesEliminados = "";
        String textoEsperado = "Ingredientes agregados: "+"\n" + "Ingrediente 1   Precio: 2\n" +
                "Ingrediente 2   Precio: "+ 3 +"\n";
        ingredientesEliminados = "Ingredientes eliminados: "+"Ingrediente 2";
        textoEsperado = "\n"+ textoEsperado +"\n"+ ingredientesEliminados;
        Assert.assertEquals(textoEsperado, textoFactura);
    }


}
