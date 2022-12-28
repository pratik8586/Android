package com.example.interview.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Category::class,Item::class], version = 1)
abstract class InterviewDatabase : RoomDatabase() {

    abstract fun homeDao(): CategoryDao
    abstract fun itemDao(): ItemDao

    companion object {
        private var instance: InterviewDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): InterviewDatabase {
            if(instance == null)
//                instance = Room.databaseBuilder(ctx.applicationContext, InterviewDatabase::class.java,
//                    "interview_database")
//                    .fallbackToDestructiveMigration()
//                    .addCallback(roomCallback)
//                    .build()

                instance = Room.databaseBuilder(ctx.applicationContext, InterviewDatabase::class.java, "sqlite.db")
                        .createFromAsset("database/sqlite.db")
                        .fallbackToDestructiveMigration()
                        .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
//                populateDatabase(instance!!)
            }
        }

//        private fun populateDatabase(db: InterviewDatabase) {
//            val noteDao = db.homeDao()
//            subscribeOnBackground {
//                noteDao.insert(Note("title 1", "desc 1", 1))
//                noteDao.insert(Note("title 2", "desc 2", 2))
//                noteDao.insert(Note("title 3", "desc 3", 3))
//
//            }
//        }
    }
}