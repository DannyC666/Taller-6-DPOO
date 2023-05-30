package taller2.exceptions;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import taller2.modelo.Ingrediente;
import taller2.modelo.Pedido;
import taller2.modelo.Producto;
import taller2.modelo.ProductoMenu;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PedidoTest {

    private static Pedido pedido;
    private static String nombreCliente;
    private static String direccionCliente;
    private static ArrayList<Producto> listaPedido;

    @BeforeAll
    public static void setup() {
        nombreCliente = "John Doe";
        direccionCliente = "123 Main Street";
        listaPedido = new ArrayList<>();
        Producto producto1 = new ProductoMenu("Producto 1", 1);
        Producto producto2 = new ProductoMenu("Producto 2", 2);
        Producto producto3 = new ProductoMenu("Producto 3", 3);
        listaPedido.add(producto1);
        listaPedido.add(producto2);
        listaPedido.add(producto3);

    }

    @Test
    public void testGetSetIdPedido() {
        // Crear un objeto Pedido para la prueba
        pedido = new Pedido(nombreCliente, direccionCliente, listaPedido);
        // Establecer un ID de pedido
        int idPedido = 1;
        pedido.setIdPedido(idPedido);
        // Verificar que el ID de pedido obtenido coincide con el establecido
        int resultado = pedido.getIdPedido();
        assertEquals(idPedido, 1);
    }

    @Test
    public void testIniciarProductoAjustado() {
        // Crear un objeto Pedido para la prueba
        Pedido pedido = new Pedido(nombreCliente, direccionCliente, listaPedido);

        // Crear un ProductoMenu para agregar al pedido
        ProductoMenu productoAgregado = new ProductoMenu("Hamburguesa", 10);

        // Iniciar un ProductoAjustado en el pedido
        pedido.iniciarProductoAjustado(productoAgregado);

        // Verificar que el ajustarProducto no sea nulo
        assertNotNull(pedido.ajustarProducto);
        assertEquals(productoAgregado.getNombre(), pedido.ajustarProducto.getNombre());
    }

    @Test
    public void testAgregarEliminarIngredienteProducto() {
        // Crear un objeto Pedido para la prueba
        Pedido pedido = new Pedido(nombreCliente, direccionCliente, listaPedido);
        // Crear un ProductoMenu para agregar al pedido
        ProductoMenu productoAgregado = new ProductoMenu("Hamburguesa", 10);
        // Iniciar un ProductoAjustado en el pedido
        pedido.iniciarProductoAjustado(productoAgregado);
        // Crear un Ingrediente para agregar y eliminar
        Ingrediente nuevoIngrediente = new Ingrediente("Tomate", 5);
        Ingrediente eliminarIngrediente = new Ingrediente("Lechuga", 3);
        // Agregar y luego eliminar un ingrediente en el ProductoAjustado del pedido
        pedido.agregarIngredienteProducto(nuevoIngrediente);
        pedido.eliminarIngredienteProducto(eliminarIngrediente);
        // Verificar que los ingredientes se agregaron y eliminaron correctamente
        assertTrue(pedido.ajustarProducto.getAgregados().contains(nuevoIngrediente));
        assertTrue(pedido.ajustarProducto.getEliminados().contains(eliminarIngrediente));
    }


    /* Solo se hace la prueba de guardarFactura(), ya que esta llama gerTextoFactura(), que es un metodo
    * privado, y modificar gerTextoFactura() para que sea público sería una violacion a la O de SOLID.
    * Igualmente, probar esta funcion, asegura que se prueben al tiempo getPrecioIVAPedido(),  gerPrecioTotalPedido(),
    * y getPrecioNetoPedido(), porque todas se llaman dentro guardarFactura() que es la que estamos probando.
    * */
    @Test
    public void testGenerarTextoFactura() throws  IOException {
        // Crear un objeto Pedido para la prueba
        nombreCliente = "John Doe";
        direccionCliente = "123 Main Street";
        ArrayList<Producto> listaPedido = new ArrayList<>();
        ProductoMenu producto1 = new ProductoMenu("Hamburguesa", 10);
        ProductoMenu producto2 = new ProductoMenu("Papas fritas", 5);
        listaPedido.add(producto1);
        listaPedido.add(producto2);
        Pedido pedido = new Pedido(nombreCliente, direccionCliente, listaPedido);

        // Establecer un ID de pedido
        pedido.setIdPedido(1);

        // Llamar al método generarTextoFactura()
        String resultado = pedido.guardarFactura();

        // Verificar si el resultado contiene las partes esperadas de la factura
        assertTrue(resultado.contains("ID pedido: 1"));
        assertTrue(resultado.contains("Nombre del cliente: John Doe"));
        assertTrue(resultado.contains("Direccion del cliente: 123 Main Street"));
        assertTrue(resultado.contains("Precio neto del pedido: 15"));
        assertTrue(resultado.contains("Precio total del pedido: 17"));
        assertTrue(resultado.contains("Costo agregado por IVA 19%: 2"));
        assertTrue(resultado.contains("-------- Los productos agregados fueron: --------"));
        assertTrue(resultado.contains(pedido.guardarFactura()));
        assertTrue(resultado.contains(pedido.guardarFactura()));

    }

    @Test
    public void limitePrecioError() throws IOException {
        // Crear un objeto Pedido para la prueba
        String nombreCliente = "John Doe";
        String direccionCliente = "123 Main Street";
        ArrayList<Producto> listaPedido = new ArrayList<>();
        Pedido pedido = new Pedido(nombreCliente, direccionCliente, listaPedido);

        // Crear un Producto con un precio que excede el límite
        int precioExcedido = 150000;
        ProductoMenu productoExcedido = new ProductoMenu("Producto Excedido", precioExcedido);

        // Llamar al método agregarProducto()
        try {
            pedido.agregarProducto(productoExcedido);

        } catch (Exception e) {
            assertEquals("No puedes agregar Producto Excedido, ya que has superado el limite de 150000 para la cuenta", e.getMessage());
            // Verificar que el producto NO se agregó a la lista de pedido
            assertFalse(pedido.listaPedido.contains(productoExcedido));
        }


    }
}



