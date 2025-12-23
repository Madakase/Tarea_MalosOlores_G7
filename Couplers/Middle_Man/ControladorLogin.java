public class ControladorLogin {

    private ServicioAutenticacion servicio;

    public ControladorLogin(ServicioAutenticacion servicio) {
        this.servicio = servicio;
    }

    /*Esto no agrega lógica */
    public boolean autenticar(String usuario, String clave) {
        return servicio.autenticar(usuario, clave);
    }
}