package com.example.challenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.challenge.domain.model.Items

@Database(entities = [Items::class], version = 99, exportSchema = false)
abstract class ItemsDatabase : RoomDatabase(){
    abstract fun itemsDao(): ItemsDAO
}