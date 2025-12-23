/**
 * BLOATERS - long parameter list (ANTES)
 * Problema: método con demasiados parámetros (difícil de usar y fácil de confundir).
 * Resultado: llamadas largas, errores por orden, cambios rompen firmas.
 */
public class ListaParametrosLarga_Before {

    public static String crearUsuario(
            String nombres, String apellidos, String correo, String telefono,
            String direccion, String ciudad, String pais, String codigoPostal,
            boolean suscritoBoletin, boolean vip
    ) {
        return nombres + " " + apellidos + " (" + correo + ") - " + ciudad + ", " + pais;
    }
}
