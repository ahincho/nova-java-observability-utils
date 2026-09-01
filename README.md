# Nova Observability Utils

The Four Golden Signals — latency, traffic, errors, saturation — as a
framework-free contract. This library defines *what* is measured and what
each metric is called; the starters for Spring Boot and the extensions for
Quarkus decide *how* it reaches your backend.

Keeping the contract here is what stops two Nova services from reporting
the same signal under two different metric names.

## What's inside

| Type | Purpose |
|---|---|
| `GoldenSignalsRecorder` | The interface a framework adapter implements |
| `MetricNames` | The canonical metric names, as constants |
| `@Traced` | Marks a method for span creation |
| `@Metered` | Marks a method for latency and traffic recording |
| `ErrorClassification` | How a failure is bucketed |

### The metric names

```
golden_signals_latency_seconds
golden_signals_latency_mean_milliseconds
golden_signals_latency_max_milliseconds
golden_signals_traffic_requests_total
golden_signals_errors_total
golden_signals_saturation_active_requests
golden_signals_saturation_heap_ratio
```

### The recorder contract

```java
void recordLatency(String method, String uri, long durationNanos);
void recordTraffic(String method, String uri, int statusCode);
void recordError(String method, String uri, int statusCode, String errorType);
void incrementActive();
void decrementActive();
```

## Install

Published to GitHub Packages, so the repository needs to be declared and
authenticated with a token that has `read:packages`.

```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/ahincho/nova-java-observability-utils")
        credentials {
            username = providers.gradleProperty("gpr.user").orNull ?: System.getenv("GITHUB_ACTOR")
            password = providers.gradleProperty("gpr.key").orNull ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation("pe.edu.nova.java.libs:nova-observability-utils:0.1.0-SNAPSHOT")
}
```

## Use

Most applications never call this directly. Add the starter for your
stack and it supplies a `GoldenSignalsRecorder`, wires the servlet filter
and exposes the metrics:

- [nova-java-observability-spring-boot-starter](https://github.com/ahincho/nova-java-observability-spring-boot-starter)

Then annotate anything worth measuring beyond the HTTP layer:

```java
@Traced
@Metered
public Invoice settle(Order order) { ... }
```

## Background

The decision to standardise on the Four Golden Signals is recorded in
[ADR-014](https://github.com/ahincho/nova-docs/blob/main/adrs/shared/ADR-014-observabilidad-four-golden-signals.md).

## Requirements

Java 25.

## License

Eclipse Public License 2.0 — see [LICENSE](LICENSE).

Copyright © 2026 Angel Hincho.
