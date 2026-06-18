package org.example.courseTwo

sealed class StringResult {
    data class Success(val result: String) : StringResult()
    data class Failure(val error: Throwable) : StringResult()
}