package taller2.controlador;

import taller2.exceptions.IngredienteRepetidoException;
import taller2.exceptions.ProductoRepetidoException;
import taller2.modelo.*;

import java.io.IOException;
import java.util.*;

public class Restaurante {
    //Atributos
    private List<Pedido> pedidos = new ArrayList<>();
    private Pedido pedidoEnCurso;
    private List<Combo> combos;
    private List<Producto> menuBase;
    private List<Ingrediente> ingredientes;
    private Map<String,CargaCombos> datosCombos;


    //Constructor de la clase
    public Restaurante(){

    }

    //Metodos

    public void iniciarPedido(String nombreCliente, String direccionCliente, ArrayList<Producto> productos){
        Pedido nuevoPedido = new Pedido(nombreCliente,direccionCliente,productos);
        this.pedidoEnCurso = nuevoPedido;


    }
    public void cerrarYGuardarPedido() throws IOException {
        pedidos.add(pedidoEnCurso);
        pedidoEnCurso.guardarFactura();


    }

    public List<Pedido> getPedidos(){

        return this.pedidos;}

    public Pedido getPedidoEnCurso(){

        return this.pedidoEnCurso;
    }

    public List<Producto> getMenuBase()  {
        return this.menuBase;
    }
    public List<Ingrediente> getIngredientes(){
        return this.ingredientes;
    }
    public List<Combo> getCombos(){
        return this.combos;
    }


    //Funciones de carga
    public void cargarIngredientes(String archivoIngredientes) throws Exception {

        CargaIngredientes ingredientes = new CargaIngredientes("data/ingredientes.txt");
        IngredienteRepetidoException expetionError = new IngredienteRepetidoException();
        ingredientes.cargarDatos("data/ingredientes.txt");
        this.ingredientes = ingredientes.getListaingredientes();
        try {
            expetionError.ingredientesRepetidos(this.ingredientes);
        }catch (Exception e){
            System.out.println("Hubo un error en la carga!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
    public void cargarMenu(String archivoMenu) throws Exception {
        CargaMenu menu = new CargaMenu("data/menu.txt");
        ProductoRepetidoException expetionError = new ProductoRepetidoException();
        menu.cargarDatos("data/menu.txt");
        this.menuBase = menu.getListaMenu();
        try {
            expetionError.productosRepetidos(this.menuBase);
        }catch (Exception e){
            System.out.println("Hubo un error en la carga!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }



    public void cargarCombos(String archivoMenu) throws IOException {

        CargaCombos combos = new CargaCombos("data/combos.txt");
        combos.cargarDatos("data/combos.txt");
        this.combos = combos.getListaCombos();

    }
}
