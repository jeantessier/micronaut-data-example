package micronaut.data.example

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book {
    @Id
    @GeneratedValue
    UUID id
    String title
    int pages

    @DateCreated
    Date dateCreated
    @DateUpdated
    Date dateUpdated

    Book(String title, int pages) {
        this.title = title
        this.pages = pages
    }

    Book() {
    }

}
