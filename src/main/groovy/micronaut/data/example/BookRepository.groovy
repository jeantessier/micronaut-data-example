package micronaut.data.example

import io.micronaut.data.annotation.*
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository extends CrudRepository<Book, UUID> {

    Book find(String title)

    void update(@Id UUID id, String title)

    void update(@Id UUID id, int pages)

}
