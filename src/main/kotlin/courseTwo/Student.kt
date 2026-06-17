package org.example.courseTwo

class Student(
    age: Int, // There are no val because its passing values to person constructor
    firstname: String,
    lastname: String,
    height: Int
): Person(age, firstname, lastname, height) {

    override  fun printName(){
        super.printName() // Invoke original function
        println("$age years old")
        println("Student's height is: $height")
    }
}