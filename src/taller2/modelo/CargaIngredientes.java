package taller2.modelo;

import taller2.controlador.LoaderHamburguesas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargaIngredientes extends LoaderHamburguesas {
    // Atributos
    List<Ingrediente> listIngredientes = new ArrayList<Ingrediente>();

    // Constructor
    public CargaIngredientes (String nombreArchivo){
        super(nombreArchivo);
    }

    @Override
    public void cadaCarga(String[] tipoDato){
        String ingrediente = tipoDato[0];
        int costoAdicional = Integer.parseInt(tipoDato[1]);
        Ingrediente ingredientes = new Ingrediente(ingrediente,costoAdicional);
        listIngredientes.add(ingredientes);
    }
    public  List< Ingrediente > getListaingredientes(){return listIngredientes;}


}
