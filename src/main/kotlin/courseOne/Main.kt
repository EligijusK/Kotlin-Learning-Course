package courseOne

import java.io.File
import kotlin.collections.iterator
import kotlin.io.path.writeLines
import kotlin.random.Random

fun main(args: Array<String>) { // Main function is by default Unit type arguments can be as string array ir vararg
//    printLesson()
//    numberLesson()
//    stringLesson()
//    nullTypeLesson()
//    functionLesson1()
//    functionLesson2()
//    functionLesson3()
//    functionLesson4()
//    challenge()
//    ifLesson1()
//    ifLesson2()
//    tryCatchBlockLesson()
//    smartCastingLesson()
//    whileLoopLesson()
//    forLoopLesson()
//    flowControlChallenge1()
//    debuggingLesson1()
//    debuggingLesson2()
//    arraysLesson()
//    listsLesson()
//    setsAndMapsLesson()
//    workingWithCollectionsLesson()
//    sequencesLesson()
//    collectionsChallenge()
//    ioArgumentsLesson(args)
//    receivingInputsLesson(args)
//    fileReadWriteLesson(args)
    ioChallenge(args)
}

fun printLesson() {
    val check: Boolean = false // This is in non-mutable
    var mutableCheck: Boolean = false // This is mutable variable
    println("In mutable check if ${check} and mutable check is ${mutableCheck}")
    mutableCheck = true
    println("In mutable check if ${check} and mutable check is ${mutableCheck}")
    println(check) // If check == true
    println(!check) // If check == false
}

fun numberLesson() {
    val aint: Int = 0
    val anotherInt = 0 // Int is 32 bits
    val aByte: Byte = 0 // 8 bits
    val aShort: Short = 0 // 16 bits
    val along: Long = 0 // 64 bits
    val inferredInt = 10
    val inferredLong = 10000000000000
    val anotherLong = 10L // You can write L at the end

    val unsignedInt: UInt = 0U // Unsigned UInt

    val unsignedLong = 0UL // You can also assign unsigned long in this way
    val aDouble: Double = 12.5
    val aFloat: Float = 12.5f

    val inferredDouble = 12.5 // If you do this and not specify var or val by default it will be assigned as double
    val inferredFloat = 12.5f // If you want to use float, you need to add f at the end

    println(5 == 4)
    println(10f > 1)
    println(10.1 < 5.2)

    println(10.5.toInt())
    10.9.toFloat()
    5.toULong()
    println(100_000_000.toByte()) // Lose accuracy because it doesn't fit and it will take what will fit in Byte

}

fun stringLesson() {
    val char: Char = 'a'
    val  aNumericChar: Char = '0'
    val newLineChar = '\n'

//    val concatOption1 = 'a' + 'b' // Can't do this, because Char can't store more than one character
//    val concatOption2 = 'ab' // Same here
    val aString: String = "Hello Kotlin!" // String definition
    val escaped = "Hello\nWorld" // Added new line in between of two words
    println(escaped)

    val rawString = """
        Multiline
        Text
         is working
      as it 
            should work
    """ // multiline text is with """ """

    val rawStringWithoutMargins= """
        |Multiline
        Text
         is working
      as it 
            should work
    """.trimMargin() // Trim margin with pipe character "|" by default

    val rawStringWithoutMarginsSpecified= """
        |Multiline
       <<Text
         is working
      as it 
            should work
    """.trimMargin("<<") // Trim margin with specified characters

    val rawStringWithoutIndentation= """
        Multiline
        Text
        is working
        as it 
            should work
    """.trimIndent()
    val concatString = "Hello" + " " + "World"
    val concatStringWithNum = "Hello" + " " + 0
    println(concatStringWithNum)

    val aNumber = 10
    val concatTemplate = "the number $aNumber" // This is called string templating
    val concatTemplateExpressions = "the number ${aNumber + 1}" // It can be used with expressions
    println(concatTemplate)
    println(concatTemplateExpressions)

    val someString = "Hello there!"
    val someStringBlank = " "
    println(someString.isEmpty())
    println(someString.isNotEmpty())

    println(someStringBlank.isBlank())
    println(someStringBlank.isNotBlank())

    val anotherString = "Hello kotlin!"

    println(anotherString.contains("kotlin"))
}

