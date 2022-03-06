package com.example.challenge.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "items_table")
data class Items(
     @PrimaryKey(autoGenerate = true) val id: Int,
     @ColumnInfo(name = "itemNum") val itemNum: String,
     @ColumnInfo(name = "locked") val locked: Boolean
):Serializable

