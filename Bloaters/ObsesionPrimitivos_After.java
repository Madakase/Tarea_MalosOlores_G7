/**
 * BLOATERS - primitive obsession (DESPUÉS)
 * Solución: reemplazar primitivos por Value Objects (IdCliente, Dinero, Telefono).
 * Beneficio: reglas encapsuladas, menos validación repetida, dominio más claro.
 */
public class ObsesionPrimitivos_After {

    public record IdCliente(String valor) {
        public IdCliente {
            if (valor == null || valor.isBlank()) throw new IllegalArgumentException("IdCliente inválido");
        }
    }

    public record Dinero(int centavos) {
        public Dinero {
            if (centavos <= 0) throw new IllegalArgumentException("Dinero inválido");
        }

        public static Dinero dolares(double cantidad) {
            return new Dinero((int) Math.round(cantidad * 100));
        }

        @Override
        public String toString() {
            return (centavos / 100.0) + " USD";
        }
    }

    public record Telefono(String valor) {
        public Telefono {
            if (valor == null) throw new IllegalArgumentException("Telefono inválido");
            String soloDigitos = valor.replaceAll("\\D", "");
            if (soloDigitos.length() < 7) throw new IllegalArgumentException("Telefono inválido");
        }
    }

    public static void cobrar(IdCliente id, Dinero monto, Telefono telefono) {
        System.out.println("Cobrando a " + id.valor() + " monto=" + monto + " telefono=" + telefono.valor());
    }
}
