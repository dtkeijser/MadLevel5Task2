package com.example.madlevel5task2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.database.GameRepository
import com.example.madlevel5task2.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddViewModel(application: Application) : AndroidViewModel(application) {


    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    /**
     * Add a game to the repository if the input is valid.
     */
    fun addGame(title: String, platform: String, day: String, month: String, year: String) {
        if (validateGame(title, platform, day, month, year)) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    gameRepository.insertGame(
                        Game(
                            title,
                            platform,
                            Utils.dayMonthYearToCalendar(day.toInt(), month.toInt(), year.toInt())
                        )
                    )
                }
                success.value = true
            }
        }
    }

    /**
     * Validate if a game has a title, platform and a valid Date in the Calendar.
     */
    private fun validateGame(
        title: String,
        platform: String,
        day: String,
        month: String,
        year: String
    ): Boolean {

        if (title.isBlank()) {
            error.value = "Please fill in a title"
            return false
        }


        if (platform.isBlank()) {
            error.value = "Please fill in a platform"
            return false
        }


        try {
            day.toInt()
            month.toInt()
            year.toInt()
        } catch (ex: NumberFormatException) {
            error.value = "Please fill in the release date fields."
            return false
        }


        try {
            Utils.dayMonthYearToCalendar(day.toInt(), month.toInt(), year.toInt()).time
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
            error.value = "Please fill in a valid date."
            return false
        }

        return true
    }

}