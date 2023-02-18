package taller2.modelo;

import taller2.controlador.LoaderHamburguesas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargaCombos extends LoaderHamburguesas {
    //Atributos

    List< Combo > listaCombos = new ArrayList <Combo> ();


    //Constructor
    public CargaCombos(String nombreArchivo){
        super(nombreArchivo);
    }

    @Override
    public void cadaCarga(String[] tipoDato){
        // Se instancia los atributos de combo
        String nombre = tipoDato[0];
        String porcentajeStr = tipoDato[1].substring(0,tipoDato[1].length()-1);
        int porcentaje = Integer.parseInt(porcentajeStr);
        List< String > cadaProducto = new ArrayList <String> ();
        for(int i = 2; i <= tipoDato.length-1; i++) {
            cadaProducto.add(tipoDato[i]);
        }
        Combo combos = new Combo(nombre,porcentaje,cadaProducto);
        listaCombos.add(combos);
    }
    public  List< Combo > getListaCombos(){return listaCombos;}


   /* Prueba de la carga de combos  */
   public static void main(String[] args) throws IOException {
        CargaCombos menu = new CargaCombos("data/combos.txt");
        menu.cargarDatos("data/combos.txt");
        System.out.println(menu.listaCombos.get(1).getNombre());
    }


}
