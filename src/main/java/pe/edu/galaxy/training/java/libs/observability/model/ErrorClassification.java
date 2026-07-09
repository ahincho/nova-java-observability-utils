package pe.edu.nova.java.libs.observability.model;

/**
 * Clasificación de errores HTTP según los Four Golden Signals.
 * <p>
 * Permite categorizar códigos de estado HTTP en tipos de error
 * para el registro de métricas de errores.
 * </p>
 */
public enum ErrorClassification {

    /** Error del cliente (códigos 400-499, excepto 429). */
    CLIENT_ERROR,

    /** Petición limitada por rate limiting (código 429). */
    RATE_LIMITED,

    /** Error del servidor (códigos 500+, excepto 503). */
    SERVER_ERROR,

    /** Servicio no disponible (código 503). */
    SERVICE_UNAVAILABLE;

    /**
     * Clasifica un código de estado HTTP en un tipo de error.
     * <p>
     * Reglas de clasificación:
     * <ul>
     *   <li>429 → {@link #RATE_LIMITED}</li>
     *   <li>503 → {@link #SERVICE_UNAVAILABLE}</li>
     *   <li>400-499 (excepto 429) → {@link #CLIENT_ERROR}</li>
     *   <li>500+ (excepto 503) → {@link #SERVER_ERROR}</li>
     *   <li>Menor a 400 → {@code null} (no es un error)</li>
     * </ul>
     *
     * @param statusCode código de estado HTTP
     * @return la clasificación del error, o {@code null} si el código no representa un error
     */
    public static ErrorClassification classify(int statusCode) {
        if (statusCode < 400) {
            return null;
        }
        if (statusCode == 429) {
            return RATE_LIMITED;
        }
        if (statusCode == 503) {
            return SERVICE_UNAVAILABLE;
        }
        if (statusCode >= 500) {
            return SERVER_ERROR;
        }
        return CLIENT_ERROR;
    }
}
