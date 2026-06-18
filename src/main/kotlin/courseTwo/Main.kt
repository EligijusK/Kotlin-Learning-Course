package org.example.courseTwo

fun main(args: Array<String>) {
//    classesLesson(args)
    interfacesLesson(args)
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