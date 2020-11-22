package com.example.madlevel5task2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.database.GameRepository
import com.example.madlevel5task2.model.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel (application: Application) : AndroidViewModel(application){

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    private val  ioScope = CoroutineScope(Dispatchers.IO)
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    /**
     * Add a game to the repository if the input is valid.
     */
    fun insertGame(game:  Game){
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }
}