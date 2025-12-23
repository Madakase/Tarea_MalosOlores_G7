/**
 * BLOATERS - data clumps (DESPUÉS)
 * Solución: encapsular el “grupo” en una clase/record Direccion.
 * Beneficio: menos duplicación, cambios centralizados.
 */
public class GrumosDeDatos_After {

    public record Direccion(String calle, String ciudad, String pais, String codigoPostal) {}

    public static double costoEnvio(Direccion d) {
        return d.pais().equalsIgnoreCase("EC") ? 3.0 : 12.0;
    }

    public static String etiqueta(Direccion d) {
        return d.calle() + ", " + d.ciudad() + ", " + d.pais() + " " + d.codigoPostal();
    }
}
