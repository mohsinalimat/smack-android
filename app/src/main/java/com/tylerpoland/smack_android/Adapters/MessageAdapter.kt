package com.tylerpoland.smack_android.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tylerpoland.smack_android.Model.Message
import com.tylerpoland.smack_android.R
import com.tylerpoland.smack_android.Services.UserDataService

class MessageAdapter(val context: Context, val messages: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMessage(context, messages[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage = itemView.findViewById<ImageView>(R.id.messageUserAvatarView)
        val timeStamp = itemView.findViewById<TextView>(R.id.messageTimeStampText)
        val userName = itemView.findViewById<TextView>(R.id.messageUserNameText)
        val msgBody = itemView.findViewById<TextView>(R.id.messageBodyLabel)

        fun bindMessage(context: Context, message: Message) {
            val resourceId = context.resources.getIdentifier(message.userAvatar, "drawable", context.packageName)
            userImage.setImageResource(resourceId)
            userImage.setBackgroundColor(UserDataService.returnAvatarColor(message.userAvatarColor))
            userName.text = message.userName
            timeStamp.text = message.timestamp
            msgBody.text = message.message
        }
    }
}