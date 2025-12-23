/**
 * BLOATERS - long parameter list (DESPUÉS)
 * Solución: introducir objeto de parámetros (RegistroUsuario) y agrupar (Direccion, Preferencias).
 * Beneficio: firma limpia, evoluciona sin romper llamadas.
 */
public class ListaParametrosLarga_After {

    public record Direccion(String direccion, String ciudad, String pais, String codigoPostal) {}
    public record Preferencias(boolean suscritoBoletin, boolean vip) {}

    public record RegistroUsuario(
            String nombres, String apellidos, String correo, String telefono,
            Direccion direccion, Preferencias preferencias
    ) {}

    public static String crearUsuario(RegistroUsuario registro) {
        return registro.nombres() + " " + registro.apellidos()
                + " (" + registro.correo() + ") - "
                + registro.direccion().ciudad() + ", " + registro.direccion().pais();
    }
}
