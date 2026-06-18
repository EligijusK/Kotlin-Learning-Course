package org.example.courseTwo

private val hourInMilis = 60*60*1000 // Top level property

private val minuteInMilis = 60*1000

internal fun milisForMinutes(minutes: Int): Int = minutes * minuteInMilis // Internal means that only this module project can access this function

internal fun milisForHours(minutes: Int): Int = minutes * hourInMilis