package com.imaginato.homeworkmvvm.data.local.userroomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract  fun userDataDao(): UserDataDao

    companion object{

        // this for send update to other thread to changed in this instance
        @Volatile
        private  var INSTANCE :UserDatabase? = null

        fun getDataBase(context: Context): UserDatabase{

            if(INSTANCE==null){

                // this block first complete execute code then other task will be execute
                synchronized(this){

                // this for  initialization of Database object only one time when app is installed
                    INSTANCE = Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,
                        "userdataDB").build()
                }

            }
        return  INSTANCE!!
        }
    }

}