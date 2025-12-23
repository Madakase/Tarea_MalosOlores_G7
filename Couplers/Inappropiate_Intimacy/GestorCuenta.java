public class GestorCuenta {

    /*Accede directamente a saldo. Sin encapsulamiento */
    public void ajustarSaldo(CuentaBancaria cuenta, double monto) {
        cuenta.saldo += monto;
    }
}