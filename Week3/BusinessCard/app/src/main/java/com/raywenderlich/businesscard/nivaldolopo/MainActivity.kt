package com.raywenderlich.businesscard.nivaldolopo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    internal lateinit var buttonQRCode: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonQRCode = findViewById(R.id.buttonQRCode)

        buttonQRCode.setOnClickListener { view ->
            //set animation to the button
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(bounceAnimation)

            //start new activity that shows the qr code
            val intent = Intent(this, ShowQrCode::class.java)
            startActivity(intent)
        }

    }
    //add menu to show the design attribution
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.designAttribution) {
            showInfo()
        }
        return true
    }

    private fun showInfo() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.attributionTitle))
        builder.setMessage(getString(R.string.attributionMessage))
        builder.create().show()
    }
}
