public class EmpleadoTemporal extends Empleado {

    @Override

    //Método de superclase que no puede ser usado
    public void registrarHorasExtra() {
        throw new UnsupportedOperationException(
            "Empleado temporal no registra horas extra"
        );
    }
}