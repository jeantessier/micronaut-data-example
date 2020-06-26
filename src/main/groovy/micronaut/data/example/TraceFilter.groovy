package micronaut.data.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import org.reactivestreams.Publisher

@Filter("/**")
class TraceFilter implements HttpServerFilter {

    private final TraceService traceService

    TraceFilter(TraceService traceService) {
        this.traceService = traceService
    }

    @Override
    Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        traceService.trace(request)
            .switchMap({ aBoolean -> chain.proceed(request) })
            .doOnNext({ res ->
                res.getHeaders().add("X-Trace-Enabled", "true")
            })
    }

}
