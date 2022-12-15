import java.io.File
import java.util.*

fun main() {



    fun getPoints(guideString: String):Int {
    when (guideString) {
        "A X" -> return 3
        "B X" -> return 1
        "C X" -> return 2
        "A Y" -> return 4
        "B Y" -> return 5
        "C Y" -> return 6
        "A Z" -> return 8
        "B Z" -> return 9
        "C Z" -> return 7

    }

    return -1
    }


    fun parseInput(input: String) : List<String>{
        return input.split("\n").map { it }
    }

    fun part1(input: String): Int {
        val scoreArr = parseInput(input).map { getPoints(it) }
        return scoreArr.sum()
    }




    //   fun part2(input: List<String>): Int {
    //     return
    //}

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")

    //check(part1(testInput) == 1)

    val input = File("src/day2input.txt").readText()
    part1(input).println()
}
//part2(input).println()

