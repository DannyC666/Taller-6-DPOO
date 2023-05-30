package taller2.exceptions;

import taller2.modelo.Ingrediente;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IngredienteRepetidoException extends HamburguesaException {


    public void ingredientesRepetidos(List<Ingrediente> ingredientes) throws Exception {
        Set<String> conjunto = new HashSet<>();
        boolean hayRepetidos = false;
        for (Ingrediente objeto : ingredientes) {
            if (!conjunto.add(objeto.getNombre())) {
                hayRepetidos = true;
                break;
            }
        }
        if (hayRepetidos) {
            throwExeption();
        }

    }


    @Override
    public void throwExeption() throws Exception {
        throw new Exception("Hay ingredientes repetidos en la lista.");
    }
}
