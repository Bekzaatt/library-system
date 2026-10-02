data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    val genre: String,
    var isAvailable: Boolean = true
)
