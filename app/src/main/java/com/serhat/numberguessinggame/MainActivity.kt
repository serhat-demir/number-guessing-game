package com.serhat.numberguessinggame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.serhat.numberguessinggame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val context: Context by lazy { this }
    private val binding: ActivityMainBinding by lazy {DataBindingUtil.setContentView(this, R.layout.activity_main)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainActivity = this
    }

    override fun onResume() {
        val game = Game(context)
        binding.wins = game.wins

        super.onResume()
    }

    fun startGame() {
        val intent = Intent(context, GameActivity::class.java)
        startActivity(intent)
    }
}