import java.util.*;

/**
 * BLOATERS - large class (ANTES)
 * Problema: clase "Dios" que maneja usuarios + inventario + auditoría en un solo lugar.
 * Resultado: crece sin control, difícil de mantener y extender.
 */
public class ClaseGrande_Before {

    private final Map<String, String> usuarios = new HashMap<>();
    private final Map<String, Integer> stock = new HashMap<>();
    private final List<String> auditoria = new ArrayList<>();

    public void registrarUsuario(String correo, String clave) {
        usuarios.put(correo, clave);
        auditoria.add("USUARIO_REGISTRADO:" + correo);
    }

    public boolean iniciarSesion(String correo, String clave) {
        auditoria.add("INTENTO_LOGIN:" + correo);
        return clave.equals(usuarios.get(correo));
    }

    public void agregarStock(String sku, int cantidad) {
        stock.put(sku, stock.getOrDefault(sku, 0) + cantidad);
        auditoria.add("STOCK_AGREGADO:" + sku + ":" + cantidad);
    }

    public boolean vender(String sku, int cantidad) {
        int actual = stock.getOrDefault(sku, 0);
        if (actual < cantidad) return false;
        stock.put(sku, actual - cantidad);
        auditoria.add("VENTA:" + sku + ":" + cantidad);
        return true;
    }

    public List<String> verAuditoria() {
        return auditoria;
    }
}