fun nullTypeLesson() {
//    var aNonNullableString: String = null // This string can't be null
    var nullableString: String? = null // This string can be null
    println(nullableString?.length) // You can get length if null is not null otherwise if its null it prints null
    println(nullableString?.length ?: "the default value") // This is Elvis operator, if its false it will return "the default value"
//    var nullableString2: String? = null
    var nullableString2: String? = ""
    println(nullableString2!!.length) // !! Says that it's not null and if it's a null it will throw an exception
}

/* First function lesson  begins */
// Lesson is basic functions

public fun functionLesson1() {
    fun printGreeting() { // private function of function that can't be accessed outside this function
        println("Hello Kotlin!") // it's a function
    }
    printGreeting()

    fun getGreeting(): String { // return type function that returns String type
        return "Hello Kotlin!"
    }
    println(getGreeting())
    fun getGreeting2() = "Hello Kotlin2!" // single expression function this doesn't require define return type, but it's limited to one line
    println(getGreeting2())

    fun printGreeting3() = println("Hello Kotlin3!") // it will return Unit function return is Unit

    fun printGreeting4(): Unit {
        return println("Hello Kotlin4!")
    }
    println(printGreeting4()) // returns function type since its println
    println(println("smth")) // it returns the same as println(printGreeting4())
    printGreeting4() // if we use as function directly it will call Unit and that how we can create recursion
    privateFunctionLesson()
}

private fun privateFunctionLesson() { // only current class can access this function
    println("Private Hello Kotlin!")
}

/* First function lesson ends */

/* Second function lesson begins */
// Lesson is function parameters

fun functionLesson2() {
    fun getGreeting(greeting: String, thingToGreet: String) = "$greeting $thingToGreet!" // Using String parameters in function
    println(getGreeting("Hi","Jonis"))

    fun greeting(thingToGreet: String) = println("Hello $thingToGreet")
    greeting("John")

    fun defaultGreeting( // Function with default parameters it's not necessary to use only like this
        greeting: String = "Hello",
        thingToGreet: String = "Kotlin"
    ) = "$greeting $thingToGreet!"

    println(defaultGreeting())

    fun defaultGreeting2(greeting: String = "Hi", thingToGreet: String = "Roby"): String { // Another way to write this function
        return "$greeting $thingToGreet!"
    }

    println(defaultGreeting2())

    fun defaultGreeting3( // Another way to format this function, Greeting2 and Greeting3 is for multiline functions
        greeting: String = "Hi",
        thingToGreet: String = "Bob"
    ): String {
        return "$greeting $thingToGreet!"
    }

    println(defaultGreeting3())

    println(defaultGreeting3(greeting = "Hey")) // Named arguments
    println(defaultGreeting3(thingToGreet =  "Emily")) // Named arguments
    println(defaultGreeting3(thingToGreet =  "Emily", greeting = "Hoodie")) // Named arguments can be changed places
}

/* Second function lesson Ends */

/* Third function lesson Begins */
// Lesson is function types

var greetingFunction: (String, String) -> Unit = { greeting: String, thingToGreet: String ->// variable that hold function it must be initialized by defining it. Defining Lambda function
    println("$greeting $thingToGreet") // it variable is default parameter name that was passed, but you can rename it
}

fun functionLesson3() {
    greetingFunction("Hey", "Noa") // call default defined function
    greetingFunction = { greed,  definedName ->// redefine function
        println("$greed $definedName")
    } // define
    greetingFunction.invoke("Hello", "John")
}

/* Third function lesson Ends */

/* Fourth function lesson Begins */
// Higher-order functions

fun functionLesson4() {
    fun calculator(value1: Int, value2: Int): Int
    {
        return value1 + value2
    }
    fun printCalculatedValue(value1: Int, value2: Int, calculator: (Int, Int) -> Int) { // Defining lambda function for passing function
        println("The value is: ${calculator(value1, value2)}") // Passing and using calculator function
    }

    printCalculatedValue(102, 5, {value1, value2 -> calculator(value1, value2)}) // You can pass functions like this
    printCalculatedValue(10, 5, {value1, value2 -> value1 + value2}) // Or you can define functions like this

    printCalculatedValue(10, 5 ) {value1, value2 -> value1 + value2} // This is more readable
}

