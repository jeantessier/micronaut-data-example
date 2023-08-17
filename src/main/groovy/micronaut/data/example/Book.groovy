package micronaut.data.example

import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.serde.annotation.Serdeable

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Serdeable
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

}
