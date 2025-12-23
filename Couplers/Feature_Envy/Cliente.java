public class Cliente {
    private String nombre;
    private double descuento;

    public Cliente(String nombre, double descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDescuento() {
        return descuento;
    }
}