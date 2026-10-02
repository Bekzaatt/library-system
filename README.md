# Library Management System (Kotlin Console App)

A small console application that simulates a library: adding books, borrowing/returning
them, and reviewing the catalog. Built purely in Kotlin/JVM (no Android UI) to demonstrate
core Kotlin and OOP concepts in one connected program.

## How to run

### Option A — IntelliJ IDEA (recommended)
1. Open IntelliJ IDEA → `Open` → select the `library-system` folder.
2. Let IntelliJ import it as a Gradle project (it will download the wrapper automatically).
3. Open `src/main/kotlin/Main.kt` and click the green ▶ run button next to `fun main()`.

### Option B — Command line (if you have Gradle installed)
```bash
gradle run
```

## Project structure
```
src/main/kotlin/
 ├─ Book.kt        -> data class
 ├─ LibraryItem.kt -> interface, abstract class, inheritance, polymorphism
 ├─ Events.kt       -> sealed class + event handling function
 ├─ Library.kt      -> collections, higher-order functions, suspend function
 └─ Main.kt         -> entry point, ties everything together
```

## Where each requirement is demonstrated

| Requirement | Location |
|---|---|
| Variables, data types, conditions, loops | `Main.kt` (val/var, if/else, for, while) |
| List, Set, Map | `Library.kt` (`books`, `genres`, `catalog`) |
| map / filter / reduce | `Library.kt` (`getAvailableBooks`, `getTitles`, `sumOfYears`) |
| Functions, higher-order functions, lambdas | `Library.kt` (`processBooks`), used in `Main.kt` |
| Classes and objects | `Book`, `Library`, `LibraryItem` and subclasses |
| Inheritance | `LibraryItem.kt` (`PrintedBook`, `EBook` extend `LibraryItem`) |
| Interfaces and polymorphism | `Describable` interface, overridden `describe()` |
| Data class | `Book.kt` |
| Sealed class | `Events.kt` (`LibraryEvent`) |
| Suspend function + coroutine | `Library.kt` (`fetchBookRating`), launched with `async`/`awaitAll` in `Main.kt` |

## Example output (shortened)
```
=== Library Management System ===
[ADDED] Kotlin in Action
[ADDED] Clean Code
[ADDED] 1984
Kotlin in Action by Dmitry Jemerov (available)
...
[BORROWED] Alice took "Kotlin in Action"
[ERROR] "Kotlin in Action" is already borrowed
[RETURNED] Alice returned "Kotlin in Action"
Available books: [Kotlin in Action, Clean Code, 1984]
...
Fetching ratings concurrently (coroutines):
 * Kotlin in Action -> rating 2.0
 * Clean Code -> rating 1.0
 * 1984 -> rating 5.0
Done. Thanks for visiting the library!
```
