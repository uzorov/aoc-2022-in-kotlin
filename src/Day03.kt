import java.io.File

fun main() {

    fun parseInput(input: String): List<String> {
        return input.split("\n").map { it }
    }


    fun getCodeNumber(i: Char): Int {
        return if (i.code > 96) i.code - 96
        else i.code - 38
    }

    fun compareAndReturnNextSum(sortedstringsPart1: String, sortedstringsPart2: String): Int {
        for (i in sortedstringsPart1) {
            for (j in sortedstringsPart2) {
                if (i == j) return getCodeNumber(i)
            }
        }

        return -999999
    }


    fun part1(input: String): Int {
        val sortedStrings_first_part = parseInput(input).map { it.substring(it.length / 2) }
        val sortedStrings_second_part = parseInput(input).map { it.substring(0, it.length / 2) }

        var sum = 0
        for (i in sortedStrings_first_part.indices) {
            sum += compareAndReturnNextSum(sortedStrings_first_part[i], sortedStrings_second_part[i])
        }


        return sum
    }

    fun compareAndReturnNextSumForManyEls(s: String, s1: String, s2: String): Int {

        s.forEach {
            if ((s1.indexOf(it) != -1) and (s2.indexOf(it) != -1))
                {
                return getCodeNumber(it)
            }
        }

        return -9999999
    }

    fun part2(input: String): Int {
        val listOfElvesItems: List<String> = parseInput(input)
        var sum = 0
        for (i in listOfElvesItems.indices step 3) {
            sum += compareAndReturnNextSumForManyEls(listOfElvesItems[i],
                                                     listOfElvesItems[i+1],
                                                     listOfElvesItems[i+2])
        }
        return sum
    }


    //   fun part2(input: List<String>): Int {
    //     return
    //}

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")

    //check(part1(testInput) == 1)

    val input = File("src/day3input.txt").readText()
    part2(input).println()
}


//part2(input).println()

