package com.its.food.delivery.util

// HTTP RESPONSE -----------------------------------------------------------------------------------

const val HTTP_NO_CONTENT = 204
const val HTTP_200 = 200
const val HTTP_500 = 500
const val BUNDLE_KEY = "bundle"
const val FOOD_ENTITY_KEY = "foodEntity"
const val SEARCH_KEY = "searchKey"
const val TEXT_TAB = "txt_tab"

// ERROR CODE --------------------------------------------------------------------------------------

enum class ErrorCode {
    HTTP_ERROR,
    CONNECT_ERROR,
    UNAUTHORIZED,
    FORBIDDEN,
    UNKNOWN_ERROR
}

// ROLE --------------------------------------------------------------------------------------------
const val ADMIN = "admin"
const val EMPLOYEE = "employee"


// FETCH LIMITER -----------------------------------------------------------------------------------

const val GET_FOODS = "getFoods"