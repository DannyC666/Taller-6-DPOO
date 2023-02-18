package taller2.modelo;

import taller2.controlador.LoaderHamburguesas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargaMenu extends LoaderHamburguesas {
    //Atributos
    List<Producto> menus= new ArrayList<>();

    //constructor
    public CargaMenu(String nombreArchivo){
        super(nombreArchivo);

    }

    @Override
    public void cadaCarga(String[] tipoDato){
        String producto = tipoDato[0];
        int precio = Integer.parseInt(tipoDato[1]);
        ProductoMenu productosMenu = new ProductoMenu(producto,precio);
        menus.add(productosMenu);
    }

    public static void main(String[] args) throws IOException {
        CargaMenu menu = new CargaMenu("data/menu.txt");
        menu.cargarDatos("data/menu.txt");
        System.out.println(menu.menus.get(1).getPrecio());
    }

    public  List< Producto > getListaMenu(){return menus;}

}
