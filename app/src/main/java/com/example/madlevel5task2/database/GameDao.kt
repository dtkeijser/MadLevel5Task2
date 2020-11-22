package com.example.madlevel5task2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.madlevel5task2.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable ORDER BY `release` ")
    fun getGames():LiveData<Game?>

    @Insert
    suspend fun insert(game: Game)

    @Delete
    suspend fun delete(game: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAll()
}