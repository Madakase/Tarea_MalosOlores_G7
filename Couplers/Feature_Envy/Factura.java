public class Factura {

    /*Factura usa más datos de clientes que propios. Además la logica de descuento le 
    pertenece a Cliente*/
    public double calcularTotalConDescuento(Cliente cliente, double total) {
        return total - (total * cliente.getDescuento());
    }
}