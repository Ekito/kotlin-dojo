package dojo

import org.junit.Assert
import org.junit.Test

/**
 * Created by arnaud on 29/09/2016.
 */


class FirstTest {

    @Test
    fun testThatEmptyStringReturnsZero() {
        val calculator = StringCalculator()
        Assert.assertEquals(0, calculator.sum(""))
    }

    @Test
    fun testThatSingleNumberReturnsItsvalue() {
        val calculator = StringCalculator()
        Assert.assertEquals(42, calculator.sum("42"))
    }

    @Test
    fun testThatTwoCommaSeparatedNumbersReturnsTheirSum() {
        val calculator = StringCalculator()
        Assert.assertEquals(84, calculator.sum("42,42"))
    }

    @Test
    fun testThatTwoNewlineSeparatedNumbersReturnsTheirSum() {
        val calculator = StringCalculator()
        Assert.assertEquals(84, calculator.sum("42\n42"))
    }

    @Test
    fun testThatThreeNumbersSeparatedEitherWayReturnsTheirSum() {
        val calculator = StringCalculator()
        Assert.assertEquals(126, calculator.sum("42,42\n42"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testThatNegativeNumbersThrowException() {
        val calculator = StringCalculator()
        calculator.sum("-42")
    }
}