/* Fourth function lesson Ends */

/* Challenge begin */

fun firstLastName(firstname: String, lastName: String, format: (String, String) -> String) {
    println(format(firstname, lastName))
}

val formaterFunction: (String, String) -> String = {firstName, lastName ->
    "$firstName $lastName"
}

fun challenge() {
    firstLastName("John", "Doe") { firstName, lastName ->
        "FirstName: $firstName, lastName: $lastName"
    }

    firstLastName("John", "Doe") { firstName, lastName ->
        "LastName: $lastName, firstName: $firstName"
    }

    firstLastName("John", "Doe") { firstName, lastName ->
        "My name is: $firstName and my last name is: $lastName"
    }
    firstLastName("John", "Doe") { firstName, lastName ->
        "My last name is: $lastName and my first name is: $firstName"
    }
    firstLastName("Hey", "Mamacita", formaterFunction)
}

/* Challenge end */

/* First Control Flow Structure lesson Begins */

fun ifLesson1() {
    if (true) println("Yes") else println("No")
    if (true) println("Condition is true")
    else println("Condition is false")
    if (true){
        println("Condition is true in code block")
    }
    val floatValue1: Float = 3.14f
    val floatValue2: Float = 3.14f
    val doubleValue: Double = 3.14
    if (floatValue1.equals(doubleValue)) println("It's equal") else println("It's not equal") // Can't compare double and float and expect result that returns true
    if (floatValue1 > floatValue2) {
        println("It's greater")
    } else if (floatValue1 < floatValue2) {
        println("It's less")
    } else {
        println("It's equal")
    }

    when { // When is the same as if with lambda expressions its like switch statements in other languages
        floatValue1 > 10f -> {
            println("It's greater than 10")
        }
        floatValue1 > 5f -> println("It's greater than 5")
        floatValue1 < 0f -> println("It's less than 0")
        floatValue1 > 0f -> println("It's greater than 0")
        floatValue1 < 5f -> println("It's less than 5")
        else -> println("It's equal")
    }

    when(floatValue1) { // For multiple conditionals and like switch statement
        2f -> println("Float value is 2")
        3.14f -> println("Float value is 3.14")
        3.15f -> {
            println("Float value is 3.15")
        }
        in 4f..6f -> println("Value is between 4 and 6") // This is range between 4 and 6
    }
}

/* First Control Flow Structure lesson Ends */

/* Second Control Flow Structure lesson Begins */

fun ifLesson2() {
    fun getMessageOneLine(input: Int): String {
        return if (input > 0) "Yes" else "No"
    }
    fun getMessage(input: Int): String {
        return if (input > 0) {
            "Value is positive"
        } else {
            "Value is negative"
        }
    }
    val someVariable = 6
    val message = if(someVariable == 5) {
        "The value is equal to 5"
    } else {
        "the value $someVariable is not equal to 5"
    }

    println(message)

    val checkIfPositive = getMessageOneLine(5)
    println(checkIfPositive)
    val checkIfNegative = getMessage(-5)
    println(checkIfNegative)
    // We can do the same with when
    val number = 1
    val messageWhen = when (number) {
        3 -> "The value is equal to 3"
        else -> "the value is not equal to 3"
    }
    println(messageWhen)

    fun getMessageWhen(number: Int): String = when (number) { // You can define function like this with when and with if statement
        3 -> "The value is equal to 3"
        else -> "the value is not equal to 3"
    }
    println(getMessageWhen(number))
}

/* Second Control Flow Structure lesson Ends */


/* Third Control Flow Structure lesson Begins */

fun tryCatchBlockLesson() {
    try {
        val message = "The value is ${10 / 0}" //
    } catch (e: Throwable) {
        println("Error: ${e.message}")
    }

    // I can use try/catch as expression
    val message = try { // This helps to catch error and use default value if something is wrong
        throw IllegalStateException("error") // We can throw exceptions by ourselves and define message of those exceptions
        "the value is ${10 / 0}" // Division by 0 is invalid
    } catch (e: IllegalStateException) { // Before Throwable/ArithmeticException was used, but you can use more specific ones
        "Error: ${e.message}" // if catch can't catch error it will throw exception
        // if we try to print IllegalStateException message it will be null because we didn't define the message
    }
    println(message)

}

