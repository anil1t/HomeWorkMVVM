package com.imaginato.homeworkmvvm.data.local.userroomdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UserDataDao {
    // for add query to insert data in database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserData(userData: UserData)
}