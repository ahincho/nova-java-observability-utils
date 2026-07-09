package pe.edu.nova.java.libs.observability.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marca un método para que el starter cree un span de traza
 * que envuelva su ejecución.
 * <p>
 * Si se proporciona un valor, se usa como nombre del span;
 * de lo contrario, se usa el nombre del método.
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Traced {
    /**
     * Nombre personalizado del span.
     * Por defecto se usa el nombre del método.
     *
     * @return nombre del span o cadena vacía para usar el nombre del método
     */
    String value() default "";
}
