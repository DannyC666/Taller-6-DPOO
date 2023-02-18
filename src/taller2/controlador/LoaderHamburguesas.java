package taller2.controlador;

import taller2.modelo.Combo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LoaderHamburguesas {

    //Atributos
    private String nombreArchivo;

    // Constructor
    public LoaderHamburguesas(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    //metodo

    public  void cargarDatos(String nombreArchivo) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea ;
        linea = br.readLine();
        while (linea != null) {
            String[] datos = linea.split(";");
            cadaCarga(datos);
            linea = br.readLine(); // Leer la siguiente línea
        }
    }


    //metodo abstracto
    public abstract void cadaCarga(String[] tipoDato);

}