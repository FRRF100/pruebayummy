package com.frodriguez.pruebayummy.app

import com.frodriguez.pruebayummy.viewmodel.StoryViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationGraph {

    fun inject(model: StoryViewModel)

}