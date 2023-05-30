package taller2.exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import taller2.modelo.ProductoMenu;

public class ProductoMenuTest {
    private ProductoMenu productoMenu;

    @BeforeEach
    public  void  setUp() throws Exception{
        //this.productoMenu = new ProductoMenu("Hamburguesa", 10000);
        //No funciona el wildCart correctamente
    }

    @Test
    @DisplayName("Generar factura del producto")
    public void testgenerarTextoFactura(){
        this.productoMenu = new ProductoMenu("Hamburguesa", 10000);
        String resultadoEsperado = "Nombre del producto: Hamburguesa Precio: 10000";
        String resultado = productoMenu.generarTextoFactura();
        Assert.assertEquals(resultadoEsperado, resultado);
    }
}
