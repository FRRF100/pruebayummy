package com.frodriguez.pruebayummy.model.story

import com.frodriguez.pruebayummy.model.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoriesLocalDataSource @Inject constructor() {

    fun getStories(db: AppDatabase): List<Story> {
        return db.storyDao().getAll()
    }

    fun getExcludedStories(db: AppDatabase): List<DeletedStory> {
        return db.deletedStoryDao().getAll()
    }

}