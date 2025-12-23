/**
 * CHANGE PREVENTERS - divergent change (ANTES)
 * Problema: un solo módulo cambia por razones distintas (impuestos, descuentos, formato).
 * Resultado: cada nueva regla obliga a tocar el mismo archivo.
 */
public class CambioDivergente_Before {

    public static String textoFactura(double subtotal, String pais, boolean vip) {
        double descuento = vip ? subtotal * 0.05 : 0;
        double baseImponible = subtotal - descuento;

        double impuesto = 0;
        if (pais.equals("EC")) impuesto = baseImponible * 0.12;
        else if (pais.equals("US")) impuesto = baseImponible * 0.07;

        return "Subtotal: " + subtotal +
                "\nDescuento: " + descuento +
                "\nImpuesto: " + impuesto +
                "\nTotal: " + (baseImponible + impuesto);
    }
}
