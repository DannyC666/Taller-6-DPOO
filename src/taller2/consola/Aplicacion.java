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
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    Scanner consolaInput = new Scanner(System.in);






    public void mostrarMenu(){
        System.out.println("\nOpciones de la aplicación\n");
        System.out.println("----------Opciones----------");
        System.out.println("1. Iniciar pedido ");
        System.out.println("2. Salir de la aplicacion ");

    }

    public void ejectarOpcion() throws IOException {
        mostrarMenu();
        var opcion  = consolaInput.nextLine() ;
        var opcionAplicacion = Integer.parseInt(opcion);
        boolean nuevoPedido = true;
        if(opcionAplicacion == 1){
            while(nuevoPedido){
                iniciarPedido();
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
                    System.out.println("----------Combos----------");
                    System.out.println("1 Combo corral");
                    System.out.println("2 Combo corral queso");
                    System.out.println("3 combo todoterreno");
                    System.out.println("4 Combo especial");
                    System.out.println("---------- ***** ----------");
                    System.out.println("Hacer cosas de combo");
                }else if(opcionPedidoC == 2){

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
                    System.out.println("Pedido guardado");
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
            System.out.println("Aplicacion terminada");
            System.out.println("Pedidos guardados exitosamente");
            restaurante.getPedidos();
            System.out.println("1. Consultar pedido dado ID");

        }else if(opcionAplicacion == 2){
            System.out.println("Aplicacion terminada");
            nuevoPedido = false;
        }

    }


        /*System.out.println("Ingrese la opcion del menu: ");
        var opcion  = consolaInput.nextLine() ;
        var opcionSeleccionada = Integer.parseInt(opcion);
        if (opcionSeleccionada == 1){
            iniciarPedido();
        }
        boolean continuar = true;

        while (continuar){
            switch (opcionSeleccionada){
                case 1:

                case 2:
                    System.out.println(" ---------- Opciones del pedido ---------- ");
                    System.out.println("1. Agregar combo al pedido ");
                    System.out.println("2. Agregar producto del menu al pedido ");
                    System.out.println("3. Cerrar y guardar pedido");
                    System.out.println("4. Consultar pedido dado ID");
                    System.out.println("5. Salir de la aplicacion");

                    var opcion2  = consolaInput.nextLine() ;
                    var opcionSeleccionada2 = Integer.parseInt(opcion2);
                    if(opcionSeleccionada2== 1){
                        System.out.println("----------Combos----------");
                        System.out.println("1 Combo corral");
                        System.out.println("2 Combo corral queso");
                        System.out.println("3 combo todoterreno");
                        System.out.println("4 Combo especial");
                        System.out.println("---------- ***** ----------");
                        var opcionTipoCombo  = consolaInput.nextLine() ;
                        var opcionTipoComboC = Integer.parseInt(opcionTipoCombo);
                        System.out.println("Combo "+opcionTipoComboC+" agregado a su pedido!");

                    }
                    else if(opcionSeleccionada2== 2) {
                        System.out.println("----------Menu Prinicpal----------");
                        System.out.println("1. corral : 14000");
                        System.out.println("2. corral queso : 16000 ");
                        System.out.println("3. corral pollo : 15000");
                        System.out.println("4. corralita : 13000");
                        System.out.println("5. todoterreno : 25000");
                        System.out.println("6. 1/2 libra : 25000");
                        System.out.println("7. especial : 24000");
                        System.out.println("8.  casera : 23000");
                        System.out.println("9. mexicana : 22000");
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

                        System.out.println("Elija el producto que desea agregar al pedido.");
                        var opcionTipoProducto  = consolaInput.nextLine() ;
                        var opcionTipoProductoC = Integer.parseInt(opcionTipoProducto);
                        agregarMenuPedido(opcionTipoProductoC);

                        //Dialogo para ingredientes

                        System.out.println("1. Dese agregar un ingrediente?");
                        System.out.println("2. Dese eliminar un ingrediente?");
                        System.out.println("3. Cerrar y guardar pedido");
                        var ocpcionIngrediente  = consolaInput.nextLine() ;
                        var opcionIngredienteC = Integer.parseInt(ocpcionIngrediente);

                        if (opcionIngredienteC== 1) {
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
                            //----
                            agregarIngredientePedido(opcionTipoProductoC);

                        }else if(opcionIngredienteC== 2){
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

                    } else if (opcionSeleccionada2 == 3){
                        System.out.println("Pedido guardado extisoamente!");
                        System.out.println("Contenido del pedido ");
                        guardarPedido();
                        continuar = false;
                    }else if (opcionSeleccionada2 == 4){
                        System.out.println("Consultando pedido...");
                    }else if (opcionSeleccionada2 == 5){
                        continuar = false;
                        System.out.println("Gracias por utilizar el programa");
                    }
            }
        }
        }  */

    private void iniciarPedido() throws IOException {
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

    }
    private void agregarMenuPedido(int tipoProducto) throws IOException {

        List<Producto> infoProductosMenu = restaurante.getMenuBase();
        var nombreProducto= infoProductosMenu.get(tipoProducto-1).getNombre();
        restaurante.getPedidoEnCurso().iniciarProductoAjustado((ProductoMenu) infoProductosMenu.get(tipoProducto-1));
        restaurante.getPedidoEnCurso().agregarProducto(infoProductosMenu.get(tipoProducto-1));
        System.out.println(nombreProducto+" agregado a su pedido!!");
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
        //Variable provisional
        List<Ingrediente> infoIngredientes = restaurante.getIngredientes();
        //Variable provisional
        List<Producto> infoProductosMenu = restaurante.getMenuBase();
        System.out.println("Que ingrediente desea Eliminar?");
        var opcionTipoIngrediente  = consolaInput.nextLine() ;
        var opcionTipoIngredienteC = Integer.parseInt(opcionTipoIngrediente)  ;
        var nombreIngredientes = infoIngredientes.get(opcionTipoIngredienteC-1).getNombre();
        restaurante.getPedidoEnCurso().eliminarIngredienteProducto(infoIngredientes.get(opcionTipoIngredienteC-1));
        System.out.println(nombreIngredientes+" eliminado a su pedido!");
    }
    private void agregarComboPedido(){

    }

    private void guardarPedido(){
        restaurante.cerrarYGuardarPedido();
    }



        public static void main (String[]args) throws IOException {
            Aplicacion consola = new Aplicacion();
            consola.ejectarOpcion();

        }

}
