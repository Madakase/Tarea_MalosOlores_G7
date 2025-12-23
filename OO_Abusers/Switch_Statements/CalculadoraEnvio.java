public class CalculadoraEnvio {

    //Switch complejo
    public double calcularCosto(String tipoEnvio, double peso) {
        switch (tipoEnvio) {
            case "TERRESTRE":
                return peso * 1.5;
            case "AEREO":
                return peso * 3.0;
            case "MARITIMO":
                return peso * 1.2;
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }
}