package com.example.ba2_info_projectriverraid


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

import com.example.ba2_info_projectriverraid.GameView
import com.example.ba2_info_projectriverraid.utils.DifficultyAndData

class MainActivity : AppCompatActivity() {
    lateinit var gameView: GameView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameView = findViewById<GameView>(R.id.gameView)
        }
}

    override fun onResume() {
        super.onResume()
        gameView.resume()
    }
    override fun onPause() {
        super.onPause()
        gameView.pause()
    }

    companion object DifficultyDataManager {
        private var _difficulty: DifficultyAndData = DifficultyAndData.EASY
        fun setDifficulty(difficultyAndData: DifficultyAndData) {
            _difficulty = difficultyAndData
        }

        public fun getData(): DifficultyAndData {
            return _difficulty
        }
    }
}