package org.example.courseTwo

private val hourInMilis = 60*60*1000 // Top level property

private val minuteInMilis = 60*1000

internal fun millisForMinutesFunc(minutes: Int) = minutes * minuteInMilis // Internal means that only this module project can access this function

internal fun millisForHoursFunc(minutes: Int) = minutes * hourInMilis


// This variable is value of variable that's been called to
fun Int.millisForHours() = this * hourInMilis // This is function extensions for Int

fun Int.millisForMinutes() = this * minuteInMilis // This is function extensions for Int