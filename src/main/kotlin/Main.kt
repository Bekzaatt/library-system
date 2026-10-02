import kotlinx.coroutines.*

fun main() = runBlocking {
    println("=== Library Management System ===\n")

    val library = Library()

    val welcomeMessage: String = "Welcome to the console library!"
    val maxBooksAllowed: Int = 5
    println(welcomeMessage)
    println("Max books allowed per user: $maxBooksAllowed\n")

    handleEvent(library.addBook(Book(1, "Kotlin in Action", "Dmitry Jemerov", 2017, "Programming")))
    handleEvent(library.addBook(Book(2, "Clean Code", "Robert Martin", 2008, "Programming")))
    handleEvent(library.addBook(Book(3, "1984", "George Orwell", 1949, "Fiction")))

    println()

    for (book in library.getAllBooks()) {
        val status = if (book.isAvailable) "available" else "borrowed"
        println("${book.title} by ${book.author} ($status)")
    }

    var counter = 0
    while (counter < 3) {
        println("Routine check #${counter + 1} passed")
        counter++
    }

    println()

    handleEvent(library.borrowBook(1, "Alice"))
    handleEvent(library.borrowBook(1, "Bob"))      // will produce an Error event (already borrowed)
    handleEvent(library.returnBook(1, "Alice"))

    println()

    println("Available books: ${library.getAvailableBooks().map { it.title }}")
    println("All titles: ${library.getTitles()}")
    println("Sum of publication years: ${library.sumOfYears()}")
    println("Genres in library: ${library.getGenres()}")

    println()

    println("Describing items polymorphically:")
    val items: List<LibraryItem> = listOf(
        PrintedBook("Kotlin in Action", 360),
        EBook("Clean Code", 4.2)
    )
    for (item in items) {
        println(" - ${item.describe()}")
    }

    println()

    println("Processing every book with a lambda:")
    library.processBooks { book -> println(" > Checking: ${book.title}") }

    println()

    println("Fetching ratings concurrently (coroutines):")
    val ratingJobs = library.getAllBooks().map { book ->
        async {
            val rating = library.fetchBookRating(book)
            println(" * ${book.title} -> rating $rating")
        }
    }
    ratingJobs.awaitAll()

    println("\nDone. Thanks for visiting the library!")
}
