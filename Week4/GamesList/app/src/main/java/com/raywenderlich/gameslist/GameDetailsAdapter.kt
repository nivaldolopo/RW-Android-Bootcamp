package com.raywenderlich.gameslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.RecyclerView

class GameDetailsAdapter(var game: Game): RecyclerView.Adapter<GameDetailsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameDetailsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_details_view_holder, parent, false)
        return GameDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: GameDetailsViewHolder, position: Int) {
        holder.gameCover.setImageResource(game.poster)
        holder.gameTitle.text = buildSpannedString {
            bold { append(game.title) }
        }
        holder.gameReleaseDate.text = buildSpannedString {
            bold { append("Release Date: ") }
            append(game.releaseDate)
        }
        holder.gameDeveloper.text = buildSpannedString {
            bold { append("Developer: ") }
            append(game.developer)
        }
        holder.gamePublisher.text = buildSpannedString {
            bold { append("Publisher: ") }
            append(game.publisher)}
        holder.gamePlatform.text = buildSpannedString {
            bold { append("Platform: ") }
            append(game.plataform)}
        holder.gamePlot.text = buildSpannedString {
            bold { append("Plot: ") }
            append(game.plot)}

    }

}