
private val input = readInput("day4input")

fun main() {

    fun parseInput(input: String): List<String> {
        return input.split("\n").map { it }
    }


    val ranges: List<Pair<IntRange, IntRange>> = input.map{it.asRanges()}

    fun part1(): Int {
        return ranges.count {it.first fullyOverlaps it.second || it.second fullyOverlaps it.first}
    }

    fun part2(): Int {
        return ranges.count { it.first overlaps it.second }
    }








    part2().println()
}

infix fun IntRange.fullyOverlaps(other: IntRange): Boolean =
    first <= other.first && last >= other.last

infix fun IntRange.overlaps(other: IntRange): Boolean =
    first <= other.last && other.first <= last


fun String.asRanges(): Pair<IntRange, IntRange> =
    substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

fun String.asIntRange(): IntRange =
    substringBefore("-").toInt()..substringAfter("-").toInt()