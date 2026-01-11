package com.yassinelakdimi.studybuddy.ui.utils



import java.util.Calendar

object MotivationalQuotes {

    private val quotes = listOf(
        "Small progress is still progress.",
        "Stay focused. Stay consistent.",
        "One study session at a time.",
        "Your future self will thank you.",
        "Discipline beats motivation.",
        "Focus on the process, not the result.",
        "Study now, relax later."
    )

    fun getDailyQuote(): String {
        val dayIndex = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        return quotes[dayIndex % quotes.size]
    }
}
