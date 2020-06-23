package com.raywenderlich.gameslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameDetails : AppCompatActivity() {

    //TODO use synthetics  and not lateinit
    lateinit var game: Game
    lateinit var gameDetailsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_details)
        game = intent.getParcelableExtra<Game>(MainActivity.INTENT_GAME_KEY) as Game
        title = game.title

        gameDetailsRecyclerView = findViewById(R.id.game_details_recyclerview)
        gameDetailsRecyclerView.layoutManager = LinearLayoutManager(this)
        gameDetailsRecyclerView.adapter = GameDetailsAdapter(game)


    }
}
