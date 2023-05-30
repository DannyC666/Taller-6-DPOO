package taller2.exceptions;

public class TotalPriceException {
    private int precioAhora = 0;
    public int limitPriceError( int priceProduct) throws Exception {
        precioAhora += priceProduct;
        if(precioAhora > 150000 ){
            throw new Exception("Limite de precio superado");
        }
        int precioMenor = 150000 - (precioAhora-priceProduct);
        return precioMenor;
    }
}
