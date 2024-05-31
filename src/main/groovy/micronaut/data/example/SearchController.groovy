package micronaut.data.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import jakarta.transaction.Transactional

@Controller("/search")
class SearchController {

    @Inject
    BookRepository bookRepository

    @Get("/")
    @Transactional
    def index(String q) {
        bookRepository.findAllByTitleIlike(q)
    }

    @Post("/")
    @Transactional
    def search(String q) {
        bookRepository.findAllByTitleIlike(q)
    }

}
