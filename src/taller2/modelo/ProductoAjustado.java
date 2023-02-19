package taller2.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoAjustado implements Producto{
    //Atributos
    private ProductoMenu base;
    private ArrayList<Ingrediente> agregados = new ArrayList<>();
    private ArrayList<Ingrediente> eliminados = new ArrayList<>();



    //Constructor
    public ProductoAjustado(ProductoMenu base){
        this.base = base;

    }

    //Metodos
    public void agregarIngrediente(Ingrediente ingredientes){
         agregados.add(ingredientes);

    }

    public void eliminarIngrediente(Ingrediente ingredientes){
         eliminados.add(ingredientes);
    }



    //Metodos de interfa
    @Override
    public int getPrecio() {
        int precioAjustado = 0;

        for (Ingrediente cadaIngrediente : this.agregados) {
            precioAjustado += cadaIngrediente.costoAdicional();
        }
        return precioAjustado;
    }

    @Override
    public String getNombre() {
        return base.getNombre();
    }

    @Override
    public String generarTextoFactura() {

        String ingredientesAgregados = "";
        String ingredientesEliminados = "";

        for (Ingrediente cadaIngrediente : this.agregados) {
            ingredientesAgregados = "Ingredientes agregados: "+cadaIngrediente.getNombre() + "   Precio: "+ cadaIngrediente.costoAdicional();
        }
        for (Ingrediente cadaIngrediente : this.eliminados) {
            ingredientesEliminados = "Ingredientes eliminados: "+cadaIngrediente.getNombre();
        }
        String nombreIngredientes =  "\n"+ ingredientesAgregados +"\n"+ ingredientesEliminados;
        return nombreIngredientes;
    }
}
