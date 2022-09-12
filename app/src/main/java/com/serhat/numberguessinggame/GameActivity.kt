package com.serhat.numberguessinggame

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.serhat.numberguessinggame.databinding.ActivityGameBinding
import java.util.*

class GameActivity : AppCompatActivity() {
    private val context: Context by lazy { this }
    private val binding: ActivityGameBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_game)}

    private val rand: Random = Random()
    private val randomNumber: Int = rand.nextInt(100) + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.gameActivity = this
        binding.turns = 5
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun guess(numStr: String) {
        if (numStr.isEmpty()) {
            Toast.makeText(context, getString(R.string.msg_enter_a_number), Toast.LENGTH_SHORT).show()
        } else {
            val num = numStr.toInt()

            if (num == randomNumber) {
                val game = Game(context)
                game.updateWins()

                Toast.makeText(context, getString(R.string.msg_congratulations), Toast.LENGTH_SHORT).show()
                onBackPressed()
            } else {
                binding.turns--

                if (binding.turns == 0) {
                    Toast.makeText(context, getString(R.string.msg_game_over), Toast.LENGTH_SHORT).show()
                    onBackPressed()
                } else {
                    if (num > randomNumber) {
                        Toast.makeText(context, getString(R.string.msg_pick_a_lower_number), Toast.LENGTH_SHORT).show()
                        binding.imgHint.setImageDrawable(getDrawable(R.drawable.ic_down))
                    } else {
                        Toast.makeText(context, getString(R.string.msg_pick_a_higher_number), Toast.LENGTH_SHORT).show()
                        binding.imgHint.setImageDrawable(getDrawable(R.drawable.ic_up))
                    }
                }
            }
        }
    }
}