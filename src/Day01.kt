import java.io.File
import java.util.*

fun main() {

    fun parseInput(input: String): List<List<Int>> = input.split("\n\n").map { elf:String ->
        elf.split("\n").map { it.toInt() }
    }

    fun List<List<Int>>.topNElves(n: Int): Int {
        val best: TreeSet<Int> = sortedSetOf<Int>()
        for (calories:Int in map { it.sum()}) {
            best.add(calories)
            if (best.size > n) {
                best.remove(best.first())
            }
        }
        return best.sum()
    }

    fun part1(input: String): Int {
        val data: List<List<Int>> = parseInput(input)
        return data.topNElves(3)
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")

    //check(part1(testInput) == 1)

    val input = File("src/input.txt").readText()
    part1(input).println()
    //part2(input).println()
}
