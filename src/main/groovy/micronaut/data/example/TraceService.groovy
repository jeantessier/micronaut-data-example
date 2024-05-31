package micronaut.data.example

import io.micronaut.http.HttpRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import jakarta.inject.Singleton
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Singleton
class TraceService {

    private static final Logger LOG = LoggerFactory.getLogger(TraceService.class)

    Flux<Boolean> trace(HttpRequest<?> request) {
        Mono.fromCallable(() -> {
            if (LOG.isInfoEnabled()) {
                LOG.info("Tracing request: " + request.getUri())
            }
            return true
        }).flux().subscribeOn(Schedulers.boundedElastic())
    }

}
