package com.company.s3rius.memebot.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.company.s3rius.memebot.R
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatsAdapter(context: Context, accessToken: String, userId: String) : RecyclerView.Adapter<ChatsAdapter.Holder>() {
    var context = context
    var offset = 0
    var count = 50
    val accessToken = accessToken
    var items = 0

    init {
        downloadDialogues()
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.chat_cardview, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return items
    }

    private fun downloadDialogues() {
        var retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(context.getString(R.string.apiExecute))
                .build()
        val apiCall = retrofit.create(ApiCalls::class.java)
        var chats = apiCall.getChats("getChats", offset, count, accessToken)
        chats.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it -> it.response }
                .map { it -> it.map { it -> it.title } }
                .subscribe { it ->
                    offset += count
                    for (s: String? in it) {
                        items++
                        Log.d("chats_vkApi_10101", s)
                    }
                }

    }

    class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var chatImg: ImageView = itemView!!.findViewById(R.id.dialogue_image)
        var chatLabel: TextView = itemView!!.findViewById(R.id.dialogue_name)
        var membersCount: TextView = itemView!!.findViewById(R.id.members_count)
    }
}