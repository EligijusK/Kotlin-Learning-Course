package org.example.courseTwo

fun main(args: Array<String>) {
//    classesLesson(args)
//    interfacesLesson(args)
//    enumsLesson(args)
    dataClassesLesson(args)
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