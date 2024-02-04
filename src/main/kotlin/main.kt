package ru.netology

import kotlin.math.max
const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2
const val ERROR_LIMIT_VK = -3

fun main () {
    println(comission("Visa", 10_000, 0))
    println(comission("Мир", 1000, 0))
    println(comission("Vk Pay", 15_000, 20_000))
    println(comission("Mastercard", 200, 0))

}
fun comission(typeCard : String, transfer: Int, previous:Int): Int = when (typeCard){
    "Visa", "Мир" -> if (transfer < 150_000 && transfer + previous <= 600_000) {
        max(35, (transfer * 0.0075).toInt())
    }else {
        ERROR_LIMIT
    }
    "Mastercard", "Maestro" -> if (300 <= transfer + previous && transfer + previous <= 75_000) {
        0
    }else {
        (transfer * 0.006 + 20).toInt()
    }
    "Vk Pay" -> if (transfer <= 15_000 && transfer + previous <= 40_000) {
        0
    }else {
        ERROR_LIMIT_VK
    }
    else -> ERROR_TYPE
}