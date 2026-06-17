import courseOne.getRandomNumber
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {

    /* First testing lesson working with writing JUnit tests Begins */

    @Test // define this as test
    fun verifyTrueIsAlwaysTrue() { // test example assertion of true
        assert(true == true)
    }

    @Test
    fun `getRandom returns value between 1 and 5`() { // this is teste example positive test
        val randomNumber = getRandomNumber(5)
        assert(randomNumber in 1..5)
    }


    // this is for JUnit 4, but I'm using JUnit 5
//    @Test(expected = IllegalArgumentException::class)
//    fun `getRandomNumber throws exception when negative value is passed`() {
//        getRandomNumber(-5)
//
//    }


    // this iw new way of doing asserting throw exceptions in JUnit 5
    @Test
    fun `getRandomNumber throws exception when negative value is passed`() {
        assertThrows(IllegalArgumentException::class.java) {
            getRandomNumber(-5)
        }

    }



}