import java.util.*;

/**
 * BLOATERS - large class (DESPUÉS)
 * Solución: separar responsabilidades en clases pequeñas (ServicioUsuarios, ServicioInventario, ServicioAuditoria).
 * Beneficio: cada clase cambia por una sola razón, es más mantenible.
 */
public class ClaseGrande_After {

    public static class ServicioAuditoria {
        private final List<String> eventos = new ArrayList<>();
        public void registrar(String evento) { eventos.add(evento); }
        public List<String> ver() { return eventos; }
    }

    public static class ServicioUsuarios {
        private final Map<String, String> usuarios = new HashMap<>();
        private final ServicioAuditoria auditoria;

        public ServicioUsuarios(ServicioAuditoria auditoria) {
            this.auditoria = auditoria;
        }

        public void registrarUsuario(String correo, String clave) {
            usuarios.put(correo, clave);
            auditoria.registrar("USUARIO_REGISTRADO:" + correo);
        }

        public boolean iniciarSesion(String correo, String clave) {
            auditoria.registrar("INTENTO_LOGIN:" + correo);
            return clave.equals(usuarios.get(correo));
        }
    }

    public static class ServicioInventario {
        private final Map<String, Integer> stock = new HashMap<>();
        private final ServicioAuditoria auditoria;

        public ServicioInventario(ServicioAuditoria auditoria) {
            this.auditoria = auditoria;
        }

        public void agregarStock(String sku, int cantidad) {
            stock.put(sku, stock.getOrDefault(sku, 0) + cantidad);
            auditoria.registrar("STOCK_AGREGADO:" + sku + ":" + cantidad);
        }

        public boolean vender(String sku, int cantidad) {
            int actual = stock.getOrDefault(sku, 0);
            if (actual < cantidad) return false;
            stock.put(sku, actual - cantidad);
            auditoria.registrar("VENTA:" + sku + ":" + cantidad);
            return true;
        }
    }
}
