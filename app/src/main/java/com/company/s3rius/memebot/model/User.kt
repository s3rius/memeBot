package com.company.s3rius.memebot.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Serializable {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("photo_100")
    @Expose
    var photo100: String? = null
    @SerializedName("invited_by")
    @Expose
    var invitedBy: Int = 0
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

    companion object {
        private const val serialVersionUID = 8820583509118723525L
    }

}
