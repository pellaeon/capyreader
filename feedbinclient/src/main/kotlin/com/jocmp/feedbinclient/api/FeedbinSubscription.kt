package com.jocmp.feedbinclient.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeedbinSubscription(
    val id: Int,
    val created_at: String,
    val feed_id: Int,
    val title: String,
    val feed_url: String,
    val site_url: String
)