/* Third Control Flow Structure lesson Ends */

/* Fourth Control Flow Structure lesson Begins */

fun smartCastingLesson() {
    fun checkType(input: Any?) { // Checking string variable type which can be null
        if (input is String?) { // Checking if variable is string
            // After checking input type we can access that input type parameters
            println("The value is nullable string")
            // For example
            println("The value is nullable string and value length is ${input?.length}")
            // It's allowed because of smart casting, and it's only allowed in this scope where input is checked
        }

        if (input is String) { // I use nullable string after checking it if I give some string to parameter like "Hello" it will still work
            // In fact both String? and String will pass the check
            // After checking input type we can access that input type parameters
            println("The value is string")
            // For example
            println("The value is string and value length is ${input.length}")
            // It's allowed because of smart casting, and it's only allowed in this scope where input is checked
        }

        if (input !is Int) { // Checking if variable is not an int
            println("The value is not an int")
        } else {
            println("The value is an int")
        }
    }

    fun checkTypeNull(input: Any?) { // Check string variable type which can be null
//        if (input == null) { // this checks if value is null and if it's null it will return nothing which ends the function
//            return
//        }

        if (input is String?) { // We can check if string is null with help of smart casting
            if (input == null) {
                return
            } else {
                // After checking input type we can access that input type parameters
                println("The value is nullable string")
                // For example
                println("The value is nullable string and value length is ${input?.length}")
                // It's allowed because of smart casting, and it's only allowed in this scope where input is checked
            }
        }

        if (input is String) { // I use nullable string, after checking it if I give some string to parameter like "Hello" it will still work
            // In fact both String? and String will pass the check
            // After checking input type we can access that input type parameters
            println("The value is string")
            // For example
            println("The value is string and value length is ${input.length}")
            // it's allowed because of smart casting, and it's only allowed in this scope where input is checked
        }

        if (input !is Int) { // Checking if variable is not an int
            println("The value is not an int")
        } else {
            println("The value is an int")
        }
    }
    // casting value means changing type of variable
    val aGenericVariable: Any = 5 // This is defined as Any variable type
    val anIntGenericVariable: Int = aGenericVariable as Int // We cast variable to int

    val aSecondGenericVariable: Any = "String" // This is defined as Any variable type
//    val anSecondIntGenericVariable: Int = aSecondGenericVariable as Int // We try casting string to int, but it's not possible

//    checkType("labas ") // It will pass as string and nullable string
    val checkNullable1: String? = null
//    checkType(checkNullable1)

    val checkNullable2: String? = "John"
    checkType(checkNullable2) // Since I defined nullable string it will pass both checks, string and nullable string when string is not null
    checkType(checkNullable1) // Since it's null it will pass only nullable string
    println()
    checkTypeNull(checkNullable1) // It will print nothing since it return when value is null
    checkTypeNull(checkNullable2) // It will string case
}

/* Fourth Control Flow Structure lesson Ends */

/* Fifth Control Flow Structure lesson Begins */

fun whileLoopLesson() {
    var i = 0
    while (i < 10) { // While loop from 0 to 10
        println(i)
        i++
        if (i == 8) { // Break while loop if index is equal to 8
            break
        }
        // If we want to brake on first loop iteration we should use do while instead
    }
    println()
    i = 0
    do {
        println(i)
        i += 1 // This loop runs at least one time
    } while (i < 10)
}

/* Fifth Control Flow Structure lesson Ends */

/* Sixth Control Flow Structure lesson Begins */

fun forLoopLesson() {
    for (i in 1..10) { // We use i variable iterating in specified range like in python both 1 and 10 is incluseive
        println(i)
    }

    for (i in 0 until 10) { // This loop uses infix function (infix functions can be created) 0 is inclusive and 10 is exclusive
        println("Using with until $i")
    }

    for (i in 10 downTo 0) { // 10 is inclusive and 0 is exclusive
        println("Count down to zero, countdown: $i")
    }

    for (i in 10 downTo 0 step 2) { // 10 is inclusive and 0 is exclusive using step infix function
        println("Count down to zero with defined step 2, countdown: $i")
    }

}

