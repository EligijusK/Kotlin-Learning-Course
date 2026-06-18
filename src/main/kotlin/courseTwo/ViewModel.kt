package org.example.courseTwo

import kotlin.properties.Delegates


class ViewModel {

    var currentQuery: String by Delegates.observable("") { // Created delegate that's observes value
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

    val logger: Logger by lazy { // this is lazy delegate what will be initialized on first use
        println("Initializing logger")
        ApplicationLogger(SimpleLogger())
    }

    fun search(query: String) { // this will log search of query
        logger.log("query", query)
        currentQuery = query
    }
}