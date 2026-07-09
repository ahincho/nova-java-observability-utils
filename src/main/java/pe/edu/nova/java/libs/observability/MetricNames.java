package pe.edu.nova.java.libs.observability;

/**
 * Constantes de nombres de métricas de los Four Golden Signals.
 * <p>
 * Centraliza los strings para evitar duplicación entre componentes.
 * No tiene dependencias externas.
 * </p>
 */
public final class MetricNames {

    private MetricNames() {
        // No instanciable
    }

    /** Latencia: duración de peticiones HTTP (Timer). */
    public static final String LATENCY = "golden_signals_latency_seconds";

    /** Latencia media en milisegundos (Gauge auxiliar). */
    public static final String LATENCY_MEAN_MS = "golden_signals_latency_mean_milliseconds";

    /** Latencia máxima en milisegundos (Gauge auxiliar). */
    public static final String LATENCY_MAX_MS = "golden_signals_latency_max_milliseconds";

    /** Tráfico: total de peticiones HTTP recibidas (Counter). */
    public static final String TRAFFIC = "golden_signals_traffic_requests_total";

    /** Errores: peticiones HTTP que resultaron en error (Counter). */
    public static final String ERRORS = "golden_signals_errors_total";

    /** Saturación: peticiones HTTP activas concurrentes (Gauge). */
    public static final String ACTIVE_REQUESTS = "golden_signals_saturation_active_requests";

    /** Saturación: ratio de heap JVM usado (Gauge, 0 a 1). */
    public static final String HEAP_RATIO = "golden_signals_saturation_heap_ratio";
}
