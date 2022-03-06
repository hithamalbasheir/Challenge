package com.example.challenge.data

import android.app.Application
import androidx.room.Room
import com.example.challenge.domain.model.Items
import android.content.Context

object DatabaseModule {
    private var INSTANCE: ItemsDatabase? = null

    fun getInstance(application: Application): ItemsDatabase {
        if (INSTANCE == null) {
            synchronized(ItemsDatabase::class) {
                INSTANCE = getItemsDB(application)
            }
        }
        return INSTANCE!!
    }
    fun getItemsDB(application: Application): ItemsDatabase{
        return Room.databaseBuilder(application.applicationContext,ItemsDatabase::class.java,"items_DB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    fun getDao(itemsDatabase: ItemsDatabase):ItemsDAO{
        return itemsDatabase.itemsDao()
    }
}