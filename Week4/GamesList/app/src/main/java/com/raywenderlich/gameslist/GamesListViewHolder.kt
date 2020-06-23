package com.raywenderlich.gameslist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GamesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var gameImageView = itemView.findViewById<ImageView>(R.id.gameImage)
    var gameDescription = itemView.findViewById<TextView>(R.id.gameString)
}