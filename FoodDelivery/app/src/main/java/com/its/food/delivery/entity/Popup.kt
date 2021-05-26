package com.its.food.delivery.entity

import java.io.Serializable

data class Popup(
    val foodId: String,
    var popupTitle: String,
    var popupMessage: String,
): Serializable