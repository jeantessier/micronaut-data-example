package micronaut.data.example

import io.micronaut.http.*
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
    def show(UUID id) {
        bookRepository.findById(id).orElse(null)
    }

    @Post("/")
    @Transactional
    def save(String title, int pages) {
        Book book = new Book(title: title, pages: pages)
        bookRepository.save(book)
        return HttpResponse.created(book)
    }

    @Patch("/{id}")
    @Transactional
    def update(UUID id, Optional<String> title, Optional<Integer> pages) {
        if (title.present) {
            bookRepository.update(id, title.get())
        }
        if (pages.present) {
            bookRepository.update(id, pages.get())
        }

        return HttpResponse.temporaryRedirect(new URI("/book/${id}"))
    }

    @Delete("/")
    @Transactional
    def delete() {
        bookRepository.deleteAll()

        return HttpResponse.noContent()
    }

    @Delete("/{id}")
    @Transactional
    def delete(UUID id) {
        bookRepository.deleteById(id)

        return HttpResponse.noContent()
    }

}
