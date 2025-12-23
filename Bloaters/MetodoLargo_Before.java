import java.util.List;

/**
 * BLOATERS - long method (ANTES)
 * Problema: un solo método hace demasiadas cosas (subtotal, descuento, impuesto, envío, logs).
 * Resultado: difícil de leer, probar y modificar.
 */
public class MetodoLargo_Before {

    public static double pagar(List<Item> items, String cupon, boolean esVip) {
        double subtotal = 0;

        for (Item it : items) {
            if (it.cantidad <= 0) continue;
            subtotal += it.precio * it.cantidad;
        }

        double descuento = 0;

        if (cupon != null && !cupon.isBlank()) {
            if (cupon.equals("AHORRA10")) descuento += subtotal * 0.10;
            else if (cupon.equals("AHORRA20")) descuento += subtotal * 0.20;
            else if (cupon.startsWith("PLANO")) {
                try {
                    descuento += Double.parseDouble(cupon.substring(5));
                } catch (Exception ignorar) {
                    // silencio incómodo
                }
            }
        }

        if (esVip) descuento += subtotal * 0.05;

        double baseImponible = subtotal - descuento;
        if (baseImponible < 0) baseImponible = 0;

        double impuesto = baseImponible * 0.12;

        double envio = 0;
        if (baseImponible < 50) envio = 7.99;
        else if (baseImponible < 100) envio = 3.99;

        double total = baseImponible + impuesto + envio;

        System.out.println("subtotal=" + subtotal);
        System.out.println("descuento=" + descuento);
        System.out.println("impuesto=" + impuesto);
        System.out.println("envio=" + envio);
        System.out.println("total=" + total);

        return total;
    }

    public static class Item {
        public String nombre;
        public double precio;
        public int cantidad;

        public Item(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
    }
}
