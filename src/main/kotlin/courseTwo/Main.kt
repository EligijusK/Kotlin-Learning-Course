package org.example.courseTwo

fun main(args: Array<String>) {
    classesLesson(args)

}

/* First Object-Oriented lesson working with classes Begins */

fun classesLesson(args: Array<String>) {
    val person: Person = Student(15, "John", "Smith", 175)
    person.age
    person.printName()

}

/* First Object-Oriented lesson working with classes Ends */