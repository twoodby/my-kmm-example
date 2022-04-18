package com.twoodby.mykmmexample

import kotlinx.serialization.Serializable

@Serializable
data class XkcdResponse(
    val img: String,
    val title: String,
    val day: Int,
    val month: Int,
    val year: Int,
)
