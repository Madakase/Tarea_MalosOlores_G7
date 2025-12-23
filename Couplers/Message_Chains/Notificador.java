public class Notificador {

    /*Cadena muy larga de dependencias */
    public void enviarCorreo(Empresa empresa) {
        String email = empresa.getDepartamento().getJefe().getEmail();

        System.out.println("Enviando correo a " + email);
    }
}