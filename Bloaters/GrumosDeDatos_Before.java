/**
 * BLOATERS - data clumps (ANTES)
 * Problema: los mismos datos viajan juntos en varios métodos (dirección repetida).
 * Resultado: duplicación, cambios dolorosos, más probabilidad de inconsistencias.
 */
public class GrumosDeDatos_Before {

    public static double costoEnvio(String calle, String ciudad, String pais, String codigoPostal) {
        return pais.equalsIgnoreCase("EC") ? 3.0 : 12.0;
    }

    public static String etiqueta(String calle, String ciudad, String pais, String codigoPostal) {
        return calle + ", " + ciudad + ", " + pais + " " + codigoPostal;
    }
}