/* Sixth Control Flow Structure lesson Ends */

/* Challenge Control Flow Structure lesson Begins */

fun flowControlChallenge1() {
    fun getOutput(input:Any?): String = when (input) {
        is Number -> when (input) {
            !is Int -> "Input is not an Int"
            else -> "Input was a non-int number"
        }
        is String -> "Input is String with length ${input.length}"
        null -> "Input is Null"
        else -> "Input didn't match target type"
    }

    println(getOutput(null))
    println(getOutput(4))
    println(getOutput(3.2))
    println(getOutput("Hello World!"))
    println(getOutput('a'))
}

/* Challenge Control Flow Structure lesson Ends */

/* First Debugging lesson brake point functionality Begins */

fun debuggingLesson1() {
    fun getRandomInt(): Int {
        return Random.nextInt() // included Random
    }
    for (i in 1..4) {
        val random = getRandomInt()
        // You can use conditional brake point pressing second mouse button on brake point
        // You can use this scope variables if brake point is in this scope
        // You can disable brake point
        // You can select one or all thread to brake code
        // You can disable and enable condition of brake points
        // There are more setting like invoke code when brake point was hit
        // You can filter classes and others
        // You can make that brake point hits only once
        val isEven = random.rem(2) == 1 // num.rem() // Gets the reminder of division in this case by 2
        when(isEven) {
            true -> println("$random even")
            false -> println("$random false")
        }
    }
}

/* First Debugging lesson brake point functionality Ends */

/* Second Debugging lesson Evaluate Expressions and watches Begins */

fun debuggingLesson2() {
    fun getRandomInt(): Int {
        return Random.nextInt() // included Random
    }
    for (i in 1..4) {
        val random = getRandomInt()
        // Let's try to use watches
        // With debugging you can set values
        // With debugging you can add class level watch
        // With debugging you can add simple value watch
        // In debugging pressed on three dots you can use evaluate expression
        // With watch we can constantly track expressions with variable that we are watching
        val isEven = random.rem(2) == 1 // num.rem() // Gets the reminder of division in this case by 2
        when(isEven) {
            true -> println("$random even")
            false -> println("$random false")
        }
    }
}

/* Second Debugging lesson Evaluate Expressions and watches Ends */

/* First Collection lesson arrays Begins */
fun arraysLesson() {
    val ints = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val intsNullable = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, null) // Kotlin defines automatically nullable type arrays if it sees null value in array

    val intPrimitiveArray = intArrayOf(1, 2, 3, 4, 5) // This is for defining value

    val intPrimitiveSecondArray: IntArray = intArrayOf(1, 2, 3, 4, 5) // Defining type of IntArray

    val nulls = arrayOfNulls<Int>(10) // Defining of nullable int array of 10 elements

    val custom = Array(5) { index -> index } // You can define array with lamba, I filled array from 0 to 5 since array size is 5, but you can specify custom lambda for filling an array

    val sizeOfArray = custom.size // Accessing size of array

    val firstValue = ints.get(0) // Accessing first element of array, you can do like this also ints[0]

    val tenthValue = intsNullable[9] // It gets null value
    println(tenthValue)

    val elementOutOfRange = ints.getOrNull(11) // It returns null if index is out of range with this function
    println(elementOutOfRange)

    val element = ints.getOrElse(-1) {
        println("Wrong index it will return default value")
        return@getOrElse 0
    } // If I can't get 10th element it calls lambda it must return default value after some code
    println(element)

    // Let's set value
    nulls.set(0, 1) // This is function for setting value to array
    nulls[0] = 1 // This is syntax sugar for setting value same as getting values

    val primitiveUShortArray = ushortArrayOf(11u, 2u, 3u, 5u, 7u, 8u, 9u)

    println()
    for (index in primitiveUShortArray.indices) { // Can go through array indexes in array
        println(primitiveUShortArray[index])
    }

    println()
    for (element in primitiveUShortArray) { // Can go through elements in array
        println(element)
    }

    println()
    for (index in 0 until primitiveUShortArray.size) { // Can go through array indexes in array
        println(primitiveUShortArray[index])
    }

    println()
    primitiveUShortArray.forEachIndexed { index, element -> println(element) } // For each of indexes with lambda

    fun greetThings(greeting: String, items: Array<Any>) {
        for (item in items) {
            println("$greeting $item")
        }
    }

    greetThings("Hello! ", arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)) // For this new instance of array will need to be created
    greetThings("HEYYY", custom as Array<Any>)
    // var args modifier
    fun greetThingsVarArg(greeting: String, vararg items: Any) { // Vararg variables is treated as array in complier
        for (item in items) {
            println("$greeting $item")
        }
    }

    greetThingsVarArg("Hey", "item1", "item2", "item3")
}
/* First Collection lesson arrays Ends */

