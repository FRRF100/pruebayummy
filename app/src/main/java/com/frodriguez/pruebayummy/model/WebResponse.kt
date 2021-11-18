package com.frodriguez.pruebayummy.model

import com.frodriguez.pruebayummy.model.story.Story

data class WebResponse(
    val hits: List<Story>
)