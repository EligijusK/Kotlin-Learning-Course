package courseTwo

import kotlinx.coroutines.*


private suspend fun refreshTasks() { // Simple function can't be suspended unless we add suspend keyword
    delay(3000)
    println("Refreshing tasks on ${Thread.currentThread().name}")
}

private suspend fun refreshReservations() {
    delay(3000)
    println("Refreshing reservations on ${Thread.currentThread().name}")
}

private fun refreshUser () {
    println("Refreshing user on ${Thread.currentThread().name}")
}

private fun updateUI() {
    println("Updating UI on ${Thread.currentThread().name}")
}

private fun cancelEverything(vararg jobs: Job) {
    jobs.forEach { it.cancel() }
}

fun main(): Unit = runBlocking { // In the same coroutine code runs sequentially

//    val tasks = async { refreshTasks() } // this is async tasks
//    val reservations = async { refreshReservations() }
//    awaitAll(tasks, reservations) // It awaits for async tasks to finish
//    updateUI()


//    refreshTasks()
//    refreshReservations()
//    withContext(Dispatchers.Main) { // this moves back to main thread
//
//    }


//    launch (Dispatchers.IO) { // This is how to create child coroutine
//        refreshTasks()
//        refreshReservations()
//
//
//    }

    val refreshCoroutine = launch {
        val tasks = async { refreshTasks() } // this is async tasks
        val reservations = async { refreshReservations() }
        awaitAll(tasks, reservations) // It awaits for async tasks to finish
        updateUI()
    }

    // Dispatchers.IO Moves coroutine on to worker threads
    val job = launch { refreshUser() }
    job.cancel() // this will cancel this job

    cancelEverything(job, refreshCoroutine)
}