/**
 * CHANGE PREVENTERS - shotgun surgery (ANTES)
 * Problema: una regla repetida en varios lugares (correo corporativo).
 * Resultado: un cambio simple obliga a modificar muchos archivos.
 */
public class CirugiaEscopeta_Before {

    public static boolean esCorreoCorporativo(String correo) {
        return correo != null && correo.endsWith("@empresa.com");
    }
}

class ModuloReportes_Before {
    public boolean puedeAcceder(String correo) {
        return correo != null && correo.endsWith("@empresa.com");
    }
}
