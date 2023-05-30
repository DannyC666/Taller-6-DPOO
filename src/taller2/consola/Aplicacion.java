package taller2.consola;
import taller2.controlador.Restaurante;
import taller2.modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {
    //atributo
    private Restaurante restaurante = new Restaurante();

    Scanner consolaInput = new Scanner(System.in);




    public void mostrarMenu(){
        System.out.println("\nOpciones de la aplicación\n");
        System.out.println("----------Opciones----------");
        System.out.println("1. Iniciar pedido ");
        System.out.println("2. Salir de la aplicacion ");

    }

    public void ejectarOpcion() throws Exception {
        mostrarMenu();
        var opcion  = consolaInput.nextLine() ;
        var opcionAplicacion = Integer.parseInt(opcion);
        boolean nuevoPedido = true;
        int idPedido = 0;
        if(opcionAplicacion == 1){
            while(nuevoPedido){
                idPedido++;
                iniciarPedido(idPedido);

                System.out.println("Pedido iniciado!");
                System.out.println(" ---------- Opciones del pedido ---------- ");
                System.out.println("1. Agregar combo al pedido ");
                System.out.println("2. Agregar producto del menu al pedido ");
                System.out.println("3. Guardar pedido y agregar otro");
                System.out.println("4. Guardar todos los pedidos creados (Salir de la aplicacion) ");
                System.out.println("---------- ***** ----------");
                // eleccion de Opciones del pedido
                System.out.println("Elija una opcion para su pedido");
                var opcionPedido  = consolaInput.nextLine() ;
                var opcionPedidoC = Integer.parseInt(opcionPedido);

                if (opcionPedidoC == 1){

                    System.out.println("Cuantos combos quiere agregar a su pedido?");
                    var cuantosCombos  = consolaInput.nextLine() ;
                    var cuantosCombosC = Integer.parseInt(cuantosCombos);
                    int c = 1;
                    while (c <= cuantosCombosC){
                        System.out.println("----------Combos----------");
                        System.out.println("1 Combo corral");
                        System.out.println("2 Combo corral queso");
                        System.out.println("3 combo todoterreno");
                        System.out.println("4 Combo especial");
                        System.out.println("---------- ***** ----------");
                        System.out.println("Elija el combo que desea agregar a su pedido");
                        var opcionCombo  = consolaInput.nextLine() ;
                        var opcionComboC = Integer.parseInt(opcionCombo);
                        agregarComboPedido(opcionComboC);
                        c++;
                    }
                    System.out.println("Quiere agregar mas productos del menu? ");
                    System.out.println("Y = Agregar mas productos del menu, no incluye ingredientes");
                    System.out.println("N = terminar pedido y generar la factura");
                    var seguir  = consolaInput.nextLine() ;
                    var compareSeguir = seguir.equals("Y");
                    if(compareSeguir){
                        opcionPedidoC = 2;

                    }else opcionPedidoC = 3;



                } if(opcionPedidoC == 2){

                    System.out.println("Cuantos productos desea agregar?");
                    var numeroProductos  = consolaInput.nextLine() ;
                    var numeroProductosC = Integer.parseInt(numeroProductos);
                    int i = 1;

                    while(i <= numeroProductosC){

                        System.out.println("----------Menu Prinicpal----------");
                        System.out.println("1. corral : 14000");
                        System.out.println("2. corral queso : 16000 ");
                        System.out.println("3. corral pollo : 15000");
                        System.out.println("4. corralita : 13000");
                        System.out.println("5. todoterreno : 25000");
                        System.out.println("6. 1/2 libra : 25000");
                        System.out.println("7. especial : 24000");
                        System.out.println("8.  casera : 23000");
                        System.out.println("9. mexicana :  22000");
                        System.out.println("10. criolla : 22000");
                        System.out.println("11. costeña : 20000");
                        System.out.println("12. hawaiana;20000");
                        System.out.println("13. wrap de pollo;15000");
                        System.out.println("14. wrap de lomo;22000");
                        System.out.println("15. ensalada mexicana;20900");
                        System.out.println("16. papas medianas;5500");
                        System.out.println("17. papas grandes;6900");
                        System.out.println("18. papas en casco medianas;5500");
                        System.out.println("19. papas en casco grandes;6900");
                        System.out.println("20. agua cristal sin gas;5000");
                        System.out.println("21. agua cristal con gas;5000");
                        System.out.println("22. gaseosa;5000");
                        System.out.println("---------- ***** ----------");
                        System.out.println("Elija su producto "+ i);

                        var opcionTipoProducto  = consolaInput.nextLine() ;
                        var opcionTipoProductoC = Integer.parseInt(opcionTipoProducto);
                        agregarMenuPedido(opcionTipoProductoC);


                        System.out.println("Desea agregar un ingrediente a este producto? Y/N");
                        var agregarIgre  = consolaInput.nextLine() ;
                        var compareAgregar = agregarIgre.equals("Y");
                        if(compareAgregar){
                            System.out.println("---------- Ingredientes para agregar----------");
                            System.out.println("1. lechuga;1000");
                            System.out.println("2. tomate;1000");
                            System.out.println("3. cebolla;1000");
                            System.out.println("4. queso mozzarella;2500");
                            System.out.println("5. huevo;2500");
                            System.out.println("6. queso americano;2500");
                            System.out.println("7. tocineta express;2500");
                            System.out.println("8. papa callejera;2000");
                            System.out.println("9. pepinillos;2500");
                            System.out.println("10. cebolla grille;2500");
                            System.out.println("11. suero costeño;3000");
                            System.out.println("12. frijol refrito;4500");
                            System.out.println("13. queso fundido;4500");
                            System.out.println("14. tocineta picada;6000");
                            System.out.println("15. piña;2500");
                            System.out.println("---------- ***** ----------");
                            agregarIngredientePedido(opcionTipoProductoC);

                        }
                        System.out.println("Desea eliminar un ingrediente a este producto? Y/N");
                        var eliminarIngre  = consolaInput.nextLine() ;
                        var compareEliminar = eliminarIngre.equals("Y");
                        if(compareEliminar){
                            System.out.println("---------- Ingredientes para Eliminar----------");
                            System.out.println("1. lechuga;1000");
                            System.out.println("2. tomate;1000");
                            System.out.println("3. cebolla;1000");
                            System.out.println("4. queso mozzarella;2500");
                            System.out.println("5. huevo;2500");
                            System.out.println("6. queso americano;2500");
                            System.out.println("7. tocineta express;2500");
                            System.out.println("8. papa callejera;2000");
                            System.out.println("9. pepinillos;2500");
                            System.out.println("10. cebolla grille;2500");
                            System.out.println("11. suero costeño;3000");
                            System.out.println("12. frijol refrito;4500");
                            System.out.println("13. queso fundido;4500");
                            System.out.println("14. tocineta picada;6000");
                            System.out.println("15. piña;2500");
                            System.out.println("---------- ***** ----------");
                            eliminarIngredientePedido(opcionTipoProductoC);

                        }

                        i++;
                    }

                    opcionPedidoC = 3;


                }if(opcionPedidoC == 3){
                    System.out.println(" ----------Pedido guardado exitosamente  ----------");
                    guardarPedido();
                    System.out.println("Desea continuar con otro pedido? Y/N");
                    var continuarPedido  = consolaInput.nextLine() ;
                    var compareContinuar = continuarPedido.equals("Y");
                    if (compareContinuar){
                        System.out.println("Empezando otro pedido...");

                    }else{
                        nuevoPedido = false;
                    }

                    //nuevoPedido = false;

                } else if (opcionPedidoC == 4) {
                    nuevoPedido = false;


                }

            }
            System.out.println("Todos los pedidos guardados exitosamente");
            List<Pedido> pedidos = restaurante.getPedidos();
            System.out.println("En total guardamos "+ pedidos.size() + " Pedidos");
            System.out.println("Desea consultar un pedido por su ID? Y//N");
            var consultarId  = consolaInput.nextLine() ;
            var compareConsultar = consultarId.equals("Y");
            if(compareConsultar){
                System.out.println("Ingrese el ID del pedido que desea buscar: ");
                var idConsultar  = Integer.parseInt(consolaInput.nextLine()) ;
                for (Pedido cadaPedido : pedidos) {
                    if(cadaPedido.getIdPedido() == idConsultar){
                        System.out.println("----------El pedido se ha encontrado!----------");
                        cadaPedido.guardarFactura();
                        break;
                    }else System.out.println("No se ha encontrado un pedido con este ID");
                }
            }
            System.out.println("--------- Aplicacion terminada, vuelva pronto! ---------");



        }else if(opcionAplicacion == 2){
            System.out.println("Aplicacion terminada");
            nuevoPedido = false;
        }

    }

    private void iniciarPedido(int idPedido) throws Exception {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        System.out.println("Pedido iniciado!");
        //Inicializacion de la informacion
        restaurante.cargarCombos("Parametro de prueba");
        restaurante.cargarIngredientes("Parametro de prueba");
        restaurante.cargarMenu("Parametro de prueba");
        //Declaracion de clase pedido a traves de restaurante.
        System.out.println("Ingrese su nombre: ");
        var nombre  = consolaInput.nextLine() ;
        System.out.println("Ingrese su direccion : ");
        var direccion  = consolaInput.nextLine() ;
        restaurante.iniciarPedido(nombre, direccion,productos);
        restaurante.getPedidoEnCurso().setIdPedido(idPedido);

    }
    private void agregarMenuPedido(int tipoProducto) throws Exception {

        List<Producto> infoProductosMenu = restaurante.getMenuBase();
        var nombreProducto= infoProductosMenu.get(tipoProducto-1).getNombre();
        restaurante.getPedidoEnCurso().iniciarProductoAjustado((ProductoMenu) infoProductosMenu.get(tipoProducto-1));
        restaurante.getPedidoEnCurso().agregarProducto(infoProductosMenu.get(tipoProducto-1));
    }

    private void agregarIngredientePedido(int tipoProducto) throws IOException {
        System.out.println("Que ingrediente desea agregar?");
        List<Producto> infoProductosMenu = restaurante.getMenuBase();
        List<Ingrediente> infoIngredientes = restaurante.getIngredientes();
        var opcionTipoIngrediente  = consolaInput.nextLine() ;
        var opcionTipoIngredienteC = Integer.parseInt(opcionTipoIngrediente)  ;
        var nombreIngredientes = infoIngredientes.get(opcionTipoIngredienteC-1).getNombre();
        restaurante.getPedidoEnCurso().agregarIngredienteProducto(infoIngredientes.get(opcionTipoIngredienteC-1));
        System.out.println(nombreIngredientes+" agregado a su pedido!");
    }

    private void eliminarIngredientePedido(int tipoProducto) throws IOException {
        List<Ingrediente> infoIngredientes = restaurante.getIngredientes();
        System.out.println("Que ingrediente desea Eliminar?");
        var opcionTipoIngrediente  = consolaInput.nextLine() ;
        var opcionTipoIngredienteC = Integer.parseInt(opcionTipoIngrediente)  ;
        var nombreIngredientes = infoIngredientes.get(opcionTipoIngredienteC-1).getNombre();
        restaurante.getPedidoEnCurso().eliminarIngredienteProducto(infoIngredientes.get(opcionTipoIngredienteC-1));
        System.out.println(nombreIngredientes+" eliminado a su pedido!");
    }
    private void agregarComboPedido(int tipoCombo) throws Exception {
        List<Combo> infoCombos = restaurante.getCombos();
        var nombreProducto= infoCombos.get(tipoCombo-1).getNombre();
        restaurante.getPedidoEnCurso().agregarProducto(infoCombos.get(tipoCombo-1));

    }

    private void guardarPedido() throws IOException {
        restaurante.cerrarYGuardarPedido();
    }

        public static void main (String[]args) throws Exception {
            Aplicacion consola = new Aplicacion();
            consola.ejectarOpcion();

        }

}
