package org.example.courseTwo

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.random.Random

fun main(args: Array<String>) {
//    classesLesson(args)
//    interfacesLesson(args)
//    enumsLesson(args)
//    dataClassesLesson(args)
//    objectClassesLesson(args)
//    sealedClassesLesson(args)
//    companionObjetsLesson(args)
//    sealedClassesChallenge(args)
//    topLevelVariablesLesson(args)
//    extensionPropertiesLesson(args)
//    delegationLesson(args)
//    topLevelFunctionsChallenge(args)
//    threadsLesson(args)
    asyncChallenge(args)
}

/* First Object-Oriented lesson working with classes Begins */

fun classesLesson(args: Array<String>) {
    val person: Person = Student(15, "John", "Smith", 175)
    person.age
    person.printName()

}

/* First Object-Oriented lesson working with classes Ends */

/* Second Object-Oriented lesson working with interfaces Begins */

interface StringProvider {
    val placeHolder: String // Can't initialize property in interface, but it can be overrided in extended interfaces
    fun getString(id: Int): String = "Id: $id"
}

interface ResourceProvider: StringProvider { // Extending interface
    fun getDimension(id: Int): Long = id.toLong() // Default implementation
}

class DefaultResourceProvider: ResourceProvider { // All of implemented interface functions must be implemented

    override val placeHolder = "<placeholder>"
    // Resource provider doesn't need to implement other interface function since that interface have implementation of function
}

fun interfacesLesson(args: Array<String>) {
    val someVariable: Any? = null
    if (someVariable is StringProvider) {
        println("The variable was StringProvider")
    }

    var stringProvider: DefaultResourceProvider = DefaultResourceProvider() // Created interface variable with assigned implemented interface DefaultResourceProvider
    println(stringProvider.getString(0))
    println(stringProvider.getDimension(1))
    println(stringProvider.placeHolder)
}

/* Second Object-Oriented lesson working with interfaces Ends */

/* Third Object-Oriented lesson working with Enums Begins */

fun enumsLesson(args: Array<String>) {
    val direction:Direction = Direction.WEST // Created Enum that holds selected value
    println(direction.name) // Name value is string representation of selected value
    println(direction.ordinal) // Ordinal value is index value of that type
    val parsedDirection: Direction = Direction.valueOf("WEST") // Value can be taken by enum value
    println(parsedDirection.name)

    val apiValue = Direction.entries[2] // It's possible to get all values of Enum with enties
    println(apiValue.name)

    val color: HighlightColor = HighlightColor.BLUE
    println(color.value) // Accessing color enum argument parameter
}

/* Third Object-Oriented lesson working with Enums Ends */

/* Fourth Object-Oriented lesson working with Data classes Begins */

fun dataClassesLesson(args: Array<String>) {
    val task1 = Task("a1", "Add analytics") // Org task name: Build search feature
    val task2 = Task("b2", "Add analytics")
    println(task1.name)
    println(task2.name)

    val task2Copy = task2.copy() // Creates copy of data class automatically with variables
    val (id, name) = task1 // Destructuring makes exactly the same as task1 values, if only two values are used for it, it will take only those two values

    if (task1.name == task2.name) { // Comparison of two names
        println("Tasks are the same")
    } else {
        println("Tasks are different")
    }

    if (task1 == task2) { // Compiler handles comparison of data class constructor variables, so there are no need to compare manually
        println("Tasks are the same")
    } else {
        println("Tasks are different")
    }

    if (task2Copy == task2) { // Compiler handles comparison of data class constructor variables, so there are no need to compare manually
        println("Tasks are the same")
    } else {
        println("Tasks are different")
    }
}

/* Fourth Object-Oriented lesson working with Data classes Ends */

/* Fifth Object-Oriented lesson working with Object classes Begins */

fun objectClassesLesson(args: Array<String>) {

    println(NetworkConfig.baseUrl)
    println(NetworkConfig.getNetworkDetails()) // Objects implemented interface function

    val provider: NetworkInfoProvider = object: NetworkInfoProvider { // object provider only exists in this scope cycle

        override fun getNetworkDetails(): String {
            return "Mu haha"
        }

    }

    println(provider.getNetworkDetails())

}

/* Fifth Object-Oriented lesson working with Object classes Ends */

/* Sixth Object-Oriented lesson working with Sealed classes Begins */

fun render(state: UiState) { // It's eather
    when (state) {
        is UiState.Loading -> println("Loading...")
        is UiState.Loaded -> {
            println("Loaded: ${state.title}")
        }
        is UiState.Error -> println("Error")
    }
}

fun sealedClassesLesson(args: Array<String>) {

    var state: UiState = UiState.Loading
    render(state)
    state = UiState.Loaded(title = "Kotlin", subtitle = "Is cool!")
    render(state)
    state = UiState.Error(IllegalStateException())
    render(state)

}

/* Sixth Object-Oriented lesson working with Sealed classes Ends */

/* Seventh Object-Oriented lesson working with Companion objects Begins */