/* Second Collection lesson lists Begins */

fun listsLesson() {
    val stringList: List<String> = listOf("Kotlin", "Java", "Python", "JavaScript") // Created list of strings
    val intList: List<Int?> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, null) // Created nullable list of int
    val doubleValuesList =
        List<Int>(5) { index -> index * 2 } // Initialized list of 5 and added values is index multiply of 2
    doubleValuesList.forEachIndexed { index, value -> println("$index: $value") } // Go through list and printing index and value
    val emptyStringList = emptyList<String>() // Defined empty string list
    val emptyStringList2: List<String> = emptyList() // We can do it like this also
    val emptyStringList3: List<String> = emptyList<String>() // Like this also
    val firstInt = intList[0]
    val firstInt2 = intList.get(1)
    val firstInt3 = intList.getOrNull(11) // If I use index that's out of range it will return null
    val firstInt4 = intList.getOrElse(11) { 0 } // If I index out of range it will return 0 by default
    // List<String> or other type list that's defined like this is non-mutable
    val languages = mutableListOf("Java", "Python", "PythonScript") // These are mutable lists
    val languages2: MutableList<String> = mutableListOf("Java", "Python", "PythonScript")
    val languages3: MutableList<String> = mutableListOf<String>("Python", "PythonScript")
    val languages4: List<String> = mutableListOf("Python", "PythonScript") // We can do it like this also, bot now I cant access mutable list functions since its definde as non-mutable list
    // We can do that because mutable lists extends simple list functionality

    // This is the same ways as changing values in array
    languages.set(0, "John")
    languages[0] = "Mark"
    languages.add("Kotlin") // We can add element at the end
    languages.add(3, "Unknown language") // We can insert to the list like this
    languages.addAll(listOf("Java", "Python", "PythonScript")) // We can add another list to the end or specified index
    languages.addAll(2, listOf("Java", "Python", "PythonScript"))
    languages.removeAt(1)
    languages.remove("Java")
}

/* Second Collection lesson lists Ends */

/* Third Collection lesson sets and maps Begins */

fun setsAndMapsLesson() {
    val languages: Set<String> = setOf("Java", "Python", "Python", "PythonScript", "Java", "JAVA") // Sets can't insert exactly same duplicates
    // this set is non-mutable
    for (language in languages) {
        println(language)
    }
    languages.size
    println(languages.contains("Java"))
    println()
    // This set is mutable
    val mutableLanguages: MutableSet<String> = mutableSetOf("Java", "Python", "PythonScript")
    mutableLanguages.add("C#")
    mutableLanguages.remove("Java")
    for (language in mutableLanguages) {
        println(language)
    }
    println()
    val languageMap: Map<Int, String> = mapOf(Pair(1, "Java"), Pair(2, "Python"), Pair(3, "Java")) // This is one type of creating pairs
    val languageMap2: Map<Int, String> = mapOf(1 to "Java", 5 to "Python", 3 to "Java") // We can use infix for creating pairs instead of functions
    languageMap.forEach { (key, value) -> println("$key: $value") }
//    languageMap[1] = "Java" // This will not work because we are using non-mutable map
    println(languageMap2[5])
    println(languageMap[5]) // If key is not set in map it will return null
    println()
    for (language in languageMap2) {
        println("Language $language") // It will print key=value
        println(languageMap[language.key]) // It will print only value, cause we take kay and with that we're accessing value
        println(language.value) // We can also get value without key directly from object
    }
    println()
    // We can go through values like this also
    for ((id, value) in languageMap) {
        println("$id = $value")
    }
    println()
    val languageMutableMap: MutableMap<Int, String> = mutableMapOf(Pair(1, "Java"), Pair(2, "Python"), Pair(3, "Java"))
    languageMutableMap.forEach { (key, value) -> println("$key: $value") }
    println()
    languageMutableMap[5] = "Javascript"
    languageMutableMap.forEach { (key, value) -> println("$key: $value") }

    // We can check if value or key is in map
    println(languageMutableMap.containsKey(5))
    println(languageMutableMap.containsValue("Java"))

    languageMutableMap[46] = "C++"
    languageMutableMap.put(77, "GO") // We can insert like this also
    languageMutableMap.set(44, "Rust") // We can set like this
    languageMutableMap.remove(1) // We can remove by index
    languageMutableMap.remove(2, "Python") // We can remove by key and value
    println()
    languageMutableMap.forEach { (key, value) -> println("$key: $value") }
    println()
    // We can go through keys with foreach or other loop
    languageMutableMap.keys.forEach { key -> println("$key") }
    // We can go through values list with foreach or other loop
    languageMutableMap.values.forEach { value -> println(value) }

}

