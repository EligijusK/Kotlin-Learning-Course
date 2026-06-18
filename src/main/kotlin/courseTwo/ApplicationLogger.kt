package org.example.courseTwo


// created delegate of logger
class ApplicationLogger(
    private val delegate: Logger,
) : Logger by delegate // This fowards all calls to logger, this could be used for combining multiple interfaces