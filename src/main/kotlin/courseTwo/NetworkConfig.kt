package org.example.courseTwo

object NetworkConfig: NetworkInfoProvider { // Object can't be created more than once so its singleton
    val baseUrl = "http://<someURL>"
    val userAgent = "demo-app"
    override fun getNetworkDetails(): String {
        return "$baseUrl/$userAgent"
    }
}