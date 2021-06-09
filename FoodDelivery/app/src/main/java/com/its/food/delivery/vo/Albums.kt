package com.its.food.delivery.vo

import com.fasterxml.jackson.annotation.JsonProperty

data class Albums(
    @JsonProperty("albumId")
    val albumId: String,
    @JsonProperty("id")
    var id: String,
    @JsonProperty("title")
    var title: String,
    @JsonProperty("url")
    var url: String,
    @JsonProperty("thumbnailUrl")
    var thumbnailUrl: String,
)