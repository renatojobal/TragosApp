package com.renatojobal.tragosapp.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import com.renatojobal.tragosapp.data.model.Drink

@Dao
interface TragosDao {

    @Query("SELECT * FROM Drink")
    suspend fun getAllFavoriteDrinks(): List<Drink>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(trago:Drink )

    @Delete
    suspend fun deleteDrink(trago: Drink)

}