// Kotlin doesn't have static variables
// This can be done using Companion objects

fun companionObjetsLesson(args: Array<String>) {
//    val controller = SearchController.Companion.create("Kotlin") // This is full calling of function
    val controller = SearchController.create("Kotlin") // If it's invoked in kotlin, it doesn't need companion
}

/* Seventh Object-Oriented lesson working with Companion objects Ends */

/* Object-Oriented challenge working with Sealed class Begins */

fun getRandomString(): String {
    val rand = Random.nextInt(10)
    return if (rand > 5) {
        throw IllegalStateException()
    } else {
        rand.toString()
    }
}

fun getString(): StringResult {
    return try {
        StringResult.Success(getRandomString())
    } catch (exception: IllegalStateException) {
        StringResult.Failure(exception)
    }
}

fun sealedClassesChallenge(args: Array<String>) {

    when (val state = getString()) {
        is StringResult.Success -> println(state.result)
        is StringResult.Failure -> println("Error: ${state.error.toString()}")
    }

}

/* Object-Oriented challenge working with Sealed class Ends */

/* First Idiomatic lesson working with Top-level properties Starts */

const val DEFAULT_CLICK_DELAY = 500
private fun log(error: Throwable) = println(error)

fun topLevelVariablesLesson(args: Array<String>) {

    val duration = millisForMinutesFunc(5)

}
/* First Idiomatic lesson working with Top-level properties Ends */

/* Second Idiomatic lesson working with Extension properties Starts */

val Int.isEven: Boolean // This is Extended Int with boolean variable which checks if its even
get() = this % 2 == 0

fun extensionPropertiesLesson(array: Array<String>) {

    val duration: Int = 5
    val millisMinute = duration.millisForMinutes()
    println(millisMinute)
    println(duration.millisForHours())
    println(100.millisForHours())

    "[abc]+".toRegex()

    println(6.isEven)
    val log: Long = 10L
    log.log()
}

/* Second Idiomatic lesson working with Extension properties Starts */

/* Third Idiomatic lesson working with Delegates Starts */

fun delegationLesson(array: Array<String>) {
    // Created delegate of applicationLogger
//    val applicationLogger = ApplicationLogger(SimpleLogger())
//    applicationLogger.log("example", applicationLogger)
    val viewModel = ViewModel() // Created ViewModel with lazy delegate
    viewModel.search("Kotlin") // First time initialize logger, because we invoke it first time
    viewModel.search("Java")
}

/* Third Idiomatic lesson working with Delegates Ends */

/* Challenge Idiomatic working with top-level functions Begins */

fun topLevelFunctionsChallenge(args: Array<String>) {

    val array = arrayOf(1, 2, 3)
    val set = setOf("a", "b", "c")
    val arrayConvertedList = array.toNonEmptyList()
    val setConvertedList = set.toNonEmptyList()
//    Array .(arrayOf(1, 2, 3))
//    List .setToNonEmptyList(setOf("a", "b", "c"))

}

/* Challenge Idiomatic working with top-level functions Ends */

/* First Async lesson working with Threads Begins */

// It extends thread class and overrides run function
class CustomThread: Thread("CustomThread") {
    override fun run() {
        super.run()
        println(Thread.currentThread().name)
        println("CustomThread.run()")
    }
}

class CustomRunnable: Runnable{ // This is for managing multiple functions, creating runnable which can be passed to thread
    override fun run() {
        println(Thread.currentThread().name)
    }
}

val executor = Executors.newSingleThreadExecutor() // This is threadpool for one thread
val multiThreadExecutors = Executors.newFixedThreadPool(3)

fun threadsLesson(array: Array<String>) {
    println(Thread.currentThread().name)

//    CustomThread().start()
//    CustomThread().start()
//    Thread(CustomRunnable()).start()
//    executor.submit(CustomRunnable()) // Adding thread to threadpool
//    multiThreadExecutors.shutdown(CustomRunnable())
    for (i in 0..10) {
        multiThreadExecutors.submit(CustomRunnable())
    }
}

/* First Async lesson working with Threads Ends */


/* Challenge Async working with Multiple async requests Begins */

// Multiple coroutines can be run on single thread

// Coroutines can be nested one coroutine can be started ir another coroutine

private suspend fun loadItemsFromDB(): List<String> {
    delay(5000)
    return listOf("Kotlin", "Java", "C#")
}

private suspend fun loadItemsFromNetwork(): List<String> {
    delay(5000)
    return listOf("Rust", "Python", "C")
}

fun asyncChallenge(array: Array<String>): Unit = runBlocking {

    val loadedItemsFromNetwork = async { loadItemsFromNetwork() }
    val loadedItemsFromDB = async { loadItemsFromDB() }
    val result = awaitAll(loadedItemsFromNetwork, loadedItemsFromDB) // await also returns results of coroutine
    val mergedResults = result[0] + result[1]
    println(mergedResults)
}

/* Challenge Async working with Multiple async requests Ends */