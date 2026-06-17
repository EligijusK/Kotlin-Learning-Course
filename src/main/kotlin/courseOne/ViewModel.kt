package org.example.courseOne

class ViewModel(private val analyticsClient: AnalyticsClient) {
    fun submitClicked() {
        analyticsClient.track("Submit Clicked") // if we comment this out interface defined function is not implemented and it throws error
    }
}