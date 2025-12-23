/**
 * CHANGE PREVENTERS - shotgun surgery (DESPUÉS)
 * Solución: centralizar la regla en una sola clase (PoliticaCorreo).
 * Beneficio: cambias la regla en un lugar y listo.
 */
public class CirugiaEscopeta_After {

    public static class PoliticaCorreo {
        public boolean esCorporativo(String correo) {
            return correo != null && correo.toLowerCase().endsWith("@empresa.com");
        }
    }

    public static class ServicioUsuarios {
        private final PoliticaCorreo politica = new PoliticaCorreo();
        public boolean puedeRegistrarse(String correo) { return politica.esCorporativo(correo); }
    }

    public static class ModuloReportes {
        private final PoliticaCorreo politica = new PoliticaCorreo();
        public boolean puedeAcceder(String correo) { return politica.esCorporativo(correo); }
    }
}