/* Third Collection lesson sets and maps Ends */

/* Fourth Collection lesson working wit collections Begins */

fun workingWithCollectionsLesson() {
    val readOnlyList: List<String> = listOf("Java", "Python", "PythonScript")
    val readOnlySet: Set<String> = setOf("Java", "Python", "PythonScript")
    val readOnlyMap: Map<String, String> = mapOf("Java" to "Python", "Python" to "PythonScript")

    val mutableList = mutableListOf("Java", "Python", "PythonScript")
    val mutableSet = mutableSetOf("Java", "Python", "PythonScript")
    val mutableMap = mutableMapOf(2 to "Python", 1 to "PythonScript")

    // These are same for every collection
    readOnlyList.size
    mutableList.size
    readOnlyMap.isEmpty()
    mutableSet.isEmpty()
    mutableMap.isNotEmpty()

    mutableMap.forEach { (key, value) -> println("$key: $value") }
    println()
    for (language in readOnlySet) {
        println(language)
    }
    println()
    mutableSet.first()
    // Map doesn't have take first value
    mutableMap.filter { entry -> entry.key < 2 }
    readOnlyList.filter { value -> value.length > 5 }
    val languages = mapOf("Kotlin" to 5, "Java" to 3, "Python" to 4, "PythonScript" to 5, "C++" to 6 )
    languages.filter { it.value >= 4 }
        .map { it.key }  // Get keys that it's more than 4
        .sorted() // It sorts by value which is string
        .forEach { value -> println(value) } // It prints keys which is value  because we took keys

}

/* Fourth Collection lesson working wit collections Ends */

/* Fifth Collection lesson working wit collections Begins */

fun sequencesLesson() {
    val languages = listOf("Java", "Python", "PythonScript")
        .filter { it.length > 4 }
        .map { it.length } // This is called intermediate collections which is eagerly processed, it carries out for every element
    // this can be computational wasteful

    val languageSequence = sequenceOf("Java", "Python", "PythonScript") // This works depth first instead fo breath first
    val formIterable = listOf(1, 2, 3).asSequence()
    languageSequence.filter { it.length > 4 }.map { it.length }.take(2) // We can use same as list or any other collection with lambda
    // With sequence each element is transformed and evaluated until terminal operator is reached
    // With iterable it goes every item by every item from start to beginning firs would be filtered for every item, then map for every item, then take only two items from all result before
    // With sequence we call first filter for first item, then map for first item and then take for first item if everything is passed before and after taking two items it stops since it have all items
    // The sequence usage depend on usage if collection is big if collection is using a lot of filtering and so on

}

/* Fifth Collection lesson working wit collections Ends */

/* Challenge Collections Begins */

