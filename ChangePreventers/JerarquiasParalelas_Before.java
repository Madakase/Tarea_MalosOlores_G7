/**
 * CHANGE PREVENTERS - parallel inheritance hierarchies (ANTES)
 * Problema: por cada nueva figura, debes crear también un nuevo "renderizador" (jerarquía paralela).
 * Resultado: el sistema crece duplicado y amarrado: dos árboles que deben evolucionar juntos.
 */
public class JerarquiasParalelas_Before {

    static abstract class Figura {
        abstract double area();
    }

    static class Circulo extends Figura {
        double radio;
        Circulo(double radio) { this.radio = radio; }
        double area() { return Math.PI * radio * radio; }
    }

    static class Rectangulo extends Figura {
        double ancho, alto;
        Rectangulo(double ancho, double alto) { this.ancho = ancho; this.alto = alto; }
        double area() { return ancho * alto; }
    }

    static abstract class RenderizadorFigura {
        abstract void renderizar(Figura f);
    }

    static class RenderizadorCirculo extends RenderizadorFigura {
        void renderizar(Figura f) { System.out.println("Renderizar círculo"); }
    }

    static class RenderizadorRectangulo extends RenderizadorFigura {
        void renderizar(Figura f) { System.out.println("Renderizar rectángulo"); }
    }
}
