package com.example.challenge.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challenge.domain.model.Items

@Dao
interface ItemsDAO {
    @Query("SELECT * FROM items_table") suspend fun getItems():List<Items>
    @Insert()  suspend fun insertNews(items: List<Items>)
    @Query("UPDATE ITEMS_TABLE SET locked = 'f' WHERE id =2") suspend fun unlockItem()

}