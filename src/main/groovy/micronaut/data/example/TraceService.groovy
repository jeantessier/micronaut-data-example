package micronaut.data.example

import io.micronaut.http.HttpRequest
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Singleton

@Singleton
class TraceService {

    private static final Logger LOG = LoggerFactory.getLogger(TraceService.class)

    Flowable<Boolean> trace(HttpRequest<?> request) {
        Flowable.fromCallable({ ->
            if (LOG.isInfoEnabled()) {
                LOG.info("Tracing request: " + request.getUri())
            }
            return true
        }).subscribeOn(Schedulers.io())
    }

}
