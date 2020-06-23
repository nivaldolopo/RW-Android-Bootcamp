package com.raywenderlich.gameslist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var gameCover = itemView.findViewById<ImageView>(R.id.gameCover)
    var gameTitle = itemView.findViewById<TextView>(R.id.gameTitle)
    var gameReleaseDate = itemView.findViewById<TextView>(R.id.gameReleaseDate)
    var gameDeveloper = itemView.findViewById<TextView>(R.id.gameDeveloper)
    var gamePublisher = itemView.findViewById<TextView>(R.id.gamePublisher)
    var gamePlatform = itemView.findViewById<TextView>(R.id.gamePlatform)
    var gamePlot = itemView.findViewById<TextView>(R.id.gamePlot)
}