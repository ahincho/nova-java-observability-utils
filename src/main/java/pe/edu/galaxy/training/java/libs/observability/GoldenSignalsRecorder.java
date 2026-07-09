package pe.edu.nova.java.libs.observability;

/**
 * Interfaz que define las operaciones de registro de métricas
 * Four Golden Signals.
 * <p>
 * Permite desacoplar la lógica de negocio de la implementación
 * concreta (Micrometer). No tiene dependencias de framework.
 * </p>
 */
public interface GoldenSignalsRecorder {

    /**
     * Registra la latencia de una petición HTTP.
     *
     * @param method        método HTTP (GET, POST, etc.)
     * @param uri           URI normalizada de la petición
     * @param durationNanos duración de la petición en nanosegundos
     */
    void recordLatency(String method, String uri, long durationNanos);

    /**
     * Registra una petición HTTP completada (tráfico).
     *
     * @param method     método HTTP (GET, POST, etc.)
     * @param uri        URI normalizada de la petición
     * @param statusCode código de estado HTTP de la respuesta
     */
    void recordTraffic(String method, String uri, int statusCode);

    /**
     * Registra un error HTTP.
     *
     * @param method     método HTTP (GET, POST, etc.)
     * @param uri        URI normalizada de la petición
     * @param statusCode código de estado HTTP de la respuesta
     * @param errorType  tipo de error (client_error, server_error, etc.)
     */
    void recordError(String method, String uri, int statusCode, String errorType);

    /**
     * Incrementa el contador de peticiones activas (saturación).
     */
    void incrementActive();

    /**
     * Decrementa el contador de peticiones activas (saturación).
     */
    void decrementActive();
}
