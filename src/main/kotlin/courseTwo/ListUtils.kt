package org.example.courseTwo

fun <T> Array<T>.toNonEmptyList(): List<T> {
    check(this.isNotEmpty()) {
        "List is empty"
    }
    return this.toList()
}
fun <T> Set<T>.toNonEmptyList(): List<T> {
    check(this.isNotEmpty()) {
        "List is empty"
    }
    return this.toList()
}

//class ListUtils {
//
//
//    companion object {
//        fun <T> nonEmptyList(vararg list: T): List<T> {
//            check(list.isNotEmpty()) {
//                "List is empty"
//            }
//            return list.toList()
//        }
//
//        fun <T> setToNonEmptyList(list: Set<T>): List<T> {
//            check(list.isNotEmpty()) {
//                "List is empty"
//            }
//            return list.toList()
//        }
//    }
//}