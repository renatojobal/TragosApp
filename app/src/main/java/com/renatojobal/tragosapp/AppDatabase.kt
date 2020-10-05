package com.renatojobal.tragosapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.renatojobal.tragosapp.data.model.Drink
import com.renatojobal.tragosapp.domain.TragosDao

@Database(entities = arrayOf(Drink::class), version = 2)
abstract class AppDatabase : RoomDatabase(){

    abstract fun tragoDao() : TragosDao



}