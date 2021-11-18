package com.frodriguez.pruebayummy.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.frodriguez.pruebayummy.model.story.DeletedStory
import com.frodriguez.pruebayummy.model.story.DeletedStoryDao
import com.frodriguez.pruebayummy.model.story.Story
import com.frodriguez.pruebayummy.model.story.StoryDao

@Database(entities = [Story::class, DeletedStory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun storyDao(): StoryDao
    abstract fun deletedStoryDao(): DeletedStoryDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "stories-list.db")
            .build()
    }
}
