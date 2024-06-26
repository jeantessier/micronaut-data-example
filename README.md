# Micronaut-Data Example

This example combines Micronaut with Micronaut-Data, backed by MySQL, in Groovy.

I used the [Micronaut-Data documentation](https://micronaut-projects.github.io/micronaut-data/snapshot/guide/)
as a starting point.

There is a single domain class `Book` that uses UUIDs for its IDs.

## To Run:

    ./gradlew run

##  Sample Queries

### CRUD

You can create an entry with:

    http :8080/book "title=Jean was here" pages=500

You can list existing entries with:

    http :8080/book

You can fetch a specific entry with:

    http :8080/book/1

You can modify an entry with:

    http PATCH :8080/book/1 pages=1000

You can delete an entry with:

    http DELETE :8080/book/1

You can delete all entries with:

    http DELETE :8080/book

### Search

Searches are case-insensitive.

You can search by title with:

    http :8080/search q==jean%

Searches behave the same as `LIKE` queries in SQL.

* `jean%` matches titles starting with "jean"
* `%jean%` matches titles containing "jean" anywhere in them
* `%jean` matches titles ending with "jean"
* `jean%here` matches titles starting with "jean" and ending with "here"

Searches also support `POST` requests:

    http :8080/search q=jean%
