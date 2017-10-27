package com.company.s3rius.memebot.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class Response : Serializable {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("admin_id")
    @Expose
    var adminId: Int = 0
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("users")
    @Expose
    var users: List<User> = ArrayList()
    @SerializedName("push_settings")
    @Expose
    var pushSettings: PushSettings? = null
    @SerializedName("photo_50")
    @Expose
    var photo50: String? = null
    @SerializedName("photo_100")
    @Expose
    var photo100: String? = null
    @SerializedName("photo_200")
    @Expose
    var photo200: String? = null

    companion object {
        private const val serialVersionUID = 3459544983150759533L
    }

}
