package org.example.courseTwo

class SearchController {
    private var query: String = ""

    companion object {

        // If it was public it could be accessed outside
        private const val MAX_RESULTS = 5 // Even if it's private it can still be accessed in Search controller scope

        init {
//            SearchController.MAX_RESULTS // It can be referenced like this
//            MAX_RESULTS // Or like this
        }

        fun create(initialQuery: String): SearchController {
            val controller = SearchController()
            controller.query = initialQuery
            return controller
        }
    }
}