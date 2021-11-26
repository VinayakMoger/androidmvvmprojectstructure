package com.microsoft.projectstructure.utility

import org.json.JSONObject

fun getErrorResponse(jsonObject: JSONObject): String {
    try {
        if (jsonObject.has("description")) {
            return jsonObject.getString("description")
        }
    } catch (e: Exception) {
    }
    return ""
}