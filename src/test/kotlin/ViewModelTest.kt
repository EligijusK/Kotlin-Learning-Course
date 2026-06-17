import org.example.courseOne.AnalyticsClient
import org.example.courseOne.ViewModel
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito

class ViewModelTest {

    /* Second testing lesson working with mocking data Begins */

    @Test
    fun `trackedEvent() is called when submitClicked is called`() {
        val analytics = Mockito.mock(AnalyticsClient::class.java) // this is mocking data of analytics class
        val viewModel = ViewModel(analytics)

        viewModel.submitClicked()
        Mockito.verify(analytics).track(anyString()) // we can use matches for dynamic arguments
        // ArgumentMatchers is random string or other random type for arguments
    }

    /* Second testing lesson working with mocking data Ends */
}