package pe.edu.nova.java.libs.observability.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marca un método para que el starter registre automáticamente
 * la latencia (Timer) y el conteo de invocaciones (Counter)
 * como métricas de Micrometer.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Metered {
    /**
     * Nombre base de la métrica.
     * Por defecto se usa el nombre completo del método.
     *
     * @return nombre de la métrica o cadena vacía para usar el nombre del método
     */
    String value() default "";
}
