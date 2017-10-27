package com.company.s3rius.memebot.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.company.s3rius.memebot.R
import com.company.s3rius.memebot.utils.ChatsAdapter


class Chats : Fragment() {
    lateinit var userId: String
    lateinit var accessToken: String

    companion object {
        fun newInstance(accessToken: String, userId: String): Chats {
            val bundle = Bundle()
            bundle.putString("accessToken", accessToken)
            bundle.putString("userId", userId)
            val chats = Chats()
            chats.arguments = bundle
            return chats
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accessToken = arguments!!.getString("accessToken", "-1")
        userId = arguments!!.getString("userId", "-1")
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_chats, container, false)
        val recycler: RecyclerView = view.findViewById(R.id.chatsRecycler)
        val manager = LinearLayoutManager(context)
        recycler.layoutManager = manager
        val adapter = ChatsAdapter(context, accessToken, userId)
        recycler.adapter = adapter
        return view
    }

}
