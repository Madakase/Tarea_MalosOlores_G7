public class Caja {

    public void cobrar(Object metodo, double monto) {
        if (metodo instanceof PagoEfectivo) {
            ((PagoEfectivo) metodo).pagar(monto);
        } else if (metodo instanceof PagoTarjeta) {
            ((PagoTarjeta) metodo).procesarPago(monto, "1234-5678-9012-3456");
        }
    }
}