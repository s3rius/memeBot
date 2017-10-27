package com.company.s3rius.memebot.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

class ApiChats : Serializable {

    @SerializedName("response")
    @Expose
    var response: List<Response> = ArrayList()

    companion object {
        private const val serialVersionUID = 2878415250166672275L
    }

}
