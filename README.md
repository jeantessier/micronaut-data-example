# Micronaut-Data Example

This example combines Micronaut with Micronaut-Data, backed by MySQL, in Groovy.

I used the [Micronaut-Data documentation](https://micronaut-projects.github.io/micronaut-data/snapshot/guide/)
as a starting point.

## To Run:

    $ ./gradlew run

You can create an entry with:

    $ http POST :8080/book "title=Jean was here" pages=500

You can list existing entries with:

    $ http :8080/book

You can fetch a specific entry with:

    $ http :8080/book/1
