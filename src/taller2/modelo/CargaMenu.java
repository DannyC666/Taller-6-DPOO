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
    Map<String, Integer> mapaMenu = new HashMap<>();

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
        mapaMenu.put(tipoDato[0], Integer.valueOf(tipoDato[1]));
    }



    public  List< Producto > getListaMenu(){return menus;}
    public  Map<String, Integer> getMapaMenu(){return mapaMenu;}

}
