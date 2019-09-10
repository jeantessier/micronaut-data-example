package micronaut.data.example

import io.micronaut.http.annotation.*
import io.micronaut.spring.tx.annotation.*
import java.text.*

import javax.inject.Inject;

@Controller("/book")
class BookController {

    @Inject
    BookRepository bookRepository

    @Get("/")
    @Transactional(readOnly = true)
    def index() {
        bookRepository.findAll()
    }

    @Get("/{id}")
    @Transactional(readOnly = true)
    def show(Long id) {
        bookRepository.findById(id).orElse(null)
    }

    @Post("/")
    @Transactional
    def save(String title, int pages) {
        Book book = new Book(title: title, pages: pages)
        bookRepository.save(book)
        return book
    }

}
