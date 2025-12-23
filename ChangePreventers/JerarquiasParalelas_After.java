/**
 * CHANGE PREVENTERS - parallel inheritance hierarchies (DESPUÉS)
 * Solución: eliminar jerarquía paralela usando composición (FiguraRenderable + Renderizador).
 * Beneficio: agregas nuevas figuras sin clonar otra jerarquía.
 */
public class JerarquiasParalelas_After {

    interface Renderizador {
        void dibujarCirculo(double radio);
        void dibujarRectangulo(double ancho, double alto);
    }

    static class RenderizadorConsola implements Renderizador {
        public void dibujarCirculo(double radio) {
            System.out.println("Dibujar círculo radio=" + radio);
        }
        public void dibujarRectangulo(double ancho, double alto) {
            System.out.println("Dibujar rectángulo " + ancho + "x" + alto);
        }
    }

    interface FiguraRenderable {
        double area();
        void renderizar(Renderizador r);
    }

    static class Circulo implements FiguraRenderable {
        double radio;
        Circulo(double radio) { this.radio = radio; }
        public double area() { return Math.PI * radio * radio; }
        public void renderizar(Renderizador r) { r.dibujarCirculo(radio); }
    }

    static class Rectangulo implements FiguraRenderable {
        double ancho, alto;
        Rectangulo(double ancho, double alto) { this.ancho = ancho; this.alto = alto; }
        public double area() { return ancho * alto; }
        public void renderizar(Renderizador r) { r.dibujarRectangulo(ancho, alto); }
    }
}

