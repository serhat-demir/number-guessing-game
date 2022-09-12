package com.serhat.numberguessinggame

import android.content.Context

class Game(context: Context) {
    private val preferences = context.getSharedPreferences("Game", Context.MODE_PRIVATE)
    private val spEditor = preferences.edit()

    var wins: Int = 0

    init {
        wins = preferences.getInt("wins", 0)
    }

    fun updateWins() {
        spEditor.putInt("wins", wins + 1)
        spEditor.commit()
    }
}