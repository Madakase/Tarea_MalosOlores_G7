/**
 * BLOATERS - primitive obsession (ANTES)
 * Problema: usar String/double para conceptos con reglas (id, dinero, teléfono).
 * Resultado: validaciones dispersas, errores fáciles, reglas inconsistentes.
 */
public class ObsesionPrimitivos_Before {

    public static void cobrar(String idCliente, double monto, String telefono) {
        if (idCliente == null || idCliente.isBlank()) throw new IllegalArgumentException("idCliente inválido");
        if (monto <= 0) throw new IllegalArgumentException("monto inválido");
        if (telefono == null || telefono.length() < 7) throw new IllegalArgumentException("telefono inválido");

        System.out.println("Cobrando a " + idCliente + " monto=" + monto + " telefono=" + telefono);
    }
}