fun collectionsChallenge() {
    val testScore = mapOf( // Student id and test score
        "123abc" to 88.1,
        "123xyz" to 88.9,
        "345abc" to 82.1,
        "345bbc" to 72.1,
        "34efbc" to 66.1,
        "345abc" to 89.1,
        "385agc" to 62.1,
        "837abc" to 85.7,
        "945bc" to 94.3,
        "nd2192" to 83.8,
    )
    val testScoreResults = testScore
        .toList()
        .sortedBy { (key, value) -> value }
        .map {pair -> pair.first}.
        take(3)

    for (score in testScoreResults) {
        println("Student id = $score")
    }
    println()
    val testScores2 = testScore
        .iterator()
        .asSequence()
        .sortedBy { (key, value) -> value }
        .map { (key, value) -> key}
        .take(3)
        .forEach { id -> println("Student id: $id") }


}

/* Challenge Collections Ends */

/* First I/O lesson working with command-line arguments Begins */

fun ioArgumentsLesson(args: Array<String>) {

    if (args.isEmpty()) {
        println("Pass at least one argument")
        return
    } else {
        for (arg in args) {
            println("Arg: $arg")
        }
    }

}

/* First I/O lesson working with command-line arguments Ends */

/* Second I/O lesson working with receiving inputs Begins */

fun receivingInputsLesson(args: Array<String>) {
    print("Enter a filename: ")
    val filename = readLine() ?: "default.txt" // readln() can't be empty, but readLine can be null
    println("File name: $filename")

    val isValidFile = File(filename).isFile
    println("Valid file: $isValidFile")

}

/* Second I/O lesson working with receiving inputs Ends */


/* Third I/O lesson working with file reading and writing Begins */

fun fileReadWriteLesson(args: Array<String>) {
    print("Enter a filename: ")
    val filename = readLine() ?: "default.txt" // readln() can't be empty, but readLine can be null
    // readLine() is for older kotlin below version 1.6 for newer version you should use readln()
    val isValidFile = File(filename).isFile
    if (isValidFile) {
        println("File name exists: $filename")
        val scoreFile = File(filename) // File instance for reading and writing
        scoreFile.forEachLine { line -> println(line) } // Go through all line
        val sortedLines = scoreFile.readLines().sorted() // Sort lines
        val outputFile = File("SortedScores.txt").toPath() // Create result file
        outputFile.writeLines(sortedLines) // Write all sorted lines to file
    } else {
        println("File doesn't exist")
    }

}

/* Third I/O lesson working with reading and writing Ends */

/* Challenge I/O Begins */

fun ioChallenge(args: Array<String>) {
    print("Enter a filename: ")
    val filename = readln()
    val isValidFile = File(filename).isFile
    if (isValidFile) {
        val scoreFile = File(filename)
        val scoreFileLines = scoreFile.readLines()

        // First way to split files in to data and result
        val splitResults = scoreFileLines.map { line -> line.split(':').map { it -> it} }.map { (key, value) -> key to value }
        val sortedResults = splitResults.sortedByDescending { (key, score) -> score }.map { (key, value) -> "$key:$value" }.take(3)
        //

        // Second way in to splitting lines in to data and getting result
        val splitResultsSec = scoreFileLines.map { line ->
            val lineParts = line.split(':')
            lineParts[0] to lineParts[1]
        }
        val sortedResultsSecond = splitResultsSec.sortedByDescending { it.second }
            .map { (key, value) -> "$key:$value" }
            .take(3)

        sortedResults.forEach { value -> println(value) }
        print("Enter a filename to save results: ")
        val resultsFileName = readln()
        val resultFileNameWitExtension = "$resultsFileName.txt"
        val resultsFile = File(resultFileNameWitExtension).toPath()
        resultsFile.writeLines(sortedResults)
        val secFilenameWithExtension = "${resultsFileName}2.txt"
        val secResultsFile = File(secFilenameWithExtension).toPath()
        secResultsFile.writeLines(sortedResultsSecond)
    } else {
        println("File doesn't exist")
    }
}

/* Challenge I/O Ends */

/* First testing lesson working with writing JUnit tests Begins */



/* First testing lesson working with writing JUnit tests Ends */
/* First testing lesson working with writing JUnit tests Begins */

fun getRandomNumber(max: Int): Int {
    return Random.nextInt(max)
}

/* First testing lesson working with writing JUnit tests Ends */