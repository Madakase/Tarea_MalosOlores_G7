public class EmpleadoTemporal extends Empleado {

    @Override
    public void registrarHorasExtra() {
        throw new UnsupportedOperationException(
            "Empleado temporal no registra horas extra"
        );
    }
}