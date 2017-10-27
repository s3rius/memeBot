package com.company.s3rius.memebot.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class PushSettings : Serializable {
    @SerializedName("sound")
    @Expose
    var sound: Int = 0
    @SerializedName("disabled_until")
    @Expose
    var disabledUntil: Int = 0


    companion object {

        private const val serialVersionUID = 4323757307626483932L
    }

}
