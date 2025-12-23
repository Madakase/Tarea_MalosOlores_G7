import java.util.List;

/**
 * BLOATERS - long method (DESPUÉS)
 * Solución: dividir el método en responsabilidades pequeñas (calcularSubtotal, calcularDescuento, etc.).
 * Beneficio: código legible, testeable, y cambios localizados.
 */
public class MetodoLargo_After {

    public static double pagar(List<Item> items, String cupon, boolean esVip) {
        double subtotal = calcularSubtotal(items);
        double descuento = calcularDescuento(subtotal, cupon, esVip);
        double baseImponible = Math.max(0, subtotal - descuento);

        double impuesto = calcularImpuesto(baseImponible);
        double envio = calcularEnvio(baseImponible);

        double total = baseImponible + impuesto + envio;
        imprimirResumen(subtotal, descuento, impuesto, envio, total);
        return total;
    }

    private static double calcularSubtotal(List<Item> items) {
        double subtotal = 0;
        for (Item it : items) {
            if (it.cantidad <= 0) continue;
            subtotal += it.precio * it.cantidad;
        }
        return subtotal;
    }

    private static double calcularDescuento(double subtotal, String cupon, boolean esVip) {
        double descuento = calcularDescuentoPorCupon(subtotal, cupon);
        if (esVip) descuento += subtotal * 0.05;
        return descuento;
    }

    private static double calcularDescuentoPorCupon(double subtotal, String cupon) {
        if (cupon == null || cupon.isBlank()) return 0;
        if (cupon.equals("AHORRA10")) return subtotal * 0.10;
        if (cupon.equals("AHORRA20")) return subtotal * 0.20;
        if (cupon.startsWith("PLANO")) {
            try { return Double.parseDouble(cupon.substring(5)); }
            catch (Exception ignorar) { return 0; }
        }
        return 0;
    }

    private static double calcularImpuesto(double baseImponible) {
        return baseImponible * 0.12;
    }

    private static double calcularEnvio(double baseImponible) {
        if (baseImponible < 50) return 7.99;
        if (baseImponible < 100) return 3.99;
        return 0;
    }

    private static void imprimirResumen(double subtotal, double descuento, double impuesto, double envio, double total) {
        System.out.println("subtotal=" + subtotal);
        System.out.println("descuento=" + descuento);
        System.out.println("impuesto=" + impuesto);
        System.out.println("envio=" + envio);
        System.out.println("total=" + total);
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
