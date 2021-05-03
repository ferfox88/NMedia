package ru.netology.dto

fun translatingCount(count: Int): String {
    val countK = count / 1000
    val countM = count / 1_000_000
    if (count < 1000) {
        return "$count"
    } else if (count in 1000..1099) {
        return "${countK}K"
    } else if (count in 1100..9999) {
        return "$countK.${countK % 10}K"
    } else if (count in 10000..999_999) {
        return "${countK}K"
    } else if (count in 1_000_000..1_099_999) {
        return "${countM}M"
    }else {
        return "$countM.${countM % 10}M"
    }
}