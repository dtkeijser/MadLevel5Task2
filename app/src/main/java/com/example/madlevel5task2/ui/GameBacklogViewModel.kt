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

class GameBacklogViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val gameBacklog = gameRepository.getGames()

    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    fun deleteGameBacklog() {
        mainScope.launch {

            withContext(Dispatchers.IO) {
                gameRepository.deleteHistory()
            }

        }
    }

    fun deleteGame(game: Game) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.delete(game)
            }
        }
    }

}