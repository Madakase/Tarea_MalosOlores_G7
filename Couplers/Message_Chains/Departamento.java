public class Departamento {
    private Empleado jefe;

    public Departamento(Empleado jefe) {
        this.jefe = jefe;
    }

    public Empleado getJefe() {
        return jefe;
    }
}