package taller2.controlador;

import taller2.modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void cerrarYGuardarPedido(){
        pedidos.add(pedidoEnCurso);
        pedidoEnCurso.guardarFactura();


    }

    public List<Pedido> getPedidos(){
        System.out.println(this.pedidos);
        // Pedido pPrueba
        System.out.println();
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


    //Funciones de carga
    public void cargarIngredientes(String archivoIngredientes) throws IOException {

        CargaIngredientes ingredientes = new CargaIngredientes("data/ingredientes.txt");
        ingredientes.cargarDatos("data/ingredientes.txt");
        this.ingredientes = ingredientes.getListaingredientes();
        //System.out.println(this.ingredientes);
    }
    public void cargarMenu(String archivoMenu) throws IOException {
        CargaMenu menu = new CargaMenu("data/menu.txt");
        menu.cargarDatos("data/menu.txt");
        this.menuBase = menu.getListaMenu();
    }
    public void cargarCombos(String archivoMenu) throws IOException {

        CargaCombos combos = new CargaCombos("data/combos.txt");
        combos.cargarDatos("data/combos.txt");
        this.combos = combos.getListaCombos();

    }
}
