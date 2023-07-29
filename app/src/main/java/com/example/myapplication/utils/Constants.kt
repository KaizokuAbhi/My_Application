package com.example.myapplication.utils

object Constants {
    const val baseurl="https://newsapi.org"
    const val apikey="b3f4f7b18ef64758aaac5a910e36ef4f"
    const val TOTAL_TAB_COUNT=7
    const val GENERAL_NEWS="general"
    const val SCIENCE_NEWS= "science"
    const val HEALTH_NEWS="health"
    const val ENTERTAINMENT_NEWS="entertainment"
    const val BUSINESS_NEWS="business"
    const val TECHNOLOGY_NEWS="technology"
    const val SPORTS_NEWS="sports"

    fun getNewsCategory(tabPos: Int): String {
        return when(tabPos) {
            1 -> {
                "business"
            }
            2 -> {
                "entertainment"
            }
            3 -> {
                "environment"
            }
            4 -> {
                "food"
            }
            5 -> {
                "health"
            }
            6 -> {
                "politics"
            }
            7 -> {
                "science"
            }
            8 -> {
                "sports"
            }
            9 -> {
                "technology"
            }
            10 -> {
                "top"
            }
            11 -> {
                "world"
            }
            else -> {
                ""
            }
        }
    }
}