package dojo

/**
 * Created by arnaud on 10/10/2016.
 */

class StringCalculator {
    fun sum(input: String): Int {
        //return input.split(",").map { s -> Integer.parseInt(s) }.fold(0, (acc, i) ->  {acc + i})
        if (input.isEmpty())
            return 0
        else {
            return input.split(",").flatMap { s -> s.split("\n") }.map { s -> Integer.parseInt(s) }.map(this::checkPositiveNumber).sum()
        }
    }

    fun checkPositiveNumber(s: Int): Int {
        when {
            s >= 0 -> return s
            else -> throw IllegalArgumentException("number is negative ! $s")
        }
    }
}