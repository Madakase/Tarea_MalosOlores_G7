/**
 * CHANGE PREVENTERS - divergent change (DESPUÉS)
 * Solución: separar por responsabilidades (PoliticaImpuesto, ServicioDescuento, FormateadorFactura).
 * Beneficio: cada cambio cae en su clase específica.
 */
public class CambioDivergente_After {

    interface PoliticaImpuesto {
        double calcularImpuesto(double baseImponible);
    }

    static class ImpuestoEcuador implements PoliticaImpuesto {
        public double calcularImpuesto(double baseImponible) { return baseImponible * 0.12; }
    }

    static class ImpuestoUSA implements PoliticaImpuesto {
        public double calcularImpuesto(double baseImponible) { return baseImponible * 0.07; }
    }

    static class ServicioDescuento {
        public double calcularDescuento(double subtotal, boolean vip) {
            return vip ? subtotal * 0.05 : 0;
        }
    }

    static class FormateadorFactura {
        public String formatear(double subtotal, double descuento, double impuesto, double total) {
            return "Subtotal: " + subtotal +
                    "\nDescuento: " + descuento +
                    "\nImpuesto: " + impuesto +
                    "\nTotal: " + total;
        }
    }

    public static String textoFactura(double subtotal, PoliticaImpuesto politicaImpuesto, boolean vip) {
        ServicioDescuento sd = new ServicioDescuento();
        double descuento = sd.calcularDescuento(subtotal, vip);
        double baseImponible = subtotal - descuento;

        double impuesto = politicaImpuesto.calcularImpuesto(baseImponible);
        double total = baseImponible + impuesto;

        return new FormateadorFactura().formatear(subtotal, descuento, impuesto, total);
    }
}
