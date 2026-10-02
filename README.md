# library-system
1. Project name and short description
Library Management System
A console application that simulates a small library: adding books, borrowing and returning them, checking availability, and viewing book ratings.

2. How to run the project
Open the project folder in IntelliJ IDEA as a Gradle project, let it sync dependencies, then open Main.kt and click the green Run button next to fun main().

3. Where the main homework requirements are demonstrated
Variables, data types, conditions, loops — in Main.kt (if/else, for, while)
List, Set, Map — in Library.kt (books list, genres set, catalog map)
map/filter/reduce — in Library.kt (getAvailableBooks, getTitles, sumOfYears)
Functions, higher-order functions, lambdas — processBooks function in Library.kt
Classes and objects — Book, Library, LibraryItem
Inheritance — PrintedBook and EBook extend LibraryItem
Interfaces and polymorphism — Describable interface, overridden describe() method
Data class — Book.kt
Sealed class — LibraryEvent in Events.kt
Suspend function and coroutine — fetchBookRating in Library.kt, called with async/awaitAll in Main.kt

