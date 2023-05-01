package taller2.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pedido  {
    //Atributos
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;

    private ArrayList<Producto> listaPedido = new ArrayList<>();
    private ProductoAjustado ajustarProducto;

    //Contructor

    public  Pedido (String nombreCliente, String direccionCliente,ArrayList<Producto> listaPedido) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.listaPedido = listaPedido;
    }
    public int getIdPedido(){

        return this.idPedido;
    }
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }


    public void agregarProducto(Producto nuevoItem){

        this.listaPedido.add(nuevoItem);
    }

    public void iniciarProductoAjustado(ProductoMenu productoAgregado){
        ProductoAjustado ajustarProducto = new ProductoAjustado(productoAgregado);
        this.ajustarProducto = ajustarProducto;
    }
    public void agregarIngredienteProducto(Ingrediente nuevoIngrediente){
        ajustarProducto.agregarIngrediente(nuevoIngrediente);
    }

    public void eliminarIngredienteProducto(Ingrediente eliminarIngrediente){
        ajustarProducto.eliminarIngrediente(eliminarIngrediente);
    }

    private int getPrecioNetoPedido() {
        int precioPedido = 0;
        int precioIngrediente = 0;
        for (Producto cadaPedido : this.listaPedido) {
            precioPedido += cadaPedido.getPrecio();
        }
        if (ajustarProducto == null){
            //System.out.println("No se añadio ingrediente");
        }else{
             precioIngrediente = ajustarProducto.getPrecio();
        }
//
        return precioPedido + precioIngrediente;
    }
    private int gerPrecioTotalPedido(){
        int precioNeto = getPrecioNetoPedido();
        int precioTotal = (int) (precioNeto *1.19);
        return precioTotal;
    }
    private int getPrecioIVAPedido(){
        int precioNeto = getPrecioNetoPedido();
        int precioIVA = (int) (precioNeto *0.19);
        return precioIVA;
    }
    private String gerTextoFactura(){
        String facturaProductos = "";
        String ingredientesAgregados = "";

        String identificador = "ID pedido: "+idPedido;
        String nombre = "Nombre del cliente: " + nombreCliente;
        String direccion = "Direccion del cliente: "+ direccionCliente;
        String precioNeto = "Precio neto del pedido: " + getPrecioNetoPedido();
        String precioTotal = "Precio total del pedido: " + gerPrecioTotalPedido();
        String sumaIVA = "Costo agregado por IVA 19%: "+ getPrecioIVAPedido();
        String headerProductos = "-------- Los productos agregados fueron: --------";
        for (Producto cadaPedido : this.listaPedido) {
            facturaProductos = facturaProductos + cadaPedido.generarTextoFactura()+"\n";
            if (ajustarProducto != null){
                ingredientesAgregados = ajustarProducto.generarTextoFactura();
            }
        }

        String facturaCompleta =
                identificador + "\n" +
                nombre +"\n"+
                direccion +"\n" +
                        headerProductos +"\n"+
                        facturaProductos+"\n"+
                        ingredientesAgregados+"\n"+
                precioNeto+ "\n"+
                        sumaIVA + "\n"+
                precioTotal + "\n"

                ;
        System.out.println(facturaCompleta);
        return facturaCompleta;
    }
    public void guardarFactura(){
        gerTextoFactura();

    }

}
