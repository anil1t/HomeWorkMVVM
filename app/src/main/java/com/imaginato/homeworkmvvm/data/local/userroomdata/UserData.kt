package com.imaginato.homeworkmvvm.data.local.userroomdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// this entity for define table structure in database
@Entity(tableName = "userdata")
data class UserData constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "userId") var userId: String,
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "isDeleted") var isDeleted: Boolean,
    @ColumnInfo(name = "x_Acc") var x_Acc: String
)