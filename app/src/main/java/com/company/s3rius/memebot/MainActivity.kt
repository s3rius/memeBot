package com.company.s3rius.memebot

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.FragmentActivity
import com.company.s3rius.memebot.ui.Chats
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError

class MainActivity : FragmentActivity() {
    //    private val preferences: SharedPreferences = getPreferences(Context.MODE_PRIVATE)!!
    private var userId: String = ""
    private var accessToken: String = ""

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val preferences = getPreferences(Context.MODE_PRIVATE)
        if (!VKSdk.isLoggedIn() || preferences.getString("accessToken", "fail") == "fail" || preferences.getString("userId", "fail") == "fail") {
            VKSdk.login(this, VKScope.MESSAGES, VKScope.FRIENDS, VKScope.WALL)
        } else
            startMemesFlow()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                val preferences = getPreferences(Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("accessToken", res?.accessToken)
                editor.putString("userId", res?.userId)
                editor.apply()
                accessToken = preferences.getString("accessToken", "fail")
                userId = preferences.getString("userId", "fail")
                startMemesFlow()
            }

            override fun onError(error: VKError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun startMemesFlow() {
        val preferences = getPreferences(Context.MODE_PRIVATE)
        accessToken = preferences.getString("accessToken", "failed")
        userId = preferences.getString("userId", "failed")
        val manager = supportFragmentManager
        val chats = Chats.newInstance(accessToken, userId)
        manager.beginTransaction()
                .replace(R.id.fragment_container, chats)
                .commit()
    }
}
