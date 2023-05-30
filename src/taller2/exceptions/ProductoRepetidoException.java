package taller2.exceptions;

import taller2.modelo.Ingrediente;
import taller2.modelo.Producto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoRepetidoException extends HamburguesaException {

    public void productosRepetidos(List<Producto> productos) throws Exception {
        Set<String> conjunto = new HashSet<>();
        boolean hayRepetidos = false;
        for (Producto objeto : productos) {
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
        throw new Exception("Hay productos repetidos en la lista.");
    }
}
