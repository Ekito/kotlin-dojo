package dojo

import org.junit.Assert
import org.junit.Test

/**
 * Created by arnaud on 29/09/2016.
 */


class FirstTest {

    private val stringCalculator: StringCalculator
        get() {
            val calculator = StringCalculator()
            return calculator
        }

    @Test
    fun testThatEmptyStringReturnsZero() {
        Assert.assertEquals(0, stringCalculator.sum(""))
    }

    @Test
    fun testThatSingleNumberReturnsItsvalue() {
        Assert.assertEquals(42, stringCalculator.sum("42"))
    }

    @Test
    fun testThatTwoCommaSeparatedNumbersReturnsTheirSum() {
        Assert.assertEquals(84, stringCalculator.sum("42,42"))
    }

    @Test
    fun testThatTwoNewlineSeparatedNumbersReturnsTheirSum() {
        Assert.assertEquals(84, stringCalculator.sum("42\n42"))
    }

    @Test
    fun testThatThreeNumbersSeparatedEitherWayReturnsTheirSum() {
        Assert.assertEquals(126, stringCalculator.sum("42,42\n42"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testThatNegativeNumbersThrowException() {
        stringCalculator.sum("-42")
    }

    @Test
    fun testThatNumbersGreaterThan1000AreIgnored() {
        Assert.assertEquals(42, stringCalculator.sum("1001\n42"))
    }


    @Test
    fun testSingleCharDelimiterFirstLine() {
        Assert.assertEquals(42, stringCalculator.sum("//#\n41#1"))
    }

    @Test
    fun testSingleMultiCharsDelimiterFirstLine() {
        Assert.assertEquals(42, stringCalculator.sum("//[###]\n41###1"))
    }

    //@Test
    fun testSingleMultiCharsDelimiterFirstLineFoo() {
        //FIXME
        Assert.assertEquals(42, stringCalculator.sum("//[###] \n41###1"))
    }

}
