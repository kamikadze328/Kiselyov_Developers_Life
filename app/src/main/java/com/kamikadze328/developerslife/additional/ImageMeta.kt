package com.kamikadze328.developerslife.additional

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.json.JSONException
import org.json.JSONObject


@Parcelize
open class ImageMeta(val description: String, val gifURL: String) : Parcelable {
    companion object {
        fun jsonObjectToImageMeta(json: JSONObject): ImageMeta {
            val description = getString("description", json)
            val gifURL = getString("gifURL", json)

            /*
            val author = getString("author", json)
            val votes = getInt("votes", json)
            val commentsCount = getString("commentsCount", json)
            val canVote = getBoolean("canVote", json)
            val date = getString("date", json)
            val type = getString("type", json)
            val id = getInt("id", json)
            val height = getInt("height", json)
            val width = getString("width", json)
            val fileSize = getInt("fileSize", json)
            val gifSize = getInt("gifSize", json)
            val previewURL = getString("previewURL", json)
            val videoPath = getString("videoPath", json)
            val videoSize = getInt("videoSize", json)
            val videoURL = getString("videoURL", json)
            */
            return ImageMeta(description, gifURL)
        }

        private fun getString(name: String, json: JSONObject): String {
            return try {
                json.getString(name)
            } catch (e: JSONException) {
                ""
            }
        }

        private fun getBoolean(name: String, json: JSONObject): Boolean {
            return try {
                json.getBoolean(name)
            } catch (e: JSONException) {
                false
            }
        }

        private fun getInt(name: String, json: JSONObject): Int {
            return try {
                json.getInt(name)
            } catch (e: JSONException) {
                0
            }
        }
    }


}
