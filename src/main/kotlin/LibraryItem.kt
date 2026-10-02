interface Describable {
    fun describe(): String
}

abstract class LibraryItem(open val title: String) : Describable {
    abstract fun getType(): String

    override fun describe(): String {
        return "$title (${getType()})"
    }
}

class PrintedBook(override val title: String, val pages: Int) : LibraryItem(title) {
    override fun getType(): String = "Printed Book"
}

class EBook(override val title: String, val sizeMb: Double) : LibraryItem(title) {
    override fun getType(): String = "E-Book"

    override fun describe(): String {
        return super.describe() + " - ${sizeMb}MB file"
    }
}
