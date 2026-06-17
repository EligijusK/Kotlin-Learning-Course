package org.example.courseTwo


//abstract class Person { // Abstract class
//    abstract val age: Int // Abstract variable
//}

// Open class can be extended, by default kotlin class can't be extended
open class Person( // Person class with parameters
    age: Int,
    private val firstname: String, // Variable definition of class can be done like this
    private val lastname: String, // Private variable can't be accessed outside this class
    protected val height: Int // Protected variable can be accessed in extended class only
) {

    init { // Class initialization code block
        check(age >= 0) {
            "Age must be greater than 0"
        }
        check(age < 120) {
            "Age must be less than 120"
        }
    }

    val age: Int = age // If Age is less than 0 or grater then 120 compiler will throw error

    // Open option can be used on functions
    open fun printName() = println("$firstname $lastname")
}