sealed class LibraryEvent {
    data class BookAdded(val book: Book) : LibraryEvent()
    data class BookBorrowed(val book: Book, val user: String) : LibraryEvent()
    data class BookReturned(val book: Book, val user: String) : LibraryEvent()
    data class Error(val message: String) : LibraryEvent()
}

fun handleEvent(event: LibraryEvent) {
    when (event) {
        is LibraryEvent.BookAdded -> println("[ADDED] ${event.book.title}")
        is LibraryEvent.BookBorrowed -> println("[BORROWED] ${event.user} took \"${event.book.title}\"")
        is LibraryEvent.BookReturned -> println("[RETURNED] ${event.user} returned \"${event.book.title}\"")
        is LibraryEvent.Error -> println("[ERROR] ${event.message}")
    }
}
