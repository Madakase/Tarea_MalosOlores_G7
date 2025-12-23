public class ReporteVentas {

    private double total;
    private int cantidad;

    // Campos temporales
    private double promedio;
    private boolean calculado;

    public ReporteVentas(double total, int cantidad) {
        this.total = total;
        this.cantidad = cantidad;
    }

    public void calcularPromedio() {
        if (cantidad > 0) {
            promedio = total / cantidad;
            calculado = true;
        }
    }

    public double obtenerPromedio() {
        if (!calculado) {
            throw new IllegalStateException("Promedio no calculado");
        }
        return promedio;
    }
}