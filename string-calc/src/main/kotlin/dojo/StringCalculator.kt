package dojo

/**
 * Created by arnaud on 10/10/2016.
 */


private fun checkPositiveNumber(s: Int): Int {
    return when {
        s >= 0 -> s
        else -> throw IllegalArgumentException("number is negative ! $s")
    }
}

private fun extractDelimiter(input: String): Pair<String, String> {
    return when {
        input.startsWith("//") -> Pair(input.substring(2, 3), input.substring(4))
        else -> Pair(",", input)
    }
}


class StringCalculator {
    fun sum(input: String): Int {
        if (input.isEmpty())
            return 0
        else {
            val (separator, numberString) = extractDelimiter(input)
            return numberString.split("\n").flatMap { it.split(separator) }
                    .map (Integer::parseInt)
                    .map(::checkPositiveNumber)
                    .filter { it <= 1000 }
                    .sum()
        }
    }


}