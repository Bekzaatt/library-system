import kotlinx.coroutines.delay

class Library {

    private val books = mutableListOf<Book>()
    private val genres = mutableSetOf<String>()
    private val catalog = mutableMapOf<Int, Book>()

    fun addBook(book: Book): LibraryEvent {
        books.add(book)
        catalog[book.id] = book
        genres.add(book.genre)
        return LibraryEvent.BookAdded(book)
    }

    fun borrowBook(id: Int, user: String): LibraryEvent {
        val book = catalog[id] ?: return LibraryEvent.Error("Book with id=$id not found")
        if (!book.isAvailable) return LibraryEvent.Error("\"${book.title}\" is already borrowed")
        book.isAvailable = false
        return LibraryEvent.BookBorrowed(book, user)
    }

    fun returnBook(id: Int, user: String): LibraryEvent {
        val book = catalog[id] ?: return LibraryEvent.Error("Book with id=$id not found")
        book.isAvailable = true
        return LibraryEvent.BookReturned(book, user)
    }

    fun getAllBooks(): List<Book> = books
    fun getGenres(): Set<String> = genres

    fun getAvailableBooks(): List<Book> = books.filter { it.isAvailable }
    fun getTitles(): List<String> = books.map { it.title }
    fun sumOfYears(): Int = books.map { it.year }.reduce { acc, year -> acc + year }

    fun processBooks(action: (Book) -> Unit) {
        for (book in books) {
            action(book)
        }
    }

    suspend fun fetchBookRating(book: Book): Double {
        delay(300) // pretend we are calling a server
        return ((book.title.length % 5) + 1).toDouble()
    }
}
