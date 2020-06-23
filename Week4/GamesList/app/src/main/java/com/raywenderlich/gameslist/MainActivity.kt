package com.raywenderlich.gameslist

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GamesListAdapter.GameDetailsClickListener {

    //TODO use synthetics  and not lateinit
    private lateinit var gamesListRecyclerView: RecyclerView

    companion object {
        const val INTENT_GAME_KEY = "game"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        gamesListRecyclerView = findViewById(R.id.games_list_recyclerview)
        gamesListRecyclerView.layoutManager = LinearLayoutManager(this)
        gamesListRecyclerView.adapter = GamesListAdapter(this)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionAbout) {
            showInfo()
        }
        return true
    }

    private fun showInfo() {
        //Toast.makeText(this, "nivaldo lopo", Toast.LENGTH_LONG).show()
        val dialogTitle = getString(R.string.aboutTitle)
        val dialogMessage = getString(R.string.aboutMessage)

        val builder = AlertDialog.Builder(this)
        builder.setTitle(dialogTitle)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }

    //create intent to show game details activity
    private fun showGameDetails(game: Game) {
        val intentShowGame = Intent(this, GameDetails::class.java)
        intentShowGame.putExtra(INTENT_GAME_KEY, game)
        startActivity(intentShowGame)
    }

    override fun gameClicked(game: Game) {
        showGameDetails(game)
    }
}
